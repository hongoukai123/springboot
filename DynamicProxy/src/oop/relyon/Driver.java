package oop.relyon;

public class Driver {

    /**
     * 使用形参方式发生依赖关系
     * @param car
     */
    public void driver1(Car car){
        car.run();
    }

    /**
     * 使用局域变量方式发生依赖关系
     */
    public void driver2(){
        Car car = new Car();
        car.run();
    }

    /**
     * 使用静态方法调用方式发生依赖关系
     */
    public void driver3(){
        Car.run();
    }

}
