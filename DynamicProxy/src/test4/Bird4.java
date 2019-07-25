package test4;

import test1.Bird;
import test1.Flyable;

public class Bird4 implements Flyable {

    private Bird bird;

    public Bird4(Bird bird){
        this.bird = bird;
    }

    @Override
    public void fly() {
        long beginTime = System.currentTimeMillis();
        bird.fly();
        long endTime = System.currentTimeMillis();
        System.out.println("飞行时间：" + (endTime-beginTime));
    }

}
