package Informal.mybatis.Controller.Base;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class ConfirmCode {
    public static String getConfirmCode() {
        StringBuilder confirmCode = new StringBuilder();
        int randomInteger;
        for (int i = 0; i < 6; i++) {
            randomInteger = new Random().nextInt(10);
            confirmCode = confirmCode.append(String.valueOf(randomInteger));
        }
        return confirmCode.toString();
    }

    public static void main(String args[]) {
        System.out.println(ConfirmCode.getConfirmCode());
    }
}