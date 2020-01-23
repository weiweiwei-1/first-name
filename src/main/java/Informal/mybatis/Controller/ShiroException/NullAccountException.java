package Informal.mybatis.Controller.ShiroException;

import org.apache.shiro.authc.AccountException;

public class NullAccountException extends AccountException {
    public NullAccountException() {
    }

    public NullAccountException(String message) {
        super(message);
    }

    public NullAccountException(Throwable cause) {
        super(cause);
    }

    public NullAccountException(String message, Throwable cause) {
        super(message, cause);
    }
}
