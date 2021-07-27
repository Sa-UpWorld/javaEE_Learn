/*
 * FileName: NewFutureTest
 * Author:   Lenovo
 * Date:     2021/7/26 19:51
 * Description: Java新特性测试
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.boot.day_12;

/**
 * @author Lenovo
 */
public interface NewFutureTest {

    public static void sayWord(){
        /*
        接口中的静态方法只能自己调用
         */
        System.out.println("我是接口中的静态方法!");
    }

    public default void sayHello(){
        /**
         * 实现类可调用接口的默认方法
         */
        System.out.println("我是接口中的默认方法!");
    }

    private void getAge(){
        System.out.println("我是接口中的私有方法!");
    }
}
