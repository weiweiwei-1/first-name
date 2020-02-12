package Informal.mybatis.test4.EmailTest;

import org.apache.log4j.Logger;

public class ExceptionTset {
    public static Logger logger = Logger.getLogger("LoggerTest");
    public static void main(String args[]) {
        try{
            System.out.println(100/0);
        } catch(ArithmeticException e) {
            logger.info("xuowu");
        }


    }
}
