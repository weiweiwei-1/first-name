package Informal.Spring.Annotation.Model.total_Annotation;

import org.springframework.context.annotation.Import;

@Import(value=SpringconfigurationA.class)
//导入其他注解的配置文件，可以不用@configuration注解进行配置
public class SpringconfigurationB {
}
