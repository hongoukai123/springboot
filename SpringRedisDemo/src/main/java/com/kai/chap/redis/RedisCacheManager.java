package com.kai.chap.redis;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.CollectionUtils;

import java.util.concurrent.TimeUnit;

/**
 * redis缓存工具类
 * @author hok
 * @since 2019-3-15 14:29:26
 */
public class RedisCacheManager {

    //redis模板
    private RedisTemplate<String, Object> redisTemplate;

    //需要set注入
    public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    /**
     * 指定缓存失效时间
     * @param key 键
     * @param time 时间（单位：秒）
     * @return
     */
    public boolean expire(String key, long time){
        try{
            if (time > 0){
                redisTemplate.expire(key, time, TimeUnit.SECONDS);
            }
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 根据key获取过期时间
     * @param key
     * @return
     */
    public long getExpire(String key){
        return redisTemplate.getExpire(key, TimeUnit.SECONDS);
    }

    /**
     * 判断key是否存在
     * @param key
     * @return
     */
    public boolean hasKey(String key){
        try{
            return redisTemplate.hasKey(key);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 删除缓存
     * 注解@SuppressWarnings指的是（允许选择性地取消特定代码段中的警告）
     * 如果使用unchecked(执行了未检查的转换时的警告，例如当使用集合时没有用泛型 (Generics) 来指定集合保存的类型。)
     * @param key
     * @return
     */
    @SuppressWarnings("unchecked")
    public void del(String... key){
        if(key != null && key.length > 0){
            if(key.length == 1){
                redisTemplate.delete(key[0]);
            }else {
                redisTemplate.delete(CollectionUtils.arrayToList(key));
            }
        }
    }

    /**
     * String类型缓存获取
     * @param key
     * @return 值
     */
    public Object get(String key){
        return key == null ? null : redisTemplate.opsForValue().get(key);
    }

    /**
     * String类型缓存放入
     * @param key
     * @param value
     * @return true成功false失败
     */
    public boolean set(String key, Object value){
        try{
            redisTemplate.opsForValue().set(key, value);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * String类型缓存放入并设置时间
     * @param key 键
     * @param value 值
     * @param time 时间（秒）时间需要设置大于0；如果设置小于等于0将设置无限
     * @return true成功false失败
     */
    public boolean set(String key, Object value, long time){
        try{
            if (time > 0){
                redisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);
            }else {
                set(key, value);
            }
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 递增
     * @param key 键
     * @param delta 递增因子（需要增加几（大于0））
     * @return
     */
    public long incr(String key, long delta){
        if (delta < 0){
            throw new RuntimeException("递增因子必须大于0");
        }
        return redisTemplate.opsForValue().increment(key, delta);
    }

    /**
     * 递减
     * @param key 键
     * @param delta 递减因子（需要减少几（大于0））
     * @return
     */
    public long decr(String key, long delta){
        if (delta < 0){
            throw new RuntimeException("递减因子必须大于0");
        }
        return redisTemplate.opsForValue().increment(key, -delta);
    }

}
