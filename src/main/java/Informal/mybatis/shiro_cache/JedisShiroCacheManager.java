package Informal.mybatis.shiro_cache;

import org.apache.shiro.cache.Cache;


public class JedisShiroCacheManager implements ShiroCacheManager{
    @Override
    public <K, V> Cache<K, V> getCache(String name) {
        return new JedisShiroCache<K,V>(name);
    }

    @Override
    public void destroy() {

    }
}

