package Informal.Spring.Annotation.Aop;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class log1 {
@Pointcut("execution(private void Informal.Spring.Annotation.Aop.Event.ready())")
private void r(){}

@Pointcut("execution(private void Informal.Spring.Annotation.Aop.Event.implement())")
private void i(){}

@Before("r()")
    public void first(){
        System.out.println("日志开始");
    }

    @After("r()")
    public void middle(){
        System.out.println("日志中间");
    }
    @Around("i()")
    public void l(){
        System.out.println("日志结束");
    }
}
