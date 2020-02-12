package Informal.mybatis.Controller.Base;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomName {
    public static String getRandomName() {
        StringBuilder username = new StringBuilder("微聊用户");
        int randomInteger;
        for (int i = 0; i < 6; i++) {
            randomInteger = new Random().nextInt(10);
            username = username.append(String.valueOf(randomInteger));
        }
        return username.toString();
    }
}
