package Informal.mybatis.Controller.ShiroException;

import org.apache.shiro.authc.CredentialsException;

public class NullCredentialsException extends CredentialsException {
    public NullCredentialsException() {
    }

    public NullCredentialsException(String message) {
        super(message);
    }
}
