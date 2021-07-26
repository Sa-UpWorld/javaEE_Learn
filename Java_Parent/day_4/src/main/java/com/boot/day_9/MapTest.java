/*
 * FileName: MapTest
 * Author:   Lenovo
 * Date:     2021/7/21 16:26
 * Description: Map实现类测试
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.boot.day_9;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

/**
 *      /--Map：双列数据,存储key-value键值对
 *          |--HashMap——Map的主要实现类，线程不安全，效率高；可存储null的key和value。底层最早基于数组+链表，之后优化为数组+链表+红黑树
 *              |--LinkedHashMap——HashMap的子类,解决HashMap遍历效率低问题——基于指针
 *              在原有的HashMap底层结构基础上添加了一对指针——双向，适合于频繁的遍历操作
 *          |--TreeMap——按照添加的key-value键值对进行排序，实现有序遍历——以key排序，此时考虑自然排序和定制排序，底层基于红黑树（二叉排序树）
 *          |--Hashtable——古老的实现类,线程安全，效率低，不能存储null的key和value
 *              |--Properties：常用来处理配置文件，key和value都为String类型
 *          |--CurrentHashMap——实现分段锁
 *     Map的底层：
 *          key无序不可重复   使用set存储key——key所在的类需要重写equals和HashCode方法
 *          value 无序可重复     collection存储所有value——value所在类需要重写equals方法
 *          一个键值对：key-value构成一个Entry对象——无序不可重复
 *     HashMap的底层实现原理：
 *           实例化时创建初始长度为16的一维数组Entry[] table -- Node[] table(JDK8之后)
 *              存放时计算key所在类的HashCode，通过类似散列函数的算法找到当前数据的存放位置
 *              如果此位置无数据则直接添加；否则进行HashCode和equals的比较，不一样则以链表形式挂在该位置，否则不添加
 *     HashCode添加过程中如果溢出，则默认扩容为原容量2倍并复制原数据。
 * @author Lenovo
 */
public class MapTest {

    @Test
    public void test(){

        Map map=new HashMap();
        map.put(1,123);
        map.put(1,123);
        System.out.println(map);
    }

    @Test
    public void test1(){

        Map map1=new HashMap();
        //put
        map1.put(15,1);
        map1.put(16,4);

        Map map=new HashMap();
        //put
        map.put(1,123);
        map.put(2,456);
        map.put(3,678);
        map.put(4,91011);

        System.out.println(map);

        // putAll
        map.putAll(map1);
        System.out.println(map);

        map.remove(15);
        System.out.println(map);

        //clear()
        map.clear();
        System.out.println(map.size());
    }

    @Test
    public void test3(){
        Map map1=new HashMap();
        //put
        map1.put(15,1);
        map1.put(16,4);
        System.out.println(map1.get(15));
        System.out.println(map1.containsKey(15));
        System.out.println(map1.containsValue(1));
        System.out.println(map1.isEmpty());
    }

    @Test
    public void test4() {
        //遍历Map元素
        Map map=new HashMap();
        //put
        map.put(1,123);
        map.put(2,456);
        map.put(3,678);
        map.put(4,91011);

//        方式1,遍历所有key集合,KeySet
        Set set = map.keySet();
        Iterator iterator=set.iterator();
        while (iterator.hasNext()){
            System.out.println(map.get(iterator.next()));
        }

        //方式2，遍历所有values
        Collection c=map.values();
        Iterator iter1=c.iterator();
        while (iter1.hasNext()){
            System.out.println(iter1.next());
        }

        //方式3，遍历所有的entryset
        Set set1 = map.entrySet();
        Iterator iter2=set1.iterator();
        while (iter2.hasNext()){
            Object obj=iter2.next();
            Map.Entry entry=(Map.Entry)obj;
            System.out.println(entry.getValue());
        }
    }

    @Test
    public void test5(){
        Map map=new TreeMap();
        map.put(1,"aaa");
        map.put(2,"bbb");
        map.put(3,"ccc");
    System.out.println(map);
    }

    @Test
    public void test6(){
        //新建Properties对象
        Properties pros=new Properties();
        FileInputStream in= null;
        try {
                in =new FileInputStream(
              "src/main/resources/db.properties");
            try {
                pros.load(in);
            } catch (IOException e) {
                e.printStackTrace();
            }
            String name=pros.getProperty("prop.username");
            String password=pros.getProperty("prop.password");
            System.out.println(name+" "+password);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally{
            if(in!=null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
