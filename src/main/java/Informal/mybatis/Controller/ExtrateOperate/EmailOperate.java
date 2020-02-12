package Informal.mybatis.Controller.ExtrateOperate;

import Informal.mybatis.Controller.Base.ConfirmCode;
import Informal.mybatis.Controller.Base.EmailCode;
import Informal.mybatis.Controller.Warning.LoginAndRegisterResult;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.HtmlEmail;

public class EmailOperate {
    public static String sendEmail(String email) {
        try {
            String code = ConfirmCode.getConfirmCode();
            EmailCode.getEmailCode.put(email,code);
            HtmlEmail htmlEmail = new HtmlEmail();//创建电子邮件对象
            htmlEmail.setSSL(true);
            htmlEmail.setDebug(true);
            htmlEmail.setHostName("SMTP.qq.com");//设置发送电子邮件使用的服务器主机名
            htmlEmail.setSmtpPort(587);//设置发送电子邮件使用的邮件服务器的TCP端口地址
            htmlEmail.setAuthenticator(new DefaultAuthenticator("2198626335@qq.com", "xeiunzxvunqreagh"));//邮件服务器身份验证
            htmlEmail.setFrom("2198626335@qq.com");//设置发信人邮箱
            htmlEmail.setSubject("微聊网验证码");//设置邮件主题
            htmlEmail.setCharset("utf-8");
            htmlEmail.setMsg("欢迎注册微聊网账号，您的注册验证码为：" + code + " ,该验证码两分钟内有效，请不要将该验证码透露给其他人");
            htmlEmail.addTo(email);//设置收件人
            htmlEmail.send();//发送邮件
        } catch (Exception e) {
            EmailCode.getEmailCode.remove(email);
            return LoginAndRegisterResult.EMAIL_CNFIRMCODE_EXCEPTION_ERROR;
        }
        return "";
    }
}
