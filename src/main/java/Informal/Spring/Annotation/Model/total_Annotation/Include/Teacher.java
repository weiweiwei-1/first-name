package Informal.Spring.Annotation.Model.total_Annotation.Include;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Teacher {
    @Value("房导")
    private String Tname;
    @Value("女")
    private char Tsex;
    public void Tinformation(){
        System.out.println("教师的信息:"+"名字："+Tname+" "+"性别："+Tsex);
    }
}
