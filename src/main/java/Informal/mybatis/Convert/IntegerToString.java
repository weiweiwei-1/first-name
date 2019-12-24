package Informal.mybatis.Convert;

import org.apache.commons.lang3.StringUtils;

//对输入的字符类型进行判断，如果不符合整数类型，而是其他的类型，那么返回false
public class IntegerToString {
    public boolean Stringforint(String s){
        String str=s.trim();
        if(StringUtils.isBlank(str)){
            return false;
        }
        try{
             Integer.parseInt(str);
        }
        catch(NumberFormatException x){
            return false;
        }
         return true;
    }
}
