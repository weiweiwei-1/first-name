package Informal.mybatis.test4.Jsontest;


import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class JsonArray_jsonObject {
    @Test
    public void jsontest() {
Map<String,Object> map=new HashMap<String,Object>();
map.put("name","weishao");
List<Object> list=new ArrayList<Object>();
list.add("name");
list.add(22);
map.put("age",22);
System.out.println(map.get("age") instanceof Integer);
for(int i=0;i<list.size();i++){
    System.out.println(list.get(i));
}

    }

    @Test
    public void testJsonformal(){
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("name","weishao");
        map.put("age",22);
//        将map对象转化为json字符串，不能通过key值取得数据
        String json=JSONObject.toJSONString(map);
        System.out.println(json);
//        将map对象转化为json对象
        JSONObject jo=new JSONObject(map);
//        将字符串转化为相应的对象,通过key值可以取得里面的数据
        JSONObject jo1=JSONObject.parseObject(json);
        System.out.println(json);
        System.out.println(jo.get("age"));
        System.out.println(jo1.get("name"));
    }
}
