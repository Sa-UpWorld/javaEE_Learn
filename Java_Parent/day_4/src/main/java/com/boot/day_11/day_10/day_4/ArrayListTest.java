/*
 * FileName: ArrayListTest
 * Author:   Lenovo
 * Date:     2021/7/21 10:41
 * Description: List方法测试
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.boot.day_11.day_10.day_4;

import org.junit.Test;

import java.util.ArrayList;

public class ArrayListTest {

    @Test
    public void test(){
        ArrayList list=new ArrayList();

        //add(Object)
        list.add(123);
        list.add(456);
        list.add(789);
        list.add("aaa");

        System.out.println(list);
        //add(index,Object)
        list.add(1,"bbb");
        System.out.println(list);

        ArrayList list1=new ArrayList();
        list1.add("a11");
        list1.add("b11");

        //addAll
        list.addAll(2,list1);
        System.out.println(list);

        //indexOf(Object)
        System.out.println(list.indexOf(123));

        // remove
        System.out.println(list.remove(0));
        System.out.println(list);
        System.out.println(list.remove("bbb"));
        System.out.println(list);

        //set
        System.out.println(list.set(0,"AAA"));
        System.out.println(list);
        // sublist(start,end)
        System.out.println(list.subList(1,3));
    }
}
