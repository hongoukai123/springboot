package com.kai.chap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.data.redis.connection.RedisZSetCommands.Range;
import redis.clients.jedis.Jedis;

import java.util.*;

@Controller
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 测试redis操作String（字符串）和Hash（散列数据）
     * @return
     */
    @RequestMapping("/test")
    @ResponseBody
    public Map<String, Object> testStringAndHash(){
        redisTemplate.opsForValue().set("key1", "value1");
        //这里使用了JDK的序列化器，所以Redis保存时不是整数，不能运算
        redisTemplate.opsForValue().set("int_key", "1");
        stringRedisTemplate.opsForValue().set("int", "1");
        //使用运算
        stringRedisTemplate.opsForValue().increment("int", 1);

        //获取底层jedis连接
        Jedis jedis = (Jedis) stringRedisTemplate.getConnectionFactory().getConnection().getNativeConnection();
        //减1操作，这个命令RedisTemplate不支持，所以我先获取底层的连接再操作
        jedis.decr("int");

        Map<String, String> hash = new HashMap<>();
        hash.put("field1", "value1");
        hash.put("field2", "value2");
        //存入一个散列数据类型
        redisTemplate.opsForHash().putAll("hash", hash);
        //给散列数据类型hash中增加一个key、value
        redisTemplate.opsForHash().put("hash", "field3", "value3");
        //绑定散列操作的key，这样可以对同一个散列数据类型进行操作
        BoundHashOperations hashOps = stringRedisTemplate.boundHashOps("hash");
        //删除两个字段
        hashOps.delete("field1", "field2");
        //新增一个字段
        hashOps.put("field4", "value4");
        Map<String, Object> map = new HashMap<>();
        map.put("success", true);
        return map;
    }

    /**
     * 测试Redis操作List
     * @return
     */
    @RequestMapping("/list")
    @ResponseBody
    public Map<String, Object> testList(){
        //使用leftPushAll实际调用的是lPush，将数据添加到key对应的现有数据的左边，也就是头部
        //效果就是：ee dd cc bb aa
        redisTemplate.opsForList().leftPushAll("list1", "aa","bb","cc","dd","ee");
        //使用rightPushAll实际调用的是rPush,将数据添加到key对应的现有数据的右边，也就是尾部
        //效果就是：v1 v2 v3 v4 v5
        redisTemplate.opsForList().rightPushAll("list2", "v1","v2","v3","v4","v5");
        //绑定list2链表操作
        BoundListOperations listOps = stringRedisTemplate.boundListOps("list2");
        //从右边弹出一个成员
        Object result1 = listOps.leftPop();
        //获取定位元素，Redis从0开始计算，这里值就对应的是v2
        Object result2 = listOps.index(1);
        //从左边插入链表
        listOps.leftPush("v0");
        //求链表的长度
        Long size = listOps.size();
        //求链表下标区间成员，整个链表下标范围为0到size-1,这里不取最后一个元素
        List elements = listOps.range(0, size-1);
        Map<String, Object> map = new HashMap<>();
        map.put("success", true);
        return map;
    }

    /**
     * 测试redis操作set
     * @return
     */
    @RequestMapping("/set")
    @ResponseBody
    public Map<String, Object> testSet(){
        //set不允许重复，所以插入后的内容只有一个v1
        redisTemplate.opsForSet().add("set1", "v1","v1","v2","v3","v4","v5");
        stringRedisTemplate.opsForSet().add("set2", "v2", "v3", "v5", "v8");
        //绑定set1操作
        BoundSetOperations setOps = redisTemplate.boundSetOps("set1");
        //增加两个元素
        setOps.add("v6", "v7");
        //删除两个元素
        setOps.remove("v1","v7");
        //返回所有元素
        Set set1 = setOps.members();
        //求成员数
        Long size = setOps.size();
        //求交集
        Set inter = setOps.intersect("set2");
        //求交集并且用新集合inter保存
        setOps.intersectAndStore("set2", "inter");
        //求差集
        Set diff = setOps.diff("set2");
        //求差集并且用新集合diff保存
        setOps.diffAndStore("set2", "diff");
        //求并集
        Set union = setOps.union("set2");
        //求并集并且用新集合union保存
        setOps.unionAndStore("set2", "union");
        Map<String, Object> map = new HashMap<>();
        map.put("success", true);
        return map;
    }

    /**
     * 测试Redis操作有序集合ZSet
     * @return
     */
    @RequestMapping("/zset")
    @ResponseBody
    public Map<String, Object> testZSet(){
        Set<ZSetOperations.TypedTuple<String>> typedTupleSet = new HashSet<>();
        for (int i = 0; i <= 9; i++){
            //分数
            double score = i+0.1;
            //创建一个TypedTuple存入值和分数
            ZSetOperations.TypedTuple<String> typedTuple = new DefaultTypedTuple<>("value" + i, score);
            typedTupleSet.add(typedTuple);
        }
        //往有序集合中插入元素
        stringRedisTemplate.opsForZSet().add("zset1", typedTupleSet);
        //绑定zset
        BoundZSetOperations zsetOps = redisTemplate.boundZSetOps("zset1");
        //增加一个元素
        zsetOps.add("value10", 0.26);
        Set<String> setRange = zsetOps.range(1, 6);
        //按照分数排序获取有序集合
        Set<String> setScore = zsetOps.rangeByScore(0.2, 0.6);
        //定义值范围
        Range range =new Range();
        //大于value3
        range.gt("value3");
//        //大于等于value3
//        range.gte("value3");
//        //小于value8
//        range.lt("value8");
        //小于等于value8
        range.lte("value8");
        //按值排序，这里是按照字符串排序
        Set<String> setLex = zsetOps.rangeByLex(range);
        //删除元素
        zsetOps.remove("value9", "value2");
        //求分数
        Double score = zsetOps.score("value8");
        //在下标区间下，按分数排序，同时返回value和score
        Set<ZSetOperations.TypedTuple> rangeSet = zsetOps.rangeWithScores(1, 6);
        //在分数区间下，按分数排序，同时返回value和score
        Map<String, Object> map = new HashMap<>();
        map.put("success", true);
        return map;
    }

}
