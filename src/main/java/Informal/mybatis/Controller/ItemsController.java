package Informal.mybatis.Controller;

import Informal.mybatis.Convert.DateTransform;
import Informal.mybatis.Dao.ItemsMapper;
import Informal.mybatis.Model.Items;
import Informal.mybatis.Service.ItemsService;
import Informal.mybatis.validatorgroups.updateValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping(value="/itemsRelate")
public class ItemsController {
//    @Autowired
//    private ItemsMapper itemsMapper;

    @Autowired
    private ItemsService itemsService;

    @RequestMapping(value="editItems",method={RequestMethod.GET,RequestMethod.POST})
     public String editItems(Model model,Integer id){
        Items items=itemsService.selectByPrimaryKey(id);
        model.addAttribute("items",items);
        return "Items/editItems";
    }

@RequestMapping("editSubmit")
    public String editSubmit(Model model, @ModelAttribute @Validated(value={updateValidator.class})
        Map<String,String> map,/*Items items,String createtime,*/
    BindingResult bindingResult, /*接收商品的图片  */ MultipartFile items_pic) throws Exception{
        int id=Integer.valueOf(map.get("id"));
        String name=map.get("name");
        Float price=Float.valueOf(map.get("price"));
        String pic=map.get("pic");
        String createtime=map.get("createtime");
        String detail=map.get("detail");
        Items items=new Items();
        items.setId(id);
        items.setName(name);
        items.setPic(pic);
        items.setPrice(price);
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        Date date=dateFormat.parse(createtime);
        items.setCreatetime(date);
        items.setDetail(detail);
        if(bindingResult.hasErrors()){
            FieldError id1=bindingResult.getFieldError();
            if(id1!=null){
                String id_error=id1.getDefaultMessage();
                model.addAttribute("id_error",id_error);
            }
            model.addAttribute("items",items);
            return "Items/editItems";
        }
//        如果没有新的文件传输那么items_pic为“”，originalFilename也为空，会报错，因此将isEmpty排除出去
        if(items_pic!=null/*&&!items_pic.isEmpty()*/){
//            存储图片的物理路径,注意，后面必须加斜杠，不然写入路径不能达到预期的效果
            String pic_path="E:\\IDEA-workspace\\web-repository\\";
//            原始的图片名称
            String originalFilename=items_pic.getOriginalFilename();
//            新的图片名称
            String newfilename= UUID.randomUUID()+originalFilename.substring(originalFilename.lastIndexOf("."));
//            创建file对象
            File file=new File(pic_path+newfilename);
//            将内存中的数据写入磁盘
            items_pic.transferTo(file);
//            如果上传成功，那么将新的图片名称写到items的pic中
            items.setPic(newfilename);
        }
        /*if(!"".equals(createtime)){
            DateTransform dateTransform=new DateTransform();
            if(!dateTransform.isDate(createtime)){
                return "info";
            }
            else{
                DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
                Date date=fmt.parse(createtime);
                items.setCreatetime(date);
            }
        }*/
    itemsService.updateByPrimaryKeySelective(items);
    return "success";
}
}
