package Informal.Spring.Annotation.Aop;

import org.springframework.stereotype.Component;

@Component
public class Event {
    public void ready(){
    System.out.println("准备");
    }
    public void implement(){
        System.out.println("实施");
    }
    public void over(){
        System.out.println("结束");
    }
}
