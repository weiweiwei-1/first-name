package Informal.mybatis.Validator;

import Informal.mybatis.Validator.ValidatorImpl.isStringValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy=isStringValidator.class)
public @interface isInteger {
    String message() default "";
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
