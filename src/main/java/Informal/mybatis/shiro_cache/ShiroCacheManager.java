package Informal.mybatis.shiro_cache;

import org.apache.shiro.cache.Cache;

public interface ShiroCacheManager {
    <K, V> Cache<K, V> getCache(String name);
//    销毁
    void destroy();
}
