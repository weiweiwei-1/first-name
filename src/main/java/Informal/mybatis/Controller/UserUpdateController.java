package Informal.mybatis.Controller;

import Informal.mybatis.Controller.Base.UserUtils;
import Informal.mybatis.Controller.Warning.UpdatePasswordResult;
import Informal.mybatis.Controller.Warning.UserInformationResult;
import Informal.mybatis.Convert.AgeJudge;
import Informal.mybatis.Model.User;
import Informal.mybatis.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RequestMapping(value="/User")
@Controller
public class UserUpdateController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/updateUser",method={RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public Map<String,String> updateUser(@RequestParam(value="username",required=false) String username,
                                         @RequestParam(value="company",required=false) String company,
                                         @RequestParam(value="school",required=false) String school,
                                         @RequestParam(value="age",required=false) String age,
                                         @RequestParam(value="sex",required=false) String sex,
                                         @RequestParam(value="occupation",required=false) String occupation,
                                         @RequestParam(value="hobby",required=false) String hobby,
                                         @RequestParam(value="introduction",required=false) String introduction,
                                         @RequestParam(value="file",required=false) MultipartFile file,
                                         HttpServletRequest request, HttpSession session) throws Exception{
        String symbol = "1";
        Map<String, String> map = new HashMap<>();
        User user = new User();
        String usernameError;
        String companyError;
        String schoolError;
        String ageError;
        String sexError;
        String occupationError;
        String hobbyError;
        String introductionError;
        String fileError;
        System.out.println("用户名："+username+"公司："+company+"学校："+school+"年龄："
                +age+"性别："+sex+"职位："+occupation+"爱好："+hobby+"介绍："+introduction+"文件名称为"+file);
        if (username.length() > 20) {
            usernameError = UserInformationResult.USERNAME_ERROR;
            map.put("usernameError",usernameError);
            symbol = "0";
        }
        if (company.length() > 20) {
            companyError = UserInformationResult.COMPANY_ERROR;
            map.put("companyError",companyError);
            symbol = "0";
        }
        if (school.length() > 20) {
            schoolError = UserInformationResult.SCHOOL_ERROR;
            map.put("schoolError",schoolError);
            symbol = "0";
        }
        if (!AgeJudge.Judge(age)) {
            ageError = UserInformationResult.AGE_ERROR;
            map.put("ageError",ageError);
            symbol = "0";
        }
        if (!"男".equals(sex) && !"女".equals(sex) && !"".equals(sex)) {
            sexError = UserInformationResult.SEX_ERROR;
            map.put("sexError",sexError);
            symbol = "0";
        }
        if (occupation.length() > 20) {
            occupationError = UserInformationResult.OCCUPATION_ERROR;
            map.put("occupationError",occupationError);
            symbol = "0";
        }
        if (hobby.length() > 20) {
            hobbyError = UserInformationResult.HOBBY_ERROR;
            map.put("hobbyError",hobbyError);
            symbol = "0";
        }
        if (introduction.length() > 50) {
            introductionError = UserInformationResult.INTRODUCTION_ERROR;
            map.put("introductionError",introductionError);
            symbol = "0";
        }
        if (symbol.equals("0")) {
            map.put("symbol",symbol);
            return map;
            //先开始条件判定，如果文字内容不符合要求，先进行拦截返回错误数据
        } else if (file != null) {
//            如果传入的图片不为空，那么将图片写入磁盘
            String originalFileName = file.getOriginalFilename();
            if (originalFileName != null && originalFileName.length() > 0) {
                String photo_path = "E:\\IDEA-workspace\\web-repository\\";
                String newfilename = UUID.randomUUID() + originalFileName.substring(originalFileName.lastIndexOf("."));
                File newFile = new File(photo_path + newfilename);
                file.transferTo(newFile);
                //将原始保存在磁盘的图片也删除，避免占用过多的内存空间
                String oldPhoto = UserUtils.getUserVo().getPhoto();
//                如果是非系统图片，将原来的图片从磁盘删除
                if (!oldPhoto.equals("originImg.jpg")) {
                    File oldFile = new File(photo_path + oldPhoto);
                    oldFile.delete();
                }
                user.setPhoto(newfilename);
                UserUtils.getUserVo().setPhoto(newfilename);
                map.put("photo", newfilename);
            }
            }
            int newAge = Integer.valueOf(age);
            user.setId(UserUtils.getUserVo().getId());
            user.setUsername(username);
            UserUtils.getUserVo().setUsername(username);
            user.setCompany(company);
            UserUtils.getUserVo().setCompany(company);
            user.setSchool(school);
            UserUtils.getUserVo().setSchool(school);
            user.setAge(newAge);
            UserUtils.getUserVo().setAge(newAge);
            user.setSex(sex);
            UserUtils.getUserVo().setSex(sex);
            user.setOccupation(occupation);
            UserUtils.getUserVo().setOccupation(occupation);
            user.setHobby(hobby);
            UserUtils.getUserVo().setHobby(hobby);
            user.setIntroduction(introduction);
            UserUtils.getUserVo().setIntroduction(introduction);
            userService.updateByPrimaryKeySelective(user);
            map.put("symbol", symbol);
            return map;
        }

    @RequestMapping(value="/updatePassword")
    @ResponseBody
    public Map<String, String> updatePassword(String password, String newPassword) {
        String originalPassword = UserUtils.getUserVo().getPassword();
        Map<String, String> map = new HashMap<>();
        if (!originalPassword.equals(password)) {
            map.put("passwordError",UpdatePasswordResult.PASSWORD_ERROR);
            return map;
        } else if (newPassword.length() < 4 || 8 < newPassword.length()) {
            map.put("newPasswordError",UpdatePasswordResult.NEW_PASSWORD_ERROR);
            return map;
        }
        User user =  new User();
        user.setPassword(newPassword);
        user.setId(UserUtils.getUserVo().getId());
        userService.updateByPrimaryKeySelective(user);
        map.put("success",UpdatePasswordResult.UPDATE_SUCCESS);
        return map;
    }
}
