package Informal.mybatis.Dao_input_test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Autowiree {
    @Autowired
    private Beanfirst beanfirst;
    public void auto(){
        beanfirst.beani();
        System.out.println("这是注入后的");
    }

}
