package Informal.Spring.Annotation.Test;
import Informal.Spring.Annotation.Aop.Event;
import Informal.Spring.Annotation.Controller.UserController;
import Informal.Spring.Annotation.Model.UserResource;
import Informal.Spring.Annotation.Model.total_Annotation.Include.Teacher;
import Informal.Spring.Annotation.Model.total_Annotation.SpringconfigurationA;
import Informal.Spring.Annotation.Model.total_Annotation.SpringconfigurationB;
import javafx.application.Application;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test1 {
    @Test
    public void testUser(){
        ApplicationContext ac=new
        ClassPathXmlApplicationContext("Informal/Spring/Annotation/User.xml");
        //未设置id，首字母小写定义唯一的id
        UserController userController=(UserController)ac.getBean("userController");
        userController.InsertTest();
    }
    @Test
    public void testUserBean(){
        ApplicationContext ac=new
                ClassPathXmlApplicationContext("Informal/Spring/Annotation/User.xml");
        UserResource ur=(UserResource)ac.getBean("userResource");
        ur.information();
    }
    @Test
    public void totalAnnotation(){
        /*Student student=new Student();
        student.Sinformation();
        student的值是在spring容器中，如果没有加载spring容器，那么值不能被赋
        */
ApplicationContext ac=new AnnotationConfigApplicationContext(SpringconfigurationA.class);
Teacher teacher=(Teacher)ac.getBean("teacher");
//bean的首字母必须要小写，否则不能识别
teacher.Tinformation();
    }
    @Test
    public void testSpringconfigurationB(){
        ApplicationContext ac=new AnnotationConfigApplicationContext(SpringconfigurationB.class);
        Teacher teacher=(Teacher)ac.getBean("teacher");
        teacher.Tinformation();
    }
    @Test
    public void anontaion_aop(){
        ApplicationContext ac=new
        ClassPathXmlApplicationContext("Informal/Spring/Annotation/Aop.xml");
        Event event=(Event)ac.getBean("event");
        event.implement();
        event.ready();
    }
}
