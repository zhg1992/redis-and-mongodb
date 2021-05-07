package org.javaboy.cacheredis;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheNames = "c1")
public class UserService {

    // 参数为key，返回值为value
    // @Cacheable(cacheNames = "c1", key = "#id")
    // @Cacheable(cacheNames = "c1", keyGenerator = "myKeyGenerator")
    // public User getUserById(Integer id, String name) {
    @Cacheable
    public User getUserById(Integer id) {
        System.out.println("getUserById>>>" + id);
        User user = new User();
        user.setId(id);
        return user;
    }

    // 删除数据同时删除缓存数据
    @CacheEvict
    public void deleteUserById(Integer id) {
        System.out.println("deleteUserById>>>" + id);
    }

    //更新原数据及缓存
    @CachePut(key = "#user.id")
    public User updateUserById(User user) {
        return user;
    }
}
