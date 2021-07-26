/*
 * FileName: Statute
 * Author:   Lenovo
 * Date:     2021/7/26 9:53
 * Description: Stream API规约及收集测试
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.boot.day_11;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Lenovo
 * Stream API
 *      规约
 *          reduce(T iden,BinaryOperator b)——>将流中数据反复结合,返回T
 *          reduce(BinaryOperator b)——>将流中数据反复集合，得到一个值，返回Optional<T>
 *      收集
 *          collect(Collector c)——>将流转换为其他形式，接收一个Collector(List Set Map)接口的实现,用于给Stream中元素做汇总的方法
 */
public class Statute {

    /**
     * reduce(T iden,BinaryOperator b)——>将流中数据返回结合，返回T
     */
    @Test
    public void test(){
        //获取List元素
        List<Integer> list= Arrays.asList(12,15,18,20,23,8,6,9);
        // 获取流求规约
        System.out.println(list.stream().reduce(0, Integer::sum));
        // 获取流求规约
        System.out.println(list.stream().reduce(Integer::sum));
    }

    /**
     * collect(Collector c)——>将流转换为其他形式,
     *      接收一个Collector接口的实现,用于给Stream元素做汇总
     * Collector通过Collectors的工具类的静态方法获取
     */
    @Test
    public void tes1(){
        //获取List元素
        List<Integer> list= Arrays.asList(12,15,18,20,23,8,6,9);
        // 收集
        List<Integer> collect = list.stream().filter(e -> e > 15).collect(Collectors.toList());
        collect.forEach(System.out::println);
    }
}
