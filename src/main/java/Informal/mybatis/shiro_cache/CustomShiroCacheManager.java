package Informal.mybatis.shiro_cache;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;

import javax.security.auth.DestroyFailedException;
import javax.security.auth.Destroyable;

public class CustomShiroCacheManager implements CacheManager,Destroyable {

    @Override
    public <K, V> Cache<K, V> getCache(String s) throws CacheException {
        return null;
    }

    @Override
    public void destroy() throws DestroyFailedException {

    }

    @Override
    public boolean isDestroyed() {
        return false;
    }
}