/*
 * FileName: StrongStream
 * Author:   Lenovo
 * Date:     2021/7/26 20:55
 * Description: 增强Stream API
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.boot.day_12;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author Lenovo
 *      Stream API新增4个方法
 *          takeWhile(Predicate p)——>筛选直到不满足停掉
 *          dropWhile(Predicate p)——>满足情况不要,直到找到第一个满足的,返回剩余元素
 *          ofNullable——>形参变量可为null的单个元素
 *          iterate(Predicate p)——>重载的迭代,静态方法
 *              Stream.iterate(0, x -> x < 8, x -> x + 1).forEach(System.out::println);
 *                  x+1<8的值打印
 *      Optional类中的stream()
 *
 */
public class StrongStream {

    @Test
    public void test(){
        List<Integer> list= Arrays.asList(9,10,5,8,45,13,20,15);
        list.stream().takeWhile(e -> e > 8).forEach(System.out::println);
        list.stream().dropWhile(e -> e < 20).forEach(System.out::println);
        Stream.iterate(0, x -> x < 8, x -> x + 1).forEach(System.out::println);
    }

    @Test
    public void test1(){
        List<Integer> list= Arrays.asList(9,10,5,8,45,13,20,15);
        Optional<List<Integer>> list1 = Optional.ofNullable(list);
        list1.stream().flatMap(x -> (x.stream().filter(e -> e > 8))).forEach(System.out::println);
    }
}
