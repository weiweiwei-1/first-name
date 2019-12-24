package Informal.Spring.Non_annotation.Test;

import Informal.Spring.Non_annotation.Model.Student;
import Informal.Spring.Non_annotation.Model.Teacher;
import Informal.Spring.Non_annotation.Service.Impl.CustomerServiceImpl;
import Informal.Spring.Non_annotation.Service.Impl.ServiceImpl;
import Informal.Spring.Non_annotation.Service.Service;
import Informal.Spring.Non_annotation.Transtraction.Transtraction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.junit.Test;
public class Test1 {

    @Test
    public void testCustomer()
    {
    ApplicationContext ac=new ClassPathXmlApplicationContext("Informal/Spring/Non_annotation/Customer.xml");
    CustomerServiceImpl cs=(CustomerServiceImpl)ac.getBean("CustomerServiceImpl");
    cs.saveCustomer();
}
@Test
    public void testStudent(){
        ApplicationContext ac=new
                ClassPathXmlApplicationContext("Informal/Spring/Non_annotation/Student.xml");
    Student cs=(Student)ac.getBean("Student");
    cs.outputinformation();
    cs.outputConstructor();
    Teacher tc=(Teacher)ac.getBean("teacher");
    tc.outputStudent();
    tc.outputStudent2();
}
@Test
    public void testService(){
        ApplicationContext ac=new
      ClassPathXmlApplicationContext("Informal/Spring/Non_annotation/Service.xml");
    Service si=(ServiceImpl)ac.getBean("Service");
    //用ServiceImpl也是可以的
    si.outputAll();
}
@Test
    public void aop_notAnnotation(){
    ApplicationContext ac=new
            ClassPathXmlApplicationContext("Informal/Spring/Non_annotation/Aop.xml");
    Transtraction transtraction=(Transtraction)ac.getBean("transtraction");
    transtraction.check();
    transtraction.connect();
    transtraction.transport();

}
}
