/*
 * FileName: OptionalTest
 * Author:   Lenovo
 * Date:     2021/7/26 10:35
 * Description: Optional类实例及方法测试
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.boot.day_11;

import org.junit.Test;

import java.util.Optional;

/**
 * @author Lenovo
 *      Optional类——为避免程序中出现空指针异常而出现
 *          实例化：
 *                 Optional.of(T t)——>创建一个Optional实例，t必须非空
 *                 Optional.empty()——>创建一个空的Optional类实例
 *                 Optional.ofNullable(T t)——>t可以为空
 *          判断包含对象：
 *                 boolean isPresent()——>判断是否包含对象
 *                 void ifPresent(Cousumer<? supper T> consumer)——>如果有值，就执行Consumer接口实现代码，
 *                                      并且该值作为参数传给它
 *          获取Optional容器对象：
 *                 T get()——>如果调用对象包含值，则返回该值，否则跑异常
 *                 T orElse(T other)——>如果有值则将其返回，否则返回指定other对象
 *                 T orElseGet(Supplier<? extends T> other)——>如果有值则将其返回，
 *                                  否则返回由Supplier接口实现提供的对象
 *                 T orElseThrow(Supplier<？ extends X> exceptionSupplier)——>如果有值则将其返回，
 *                          否则抛出由Supplier接口实现提供的异常
 *
 *
 *
 */
public class OptionalTest {

    /**
     *实例化
     */
    @Test
    public void test(){
        /*
        方式1：Optional.of(t)——>t非空
         */
        Person person=new Person();
        Optional<Person> person1 = Optional.of(person);
        System.out.println(person1);
        /*
        方式2:Optional.empty()
         */
        Optional<Person> empty = Optional.empty();
        System.out.println(empty);
        /*
        方式3:Optional.ofNullable(T t)——>t可以为空
         */
        person=null;
        Optional<Person> person2 = Optional.ofNullable(person);
        System.out.println(person2);
        System.out.println(person2.orElse(new Person("李晶", 23)).getName());
    }
}
