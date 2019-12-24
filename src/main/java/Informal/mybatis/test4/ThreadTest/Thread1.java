package Informal.mybatis.test4.ThreadTest;

public class Thread1 implements Runnable{
    Thread3 thread3=new Thread3(100);
    @Override
    public void run() {
        for(int i=0;i<100;i++) {
            thread3.decrease();
            thread3.decrease();
        }
    }
}
