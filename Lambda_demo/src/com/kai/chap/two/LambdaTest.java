package com.kai.chap.two;

/**
 * Lambda使用匿名内部类
 */
public class LambdaTest {

    public static void main(String[] args){
        new Thread(new Runnable(){

            @Override
            public void run(){
                System.out.println("Hello World!");
            }
        }).start();

        //使用lambda
        new Thread(() -> System.out.println("Hello World!")).start();
    }

    /**
     * （第一种）使用匿名内部类(Lambda测试)
     */
    public static void test1(){
        new Thread(new Runnable(){

            @Override
            public void run(){
                System.out.println("Hello World!");
            }
        }).start();

        //使用lambda
        new Thread(() -> System.out.println("Hello World!")).start();
    }

    /**
     * （第二种）使用匿名类不类（测试Lambda）
     */
    public static void test2(){
//        Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("Hello World!");
//            }
//        };

        //使用Lambda表达式
        Runnable runnable = () -> System.out.println("Hello World!");
        runnable.run();
    }

}
