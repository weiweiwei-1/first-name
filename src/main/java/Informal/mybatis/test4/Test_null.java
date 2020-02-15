package Informal.mybatis.test4;

import Informal.mybatis.Model.User;
import org.junit.Test;
import org.springframework.web.socket.TextMessage;

import java.util.HashMap;
import java.util.Map;

public class Test_null {

    @Test
    public void output(){
        Map<String,Object> map=new HashMap<>();
        map.put("zeng","xiaowei");
        System.out.println(map.get("afdsaf"));
        System.out.println(map.get("aff"));
        for(String o:map.keySet()){
            System.out.println(o);
        }
        System.out.println(map.size());
    }

    @Test
    public void testUser() {
        User user = new User();
        System.out.println(user.getId());
    }
}
