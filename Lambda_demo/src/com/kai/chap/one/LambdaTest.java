package com.kai.chap.one;

import java.util.ArrayList;
import java.util.List;

/**
 * Lambda表达式测试
 */
public class LambdaTest {

    public static void main(String[] args){
        List<String> list = new ArrayList<>();
        list.add("aa");
        list.add("bb");
        list.add("cc");
        list.add("dd");
        list.add("ee");
        list.add("ff");

//        //传统遍历集合
//        trditionTraversal(list);

//        //Lambda表达式遍历集合
//        lambdaTraversal(list);

        //java8中使用双引号操作符
        java8DoubleColon(list);
    }

    /**
     * 传统的遍历集合
     * @param list
     */
    public static void trditionTraversal(List<String> list){
        for (String str : list){
            System.out.println(str);
        }
    }

    /**
     * Lambda表达式遍历集合
     * @param list
     */
    public static void lambdaTraversal(List<String> list){
        list.forEach((str) -> System.out.println(str));
    }

    /**
     * java8中使用双冒号操作符
     * @param list
     */
    public static void java8DoubleColon(List<String> list){
        list.forEach(System.out::println);
    }


}
