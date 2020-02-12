package Informal.mybatis.Convert;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailFormatCheck {
    public static boolean isEmail(String email) {
        if (StringUtils.isBlank(email)) {
            return false;
        }
        String str = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
        Pattern p = Pattern.compile(str);
        Matcher m = p.matcher(email);
        return m.matches();
    }
    /*public static boolean isEmail(String email) {
        boolean symbol = true;
        if (email == null) {
            symbol = false;
        } else {
            String regEx1 = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
            Pattern p = Pattern.compile(regEx1);
            Matcher m = p.matcher(email);
            if (!m.matches()) {
                symbol = false;
            }
        }
    return symbol;
    }*/
}
