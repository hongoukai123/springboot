package com.kai.chap.redis;

import java.util.List;

import redis.clients.jedis.Jedis;

/**
 * 简单测试redis连接
 * @author hok
 * @since 2019-3-15 09:50:59
 */
public class RedisTest {
	
	public static void main(String[] args) {
		//连接本地redis服务
		Jedis jedis = new Jedis("localhost");
		System.out.println("连接成功");
//		//查看服务是否运行
//		System.out.println("服务正在运行：" + jedis.ping());
		
//		testRedisString(jedis);	//操作测试redis字符串数据
		
		testReidsList(jedis);	//操作测试redis的List集合
		
	}
	
	/**
	 * 测试操作redis字符串
	 * @param jedis
	 */
	public static void testRedisString(Jedis jedis) {
		//设置redis字符串数据
		jedis.set("number", "aa");
		//获取存储的数据并输出
		System.out.println("redis存储的字符串为：" + jedis.get("number"));
	}
	
	public static void testReidsList(Jedis jedis) {
		//存储数据到列表中
		jedis.lpush("listOne", "张三");
		jedis.lpush("listOne", "李四");
		jedis.lpush("listOne", "王蛋");
		//获取存储的数据并输出
		List<String> list = jedis.lrange("listOne", 0, 2);
		for(String v : list) {
			System.out.println("结果为：" + v);
		}
	}

}
