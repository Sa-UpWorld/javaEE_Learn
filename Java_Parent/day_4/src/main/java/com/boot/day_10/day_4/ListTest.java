/*
 * FileName: ListTest
 * Author:   Lenovo
 * Date:     2021/7/20 17:40
 * Description: ArrayList、LinkedList、Vector使用
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.boot.day_10.day_4;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author Lenovo
 */
public class ListTest {

    @Test
    public void test(){

        Collection coll=new ArrayList();
        coll.add(123);
        coll.add("abc");
        coll.add(678);
        coll.add(new String("tom"));

        // contains
        System.out.println(coll.contains(123));

        //containsAll——>集合所有元素是否存在于当前集合
        Collection coll1=new ArrayList();
        coll1.add(123);
        coll1.add("abc");

        System.out.println(coll.containsAll(coll1));

        //remove
//        System.out.println(coll.remove(123));
//        System.out.println(coll);
//
//        //removeAll(Collection)——>移除collection中元素
//        System.out.println(coll.removeAll(coll1));
//        System.out.println(coll);
//        coll.add(123);
//
//        //        retainAll,两集合交集
//        System.out.println(coll.retainAll(coll1));
//        System.out.println(coll);

//        // equals
//        // hashCode,返回当前对象哈希值
//        System.out.println(coll.hashCode());
//        // toArray()集合转为数组
//        System.out.println(coll.toArray());
        //迭代器,遍历容器内容而不暴露细节
        Iterator iterator=coll.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
