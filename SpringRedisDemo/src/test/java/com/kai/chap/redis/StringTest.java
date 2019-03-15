package com.kai.chap.redis;

/**
 * 测试String...和String[]的区别
 * @author hok
 * @since 2019-3-15 16:51:32
 */
public class StringTest {

    public static void main(String[] args){
//        test1(new String[]{"aa","bb","cc"});
        test2("aa","bb","cc");
    }

    public static void test1(String[] strs){
        for (int i = 0; i < strs.length; i++){
            System.out.println("test1测试String[]传参的结果：" + strs[i]);
        }
    }

    public static void test2(String... strs){
        for (int i = 0; i < strs.length; i++){
            System.out.println("test1测试String...传参的结果：" + strs[i]);
        }
    }

}
