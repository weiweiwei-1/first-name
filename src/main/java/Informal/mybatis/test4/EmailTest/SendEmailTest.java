package Informal.mybatis.test4.EmailTest;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmailTest {

    public static void main(String[] args) throws MessagingException {
        long start = System.currentTimeMillis();
        Properties properties = new Properties();
        properties.put("mail.transport.protocol", "smtp");// 连接协议
        properties.put("mail.smtp.host", "smtp.qq.com");// 主机名
        properties.put("mail.smtp.port", 465);// 端口号
        properties.put("mail.smtp.auth", "true");//smtp表示需要身份验证，true为需要身份验证，false为不需要身份验证
        properties.put("mail.smtp.ssl.enable", "true");// 设置是否使用ssl安全连接 ---一般都使用
        properties.put("mail.debug", "true");// 设置是否显示debug信息 true 会在控制台显示相关信息
        // 得到回话对象
        Session session = Session.getInstance(properties);
        // 获取邮件对象
        Message message = new MimeMessage(session);
        // 设置发件人邮箱地址
        message.setFrom(new InternetAddress("2198626335@qq.com"));
        // 设置收件人邮箱地址
        message.setRecipients(Message.RecipientType.TO, new InternetAddress[]{new InternetAddress("weishao_optimus@163.com")});
        //message.setRecipient(Message.RecipientType.TO, new InternetAddress("xxx@qq.com"));//一个收件人
        // 设置邮件标题
        message.setSubject("邮件测试");
        // 设置邮件内容
        message.setText("这是我的邮件测试");
        // 得到邮差对象
        Transport transport = session.getTransport();
        // 连接自己的邮箱账户
        transport.connect("2198626335@qq.com", "xeiunzxvunqreagh");// 密码为QQ邮箱开通的stmp服务后得到的客户端授权码
        // 发送邮件
        try {
            transport.sendMessage(message, message.getAllRecipients());
        } catch (MessagingException e) {
            System.out.println("邮件发送失败");
        }
        transport.close();
        long end = System.currentTimeMillis();
        System.out.println("发送邮件需要的时间:"+(end-start)+"ms");
        System.exit(0);
    }

}