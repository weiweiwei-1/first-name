package Informal.mybatis.Dao_input_test;

import Informal.mybatis.Convert.DateTransform;
import Informal.mybatis.Convert.IntegerToString;
import org.junit.Test;

//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ComplexTest {
    @Test
    public void maptest(){
        Maptest maptest=new Maptest();
        maptest.maptest();
    }

    @Test
    public void DateTransform(){
        DateTransform dateTransform=new DateTransform();
        String s="1995-10-30";
        System.out.println(dateTransform.isDate(s));
    }

    @Test
    public void testDateformat() throws ParseException {
        String s="1996-5-29";
        DateFormat fmt=new SimpleDateFormat("yyyy-MM-dd");
        Date date=fmt.parse(s);
        System.out.println(date);
    }

    @Test
    public void isValidate(){
        DateTransform dateTransform=new DateTransform();
        String s="1995-5-30";
        System.out.println(dateTransform.isValidate(s));
    }
    @Test
    public void testStringandNull(){
        String a="  ";
        String b="";
        String c=a.trim();
        String d;
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
//        System.out.println(d);
    }
    @Test
    public void testITS(){
//        在IntegerToString中，如果没有trim。因此用trim，减少人们因为增加空格重敲而花费的时间。类似下面的数据将会显示错误
        IntegerToString integerToString=new IntegerToString();
        System.out.println(integerToString.Stringforint("123   "));
    }
}
