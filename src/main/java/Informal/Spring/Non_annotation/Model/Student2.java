package Informal.Spring.Non_annotation.Model;

public class Student2 {
    private String name;
    private int age;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public void Student2information(){
        System.out.println("学生2的信息是："+"姓名："+name+" "+"年龄："+age);
    }
}
