/*
 * FileName: StringTest
 * Author:   Lenovo
 * Date:     2021/7/17 10:52
 * Description: Java常用类之String
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.boot.root.day_3;

import org.junit.Test;

class MyTest{
    String str=new String("good");
    char[] c={'t','e','s','t'};

    public void change(String str,char[] a){
        str="test_ok";
    }
}

public class StringTest {

    @Test
    /**
     * String实例化效率
     */
    public void test1(){
        String s1="abc";//字面量创建时，s1声明于方法区的字符串常量池中
        //通过这种方式创建String，内存中存在两个对象，一个是堆空间中new结构，另一个是char[]对应的常量池中的数据"abc"
        String s2=new String("abc");//new创建的方式，此时的s2保存地址值，数据在堆空间中开辟空间存放
    }

}
