package test5;

import test1.Flyable;

public class BirdLogProxy implements Flyable {

    private Flyable flyable;

    public BirdLogProxy(Flyable flyable){
        this.flyable = flyable;
    }

    @Override
    public void fly() {
        System.out.println("鸟飞行的开始.....");
        flyable.fly();
        System.out.println("鸟飞行的结束.....");
    }

}
