/*
 * FileName: MethodTest
 * Author:   Lenovo
 * Date:     2021/7/25 18:14
 * Description: 方法引用
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.boot.day_10;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author Lenovo
 *      方法引用
 *          当要传递给Lambda体的操作，已经有实现的方法了，可以使用方法引用
 *          方法引用本质上就是Lambda表达式，Lambda表达式作为函数式接口的实例
 *          所有方法引用也是函数式接口的实例
 *          三种情况：
 *              对象：：非静态方法（实例方法）
 *              类：：静态方法
 *              类：：非静态方法
 *      方法引用使用场景：
 *          接口中的抽象方法形参列表和返回值类型与方法引用的方法的一致
 */
public class MethodTest {

    /**
     * 情况1：对象：：实例
     *      Consumer中的void accept（T t）
     */
    @Test
    public void test(){
        Consumer<String> con=str->System.out.println(str);
        con.accept("北京!");
        System.out.println("**********");
        Consumer<String> con1=System.out::println;
        con.accept("南京");
    }

    /**
     * Supplier中的 T get（）
     */
    @Test
    public void test1(){
        Person person=new Person("李晶",23);
        Supplier<String> sup=()->person.getName();
        System.out.println(sup.get());
        System.out.println("方法引用");
        Person person1=new Person("李晶",23);
        Supplier<String> sup1=person1::getName;
        System.out.println(sup1.get());
    }

    /**
     * 情况2：类：：静态方法
     */
    @Test
    public void test3(){
        Comparator<Integer> com=(t1,t2)->Integer.compare(t1,t2);
        System.out.println(com.compare(15, 12));
        System.out.println("方法引用");
        Comparator<Integer> com1=Integer::compare;
        System.out.println(com1.compare(12, 15));
    }

    /**
     * Function中的R apply（T t）
     * Math中的Long round（Double d）
     */
    @Test
    public void test4(){
        Function<Double,Long> function=d->Math.round(d);
        System.out.println(function.apply(12.3));
        System.out.println("方法引用");
        Function<Double,Long> fun1=Math::round;
        System.out.println(fun1.apply(15.6));
    }

    /**
     * 类：：实例方法
     *      Comparator中的int compare（T t1，T t2）
     *      String中的int t1.compareTo(t2)
     */
    @Test
    public void test5(){
        Comparator<Integer> com=(t1,t2)->Integer.compare(t1,t2);
        System.out.println(com.compare(15, 16));
        System.out.println("方法引用");
        Comparator<Integer> com1=Integer::compare;
        System.out.println(com1.compare(12, 10));
    }

    /**
     * BiPredicate中的boolean test（T t1，T t2）
     *      String中的boolean t1.equals(t2)
     */
    @Test
    public void test6(){
        BiPredicate<String,String> pre=(e1,e2)->e1.equals(e2);
        System.out.println(pre.test("北京", "南京"));
        System.out.println("方法引用!");
        BiPredicate<String,String> pre1=String::equals;
        System.out.println(pre1.test("李晶", "李晶"));
    }

    /**
     * Function中的R apply(T t)
     *      Person中的String getName()
     */
    @Test
    public void test7(){
        Person person=new Person("李晶",23);
        //lambda表达式
        Function<Person, String> func=e->e.getName();
        System.out.println(func.apply(person));
        //lambda表达式
        Function<Person, String> fun=Person::getName;
        System.out.println(fun.apply(person));
    }
}
