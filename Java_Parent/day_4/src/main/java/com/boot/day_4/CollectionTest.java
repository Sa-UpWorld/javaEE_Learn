/*
 * FileName: CollectionTest
 * Author:   Lenovo
 * Date:     2021/7/20 16:52
 * Description: 集合测试
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.boot.day_4;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author Lenovo
 */
public class CollectionTest {

    @Test
    public void test(){
        Collection coll=new ArrayList();

        //add()
        coll.add("aa");
        coll.add("bb");
        //自动装箱
        coll.add(123);
        coll.add("cc");
        // size
        System.out.println(coll.size());

        //addAll()
        Collection coll1=new ArrayList();
        coll1.add("ee");
        coll1.add("ff");
        coll.addAll(coll1);
        System.out.println(coll.size());

        // isEmpty()
        System.out.println(coll.isEmpty());

        //clear()
        coll.clear();
        System.out.println(coll.isEmpty());
    }
}
