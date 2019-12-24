package Informal.mybatis.test4.ThreadTest;

public class Thread2{public static void main(String args[]){
    Thread thread=new Thread(new Thread1());
    thread.start();

}

}

