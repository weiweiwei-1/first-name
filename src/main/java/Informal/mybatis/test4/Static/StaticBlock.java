package Informal.mybatis.test4.Static;

public class StaticBlock {

    //静态代码块首先覆盖这些成员变量，使得类一开始被加载，这些不管是静态的还是非静态的成员变量全部被覆盖
    private String a = "初始变量a";
    public String b = "初始变量b";
    private static String c = "初始静态变量c";

    public StaticBlock(String a, String b){
        this.a = a;
        this.b = b;
        System.out.println(a);
        System.out.println(b);
    }

    public StaticBlock(){
        a = "构造函数a";
        b = "构造成员变量b";
    }

    {
        a = "构造块成员变量a";
        System.out.println("构造块1");
        c = "构造块静态成员变量c";
        System.out.println(c);
    }

    private static String d = "测试静态变量和静态代码块d";
    //注意，如果静态代码块有静态变脸d，静态变量d却初始化放到静态代码块后面，那么会出现错误异常。
    static {
        System.out.println("静态代码块1");
        c = "静态成员变量c";
        System.out.println(c);
        System.out.println(d);
    }

    static {
        System.out.println("静态代码块2");
        c = "改变静态成员变量c";
        System.out.println(c);
    }

    //随着程序的运行，给静态变量赋值，静态变量的值可能会改变
    public static void main(String args[]) {
        System.out.println("main函数之后输出的第一个输出");
        StaticBlock staaticBlock = new StaticBlock("构造函数成员变量a","构造函数成员变量b");
    }

    //由上面的结果可以知道各个函数的执行顺序为：静态块，main，构造块，构造方法

}
