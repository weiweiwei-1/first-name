package Informal.mybatis.Controller.ShiroException;

import org.apache.shiro.authc.AccountException;

public class NullCountException extends AccountException {
    public NullCountException() {
    }

    public NullCountException(String message) {
        super(message);
    }

    public NullCountException(Throwable cause) {
        super(cause);
    }

    public NullCountException(String message,Throwable cause) {
        super(message, cause);
    }
}
