package Informal.mybatis.test4;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class StringTokenizerTest {
    Map<String,String> map=new HashMap<>();
    @Test
    public void normal(String text){
        StringTokenizer str=new StringTokenizer(text,"@");

        System.out.println("数量为："+str.countTokens());
        System.out.println(str.nextToken());
        while(str.hasMoreElements()){
            System.out.println(str.nextToken());
        }
    }


}
