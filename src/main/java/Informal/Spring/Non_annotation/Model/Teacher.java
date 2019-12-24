package Informal.Spring.Non_annotation.Model;

public class Teacher {
    private Student student;
    private Student2 student2;
    public Teacher(Student2 student2) {
        this.student2 = student2;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void outputStudent(){
        student.outputConstructor();
    }
    public void outputStudent2(){
        student2.Student2information();
    }
}
