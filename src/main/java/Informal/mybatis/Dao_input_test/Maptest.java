package Informal.mybatis.Dao_input_test;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Maptest {

    public void maptest(){
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("id",12  );
        map.put("username","wei");
        map.put("address","meizhou");
        for(String map1:map.keySet()){
            System.out.println(map.get(map1));
            System.out.println(map.get(map1).getClass().getName());
        }

    }
}
