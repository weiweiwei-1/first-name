package Informal.mybatis.Controller.Warning;

public class LoginAndRegisterResult {
    public static final String NULL_USERNAME_ERROR = "用户名不能为空";
    public static final String USERNAME_ERRROR = "用户名错误";
    public static final String USERNAME_EXIST_ERROR = "用户名已经存在";
    public static final String NULL_EMAIL_ERROR = "邮箱名字不能为空";
    public static final String EMAIL_FORMAT_ERROR = "邮箱格式错误";
    public static final String EMAIL_AND_CODE_ERROR = "邮箱错误或验证码失效异常";
    public static final String EMAIL_NOTEXIST_ERROR = "该邮箱不存在";
    public static final String EMAIL_EXIST_ERROR = "邮箱已被注册";
    public static final String EMAIL_CONFIRMCODE_EXIST_ERROR = "验证码未失效，不能重复发送";
    public static final String EMAIL_CNFIRMCODE_EXCEPTION_ERROR = "发送验证码异常，联系管理员";
    public static final String EMAIL_CODE_ERROR = "验证码错误";
    public static final String EMAIL_CODE_INVALID_ERROR = "邮箱验证码失效，请重新发送";
    public static final String NULL_PASSWORD_ERROR = "密码不能为空";
    public static final String PASSWORD_ERROR = "密码错误";
    public static final String PASSWORD_FORMAT_ERROR = "密码长度4-15位";
    public static final String PASSWORD_CONFIRM_ERROR = "前后密码对不上";
    public static final String LOGIN_SUCCESS = "登录成功";
}
