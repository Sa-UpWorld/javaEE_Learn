/*
 * FileName: LambdaTest
 * Author:   Lenovo
 * Date:     2021/7/25 16:41
 * Description: Lambda表达式测试
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.boot.day_11.day_10;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * @author Lenovo
 *      Lambda表达式使用
 *          1.举例：（o1,o2）——>Integer.compare(o1,o2)
 *          2.格式：
 *              ->：lambda操作符 或 箭头操作符
 *              ->左边：lambda形参列表(其实就是接口中抽象方法的形参列表)
 *              ->右边：lambda体（其实就是重写的抽象方法方法体）
 *          3.Lambda表达式的使用——6中情况
 *          4.Lambda表达式本质：作为接口的实例
 *
 */
public class LambdaTest {

    /**
     * 情况1：无参无返回值情况
     */
    @Test
    public void test(){
        Runnable r1=new Runnable() {
            @Override
            public void run() {
                System.out.println("我爱北京天安门!");
            }
        };
        r1.run();
        System.out.println("***********");
        Runnable r2=()->System.out.println("我爱北京故宫!");
        r2.run();
    }

    /**
     * 情况2：需要一个参数，但是没有返回值
     */
    @Test
    public void test1(){
        Consumer<String> consumer=new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        consumer.accept("我是山西人!");
        System.out.println("*********");
        Consumer<String> con=(String s)->System.out.println(s);
        con.accept("谎言和誓言的区别!");
    }

    /**
     * 情况3：数据类型可忽略，因为可由编译器推断得出，成为“类型推断”
     */
    @Test
    public void test2(){
        Consumer<String> consumer=new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        consumer.accept("我是山西人!");
        System.out.println("*********");
        //类型推断
        Consumer<String> con=(s)->System.out.println(s);
        con.accept("谎言和誓言的区别!");
    }

    /**
     * 情况4：Lambda若只需要一个参数，参数的小括号可以省略
     */
    @Test
    public void test3(){
        //类型推断
        Consumer<String> con=s->System.out.println(s);
        con.accept("谎言和誓言的区别!");
    }

    /**
     * 情况5：Lambda需要两个或以上的参数，多条执行语句，并且可以有返回值
     */
    @Test
    public void test4(){
        Comparator<Integer> comparator=new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };
        System.out.println(comparator.compare(15,20));
        System.out.println("**************");
        Comparator<Integer> con=(o1,o2)->{
            System.out.println(o1);
            System.out.println(o2);
            return o1.compareTo(o2);
        };
        System.out.println(con.compare(15,13));
    }

    /**
     * 情况6：当Lambda体只有一条语句时，return和{}可以省略
     */
    @Test
    public void test6(){
        Comparator<Integer> con=(o1,o2)->o1.compareTo(o2);
        System.out.println(con.compare(15,13));
    }
}
