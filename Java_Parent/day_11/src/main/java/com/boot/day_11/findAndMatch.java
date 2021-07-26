/*
 * FileName: day_11
 * Author:   Lenovo
 * Date:     2021/7/26 9:13
 * Description: Stream API的终止测试
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.boot.day_11;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author Lenovo
 *  匹配
 *      allMatch(Predicate p)——>检测是否匹配所有
 *      anyMatch(Predicate p)——>检测是否至少匹配一个
 *      noneMatch(Predicate p)——>检测是否没有匹配所有
 *  查找
 *      findFirst()——>返回第一个元素
 *      findAny()——>返回当前流中任意元素
 *      count()——>返回流中元素总个数
 *      max(Comparator c)——>返回流中最大值
 *      min(Comparator c)——>返回流中最小值
 */
public class findAndMatch {

    /**
     * allMatch()——>找到全部匹配
     */
    @Test
    public void test(){
        //获取List元素
        List<Integer> list= Arrays.asList(12,15,18,20,23,8,6,9);
        //获取流
        boolean a = list.stream().allMatch(e->e>15);
        System.out.println(a);
    }

    /**
     * anyMatch()——>找到至少一个匹配
     */
    @Test
    public void test1(){
        //获取List元素
        List<Integer> list= Arrays.asList(12,15,18,20,23,8,6,9);
        //获取流
        System.out.println(list.stream().anyMatch(e->e>15));
    }

    /**
     * noneMatch()——>找到没有匹配的
     */
    @Test
    public void test2(){
        //获取List元素
        List<Integer> list= Arrays.asList(12,15,18,20,23,8,6,9);
        //获取流
        System.out.println(list.stream().noneMatch(e->e>20));
    }

    /**
     * findFirst()——>找到第一个
     */
    @Test
    public void test3(){
        //获取List元素
        List<Integer> list= Arrays.asList(12,15,18,20,23,8,6,9);
        // 获取流
        System.out.println(list.stream().findFirst());
    }

    /**
     * findAny()——>找到任意一个,必须配合并行流使用
     */
    @Test
    public void test4(){
        //获取List元素
        List<Integer> list= Arrays.asList(12,15,18,20,23,8,6,9);
        // 获取流
        System.out.println(list.parallelStream().findAny());
    }

    @Test
    public void test5(){
        //获取List元素
        List<Integer> list= Arrays.asList(12,15,18,20,23,8,6,9);
        // 获取流
        System.out.println(list.stream().filter(e -> e > 9).count());
    }

    /**
     * 比较器
     *      max(Comparator c)——>查最大
     *      min(Comparator c)——>查最小
     */
    @Test
    public void test6(){
        //获取List元素
        List<Integer> list= Arrays.asList(12,15,18,20,23,8,6,9);
        // 获取流并获取最大
        System.out.println(list.stream().max(Integer::compare));
        // 获取流并获取最小
        System.out.println(list.stream().min(Integer::compare));
        // 内部迭代
        list.stream().forEach(System.out::println);
    }
}
