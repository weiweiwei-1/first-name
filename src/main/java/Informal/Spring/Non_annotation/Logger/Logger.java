package Informal.Spring.Non_annotation.Logger;

public class Logger {
    public void Before(){
        System.out.println("切入点之前输出日志");
    }
    public void Around(){
        System.out.println("环绕配置");
    }
    public void After(){
        System.out.println("切入点后面输出日志");
    }
}
