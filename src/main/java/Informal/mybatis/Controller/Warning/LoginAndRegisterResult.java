package Informal.mybatis.Controller.Warning;

public class LoginAndRegisterResult {
    public static final String NULL_USERNAME_ERROR = "用户名不能为空";
    public static final String USERNAME_ERRROR = "用户名错误";
    public static final String USERNAME_EXIST_ERROR = "用户名已经存在";
    public static final String NULL_EMAIL_ERROR = "邮箱名字不能为空";
    public static final String EMAIL_FORMAT_ERROR = "邮箱格式错误";
    public static final String EMAIL_EXIST_ERROR = "邮箱已被注册";
    public static final String SEND_EMAIL_ERROR = "不能发送验证码给邮箱，不存在此邮箱";
    public static final String NULL_PASSWORD_ERROR = "密码不能为空";
    public static final String PASSWORD_ERROR = "密码错误";
    public static final String PASSWORD_FORMAT_ERROR = "密码长度不能低于四位";
    public static final String PASSWORD_CONFIRM_ERROR = "前后密码对不上";
}
