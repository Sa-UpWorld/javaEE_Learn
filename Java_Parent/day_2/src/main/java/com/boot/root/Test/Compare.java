/*
 * FileName: Compare
 * Author:   Lenovo
 * Date:     2021/7/19 21:44
 * Description: 比较器
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.boot.root.Test;

import org.junit.Test;

import java.util.Arrays;

public class Compare {

    /**
     * Comparable接口的使用
     *      String、包装类等实现了Comparable接口,重写了compareTo方法,给出了比较两个对象的大小
     *      重写规则:compareTo(obj)——>this大于obj则返回正整数
     */
    @Test
    public void test(){
        String[] arr=new String[] {"AA","CC","KK","MM","GG","JJ" };
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
