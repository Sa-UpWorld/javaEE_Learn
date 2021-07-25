/*
 * FileName: ConstructorTest
 * Author:   Lenovo
 * Date:     2021/7/25 19:38
 * Description: 构造器引用
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.boot.day_10;

import org.junit.Test;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author Lenovo
 *      1.构造器引用
 *          和方法引用类似，函数式接口的抽象方法的形参列表和构造器的形参列表一致
 *          抽象方法的返回值类型即为构造器所属类的类型
 *      2.数组引用
 */
public class ConstructorTest {

    /**
     * 构造器引用
     * Supplier中的T get（）
     */
    @Test
    public void test(){
        Supplier<Person> sup=()->new Person();
        System.out.println(sup.get());
        System.out.println("方法引用:");
        Supplier<Person> sup1=Person::new;
        System.out.println(sup1.get());
    }

    /**
     * Function中的R apply(T t)
     */
    @Test
    public void test1(){
        Function<String,Person> f=name->new Person(name);
        System.out.println(f.apply("李晶"));
        System.out.println();
        Function<String,Person> f1=Person::new;
        System.out.println(f1.apply("袁玉风"));
    }

    /**
     * BiFunction中的R apply(T t,U u)
     */
    @Test
    public void test2(){
        BiFunction<String,Integer,Person> bi=(name,age)->new Person(name,age);
        System.out.println(bi.apply("李晶", 23));
        System.out.println("方法引用:");
        BiFunction<String,Integer,Person> bif=Person::new;
        System.out.println(bif.apply("李晶", 23));
    }

    @Test
    public void test3(){
        Function<Integer,String[]> func=(len)->new String[len];
        System.out.println(func.apply(20).length);
        System.out.println("方法引用:");
        Function<Integer,String[]> func1=String[]::new;
        System.out.println(func1.apply(15).length);
    }
}
