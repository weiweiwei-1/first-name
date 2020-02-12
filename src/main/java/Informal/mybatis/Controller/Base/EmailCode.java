package Informal.mybatis.Controller.Base;

import net.jodah.expiringmap.ExpirationPolicy;
import net.jodah.expiringmap.ExpiringMap;

import java.util.concurrent.TimeUnit;

public class EmailCode {
    public static ExpiringMap<String,String> getEmailCode = ExpiringMap.builder().maxSize(6000)
            .expiration(120000,TimeUnit.MILLISECONDS).expirationPolicy(ExpirationPolicy.ACCESSED).variableExpiration().build();
}
