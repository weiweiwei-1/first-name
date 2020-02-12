package Informal.mybatis.test4.EmailTest;

import Informal.mybatis.Convert.EmailFormatCheck;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailFormatTest {
    public static void main(String args[]) {
        String email = "2198626335@asdfa";
        System.out.println(EmailFormatCheck.isEmail(email));
    }
}
