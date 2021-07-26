/*
 * FileName: SetTest
 * Author:   Lenovo
 * Date:     2021/7/21 11:06
 * Description: 无序集合Set测试
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.boot.day_11.day_10.day_4;

import org.junit.Test;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Set
 */
public class SetTest {

    @Test
    public void test(){
        Set set=new LinkedHashSet();
        set.add(123);
        set.add("aaa");
        set.add("bbb");
        set.add(123);
    //        for (Object o : set) {
    //      System.out.println(o);
    //        }
        //lomda表达式遍历
    set.forEach(System.out::println);
    }

}
