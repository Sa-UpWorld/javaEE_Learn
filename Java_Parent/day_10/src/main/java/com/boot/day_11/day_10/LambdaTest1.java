/*
 * FileName: LambdaTest1
 * Author:   Lenovo
 * Date:     2021/7/25 17:25
 * Description: 函数式接口测试
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.boot.day_11.day_10;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * @author Lenovo
 *      java内置的4大核心函数式接口
 *          消费型接口   Consumer<T>  void accept(T t)
 *          供给型接口   Supplier<T>  T get()
 *          函数式接口   Function<T,R>  R apply(T t)
 *          断定型接口   Predicate<T>   boolean test(T t)
 */
public class LambdaTest1 {

    @Test
    public void test(){
        happyTime(500, money -> System.out.println(money));
    }

    public void happyTime(double money, Consumer<Double> con){
        con.accept(money);
    }

    /**
     * 断定型函数式接口——根据指定规则过滤
     */
    @Test
    public void test2(){
        List<String> list= Arrays.asList("背景","南京","天津");
        List<String> list1 = filterString(list, s -> s.contains("南"));
        System.out.println(list1);
    }

    public List<String> filterString(List<String> list, Predicate<String> pre){
        ArrayList<String> filterList=new ArrayList<>();
        for (String s : list) {
            if(pre.test(s)){
                filterList.add(s);
            }
        }
        return filterList;
    }
}
