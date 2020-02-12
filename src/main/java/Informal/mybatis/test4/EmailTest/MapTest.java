package Informal.mybatis.test4.EmailTest;

import Informal.mybatis.Controller.Base.EmailCode;
import net.jodah.expiringmap.ExpirationPolicy;
import net.jodah.expiringmap.ExpiringMap;
import org.apache.commons.lang.UnhandledException;

import java.util.concurrent.TimeUnit;

public class MapTest{
    public static void main(String args[]) throws InterruptedException {
    System.out.println(EmailCode.getEmailCode.get("2198626335@qq.com"));
    }
}