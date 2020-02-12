package Informal.mybatis.test4.ConverTest;

import Informal.mybatis.Convert.EmailFormatCheck;
import org.junit.Test;

public class ConvertFirst {
    @Test
    public void isEmailTest() {
        System.out.println(EmailFormatCheck.isEmail("21986@sina.com"));
    }
}
