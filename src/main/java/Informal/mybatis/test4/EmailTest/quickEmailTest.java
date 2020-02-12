package Informal.mybatis.test4.EmailTest;

import org.apache.commons.net.smtp.SMTPClient;
import org.apache.commons.net.smtp.SMTPReply;
import org.xbill.DNS.Lookup;
import org.xbill.DNS.Record;
import org.xbill.DNS.Type;

import java.io.IOException;

public class quickEmailTest {
    public static void main(String args[]){
        System.out.println(quickEmailTest.checkEmail("weishao_optimus@163.com"));
    }
    public static boolean checkEmail(String email){
        if (!email.matches("[\\w\\.\\-]+@([\\w\\-]+\\.)+[\\w\\-]+")) {
            return false;
        }

        String host = "";
        String hostName = email.split("@")[1];
        Record[] result = null;
        SMTPClient client = new SMTPClient();

        try {
            // 查找MX记录
            Lookup lookup = new Lookup(hostName, Type.MX);
            lookup.run();
            if (lookup.getResult() != Lookup.SUCCESSFUL) {
                return false;
            } else {
                result = lookup.getAnswers();
            }

            // 连接到邮箱服务器
            for (int i = 0; i < result.length; i++) {
                host = result[i].getAdditionalName().toString();
                client.connect(host);
                if (!SMTPReply.isPositiveCompletion(client.getReplyCode())) {
                    client.disconnect();
                    continue;
                } else {
                    break;
                }
            }

            //以下2项自己填写快速的，有效的邮箱
            client.login("2198626335");
            client.setSender("weishao_optimus@163.com");
            client.addRecipient(email);
            if (250 == client.getReplyCode()) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                client.disconnect();
            } catch (IOException e) {
            }
        }
        return false;
    }
}
