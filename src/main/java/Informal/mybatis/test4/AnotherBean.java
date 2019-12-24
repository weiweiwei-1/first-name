package Informal.mybatis.test4;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnotherBean {
    @Test
    public void testUser(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("Informal/mybatis/Spring-mybatis_config/Application.xml");
        testUserService testUserService = (testUserService) ac.getBean("testUserService");
        testUserService.testuser();
    }
}
