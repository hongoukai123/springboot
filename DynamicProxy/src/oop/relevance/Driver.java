package oop.relevance;

public class Driver {

    /**
     * 使用成员变量方式实现关联
     */
    Car myCar;
    public void driver1(){
        myCar.run();
    }

    /**
     * 使用方法形参方式实现关联
     * @param car
     */
    public void driver2(Car car){
        car.run();
    }

}
