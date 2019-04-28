import test1.Bird;
import test2.Bird2;
import test3.Bird3;

public class Test {

    public static void main(String[] args) {
        //测试鸟在飞行(最简单的要求)
//        Bird bird = new Bird();
//        bird.fly();

        //如果我想知道鸟在空中飞行了具体多长时间怎么办？
        //1.在开始加入时间，在末尾加入时间，两个时间相减得到飞行时间(test2中所示)
//        Bird2 bird2 = new Bird2();
//        bird2.fly();

        /**
         * 2.假设bird这个类来自于某个SDK(或者说jar包)，你无法改动源码，怎么办？
         *      1>可以想到这如下调用：
         *      此方案看似没有问题，但其实忽略了准备这些方法所需要的时间，执行一个方法，需要：
         *      开辟栈内存、压栈、出栈等操作，这部分的时间也是不可忽略的。
         *      因此这个解决方案不可行。
         */
//        Bird bird = new Bird();
//        long beginTime = System.currentTimeMillis();
//        bird.fly();
//        long endTime = System.currentTimeMillis();
//        System.out.println("飞行时间为：" + (endTime-beginTime));

        /**
         * 方案-----》继承
         * 2.假设bird和Flyable来自某个SDK(或者说jar包)，你无法改动源码。
         *      2>可以想到用继承（继承是最直观的解决方案）
         *      为此我们本地创建类Bird3来继承外部的Bird类，来重写父类的fly方法，然后植入开始和结束时间，
         *      计算飞行时间。
         *      这是一种解决方案
         */
//        Bird3 bird3 = new Bird3();
//        bird3.fly();

        /**
         * 方案-----》聚合
         * 2.假设bird和Flyable来自某个SDK（或者说jar包），你无法改动源码
         *      3>可以想到用聚合
         */

    }

}
