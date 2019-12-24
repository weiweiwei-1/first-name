package Informal.Spring.Annotation.Model.total_Annotation.Include;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Student {
    @Value("2015214127")
    private String sno;
    @Value("22")
    private int sage;
    public void Sinformation(){
        System.out.println("学生的信息："+"学号："+sno+" "+"年龄："+sage);
    }
}
