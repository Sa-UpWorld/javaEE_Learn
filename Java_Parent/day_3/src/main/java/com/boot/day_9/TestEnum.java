/*
 * FileName: TestEnum
 * Author:   Lenovo
 * Date:     2021/7/20 9:39
 * Description: 枚举类与注解测试
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.boot.day_9;

import org.junit.Test;

import java.util.Arrays;

/**
 * 枚举和注解
 *      枚举类的理解——>类的对象为有限个
 *      枚举类只有一个对象时可实现单例模式
 * 枚举类的定义：
 *      1.JDK5.0前自定义
 *      2.
 */
public class TestEnum {

    @Test
    public void test(){
        System.out.println(Season.SPRING);
    }

    @Test
    public void test1(){
        System.out.println(Enum.SUMMER);
//        System.out.println(Enum.SUMMER.getClass());
        System.out.println(Arrays.asList(Enum.values()));
        System.out.println(Enum.valueOf("SUMMER"));
//        System.out.println(Enum.valueOf("SUMMER1"));
    }
}

class Season{
    /**
     * 自定义枚举类
     */
    //声明Season对象的属性
    private final String seasonName;

    //私有化类构造器,为对象属性赋值
    private Season(String seasonName){
        this.seasonName = seasonName;
    }

    //提供当前枚举类的多个
    public static final Season SPRING=new Season("春天");
    public static final Season SUMMER=new Season("夏天");
    public static final Season QIUTIAN=new Season("秋天");
    public static final Season SWINTER=new Season("冬天");

    //设置get、set容器


    public String getSeasonName() {
        return seasonName;
    }

    @Override
    public String toString() {
        return "Season{" +
                "seasonName='" + seasonName + '\'' +
                '}';
    }
}

enum Enum{
    //提供当前枚举类的多个
    SPRING("春天"),
    SUMMER("夏天"),
    AUTUMN("秋天"),
    WINTER("冬天");
    //声明Season对象的属性
    private final String seasonName;

    //私有化类构造器,为对象属性赋值
    private Enum(String seasonName){
        this.seasonName = seasonName;
    }

    public String getSeasonName() {
        return seasonName;
    }

    @Override
    public String toString() {
        return "Enum{" +
                "seasonName='" + seasonName + '\'' +
                '}';
    }
}
