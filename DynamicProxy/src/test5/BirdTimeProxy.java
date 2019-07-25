package test5;

import test1.Flyable;

public class BirdTimeProxy implements Flyable {

    private Flyable flyable;

    public BirdTimeProxy(Flyable flyable){
        this.flyable = flyable;
    }

    @Override
    public void fly() {
        long beginTime = System.currentTimeMillis();
        flyable.fly();
        long endTime = System.currentTimeMillis();
        System.out.println("分行时间为：" + (endTime-beginTime));
    }

}
