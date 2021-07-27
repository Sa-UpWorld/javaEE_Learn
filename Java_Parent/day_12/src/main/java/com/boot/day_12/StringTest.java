/*
 * FileName: StringTest
 * Author:   Lenovo
 * Date:     2021/7/26 21:56
 * Description: Java11新增的String方法
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.boot.day_12;

import org.junit.Test;

/**
 * @author Lenovo
 *      String新方法
 *          isBlank()——>是否为空白
 *          strip()——>去除收尾空白
 *          stripTrailing()——>去除尾部空格
 *          stripLeading()——>去除头部空格
 *          repeat(int count)——>复制
 *          lines.count()——>计算行数
 */
public class StringTest {

    @Test
    public void test(){
        String str=new String(" 你好 ");
        System.out.println(str.isBlank());
        System.out.println(str.strip());
        System.out.println(str.stripTrailing());
        System.out.println(str.stripLeading());
        System.out.println(str.repeat(5));
        System.out.println(str.lines().count());
    }
}
