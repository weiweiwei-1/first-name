package Informal.mybatis.Validator.ValidatorImpl;

import Informal.mybatis.Convert.IntegerToString;
import Informal.mybatis.Validator.isInteger;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class isStringValidator implements ConstraintValidator<isInteger,String> {
    @Override
    public void initialize(isInteger isInteger) {

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if(StringUtils.isBlank(s)){
            return false;
        }
        if(!StringUtils.isBlank(s)){
            String str=s.trim();
            IntegerToString integerToString=new IntegerToString();
            if(!integerToString.Stringforint(str)){
                return false;
            }
            else{
                int str2=Integer.parseInt(str);
                if(str2<1||str2>5000)
                    return false;
            }
        }
        return true;
    }
}
