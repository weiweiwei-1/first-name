package Informal.mybatis.Controller.Base;

import com.google.gson.Gson;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class BaseClass {
    @Bean
    public Gson getGson() {
        return new Gson();
    }
}
