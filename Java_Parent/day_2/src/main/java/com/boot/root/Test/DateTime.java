/*
 * FileName: DateTime
 * Author:   Lenovo
 * Date:     2021/7/19 19:39
 * Description: 日期有关类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.boot.root.Test;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTime {

    /**
     * SimpleDateFormat的使用：对日期Date类的格式化和解析
     */
    /**
     * 格式化——>日期——字符串
     * 解析：字符串——事件
     */
    @Test
    public void test(){
        String pattern="yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat s=new SimpleDateFormat(pattern);

        Date date = new Date();
        System.out.println(date);

        String format = s.format(date);
        System.out.println(format);

    }
}
