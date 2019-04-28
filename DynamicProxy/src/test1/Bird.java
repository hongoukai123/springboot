package test1;

import java.util.Random;

/**
 * 用随机睡眠时间模拟小鸟在空中的飞行时间
 */
public class Bird implements Flyable {

    @Override
    public void fly() {
        System.out.println("鸟在空中飞行......");
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
