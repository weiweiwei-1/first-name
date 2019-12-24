package Informal.Spring.Non_annotation.Test;

import Informal.Spring.Non_annotation.Model.Student;
import Informal.Spring.Non_annotation.Model.Student2;
import Informal.Spring.Non_annotation.Model.Teacher;
import Informal.Spring.Non_annotation.Service.Impl.ServiceImpl;
//import Informal.Spring.Non_annotation.Service.Service;
import org.junit.Test;

public class Test2 {
    @Test
            public void outputConstructor()
    {
    Teacher teacher=new Teacher(new Student2());
    teacher.outputStudent2();
   /* Student student;
    teacher.setStudent(student);
    上面的代码不成立，因为没有new一个对象，不能传入到setStudent中去，只能下面这样才能成立*/
   Student student=new Student("篮球","合肥工业大学");
   teacher.setStudent(student);
   teacher.outputStudent();}
   @Test
           public void outputService(){
       ServiceImpl service=new ServiceImpl();
       /*下面的代码不能成立，由于是接口，不能new 一个对象出来*/
//       Service service=new Service();
      service.outputAll();
    }

}
