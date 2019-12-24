package Informal.mybatis.Convert;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Convert implements Converter<String,Date> {
    @Override
    public Date convert(String s) {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        try{
//            转换成功直接返回
            return simpleDateFormat.parse(s);
        }
        catch(ParseException e){
            e.printStackTrace();
        }
//        绑定失败返回空值
        return null;
    }

}
