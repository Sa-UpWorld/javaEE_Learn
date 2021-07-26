/*
 * FileName: CollectionsTest
 * Author:   Lenovo
 * Date:     2021/7/21 21:02
 * Description: Collections工具类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.boot.day_11.day_10.day_4;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Lenovo
 *
 *      Collections和Collection区别?
 *      常用方法;
 *          reverse(List)——>反转List中元素顺序
 *          shuffle(List)——>对List集合元素进行随机排序
 *          sort(List)——>根据元素的自然顺序对指定List集合元素按升序排序
 *          sort(List,Comparator)——>根据指定的Comparator产生的顺序对List集合进行排序
 *          swap(List,int,int)——>将指定的List集合中的i处元素和j处元素进行交换
 *          max(List)——>找到最大
 *          max(List,Comparator)——>根据Comparator指定顺序找到最大
 *          min(List)——>找到最小
 *          min(List,Comparator)——>根据Comparator指定顺序找到最小
 *          int frequency(Collection,Object)——>找到指定元素出现次数
 *          copy(src,desk)——>将src内容复制到desk
 *         boolean replaceAll(list,obj,newVal)——>新值换旧值
 *         synchronizedXXX()——>线程安全
 */
public class CollectionsTest {

    @Test
    public void test(){
        List list=new ArrayList<>();
        list.add(123);
        list.add(456);
        list.add(789);
        System.out.println(list);
        Collections.shuffle(list);
        System.out.println(list);
        Collections.reverse(list);
        System.out.println(list);
    }

}
