package Informal.Spring.Non_annotation.Model;

import java.util.Date;

public class Student {
    private int age;
    private Date birthday;
    private String name;
    private String hobby;
    private String school;

    public Student(String hobby, String school) {
        this.hobby = hobby;
        this.school = school;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthday(Date birthday) {

        this.birthday = birthday;
    }
    public void outputinformation(){
        System.out.println("学生的信息是："+"年龄:"+age+" " +"姓名:"+name+" " +"生日:"+birthday);
    }
    public void outputConstructor(){
        System.out.println("学校和爱好分别是："+school+"和"+hobby);
    }
}
