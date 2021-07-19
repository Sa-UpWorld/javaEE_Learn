/*
 * FileName: TestCalandar
 * Author:   Lenovo
 * Date:     2021/7/19 20:28
 * Description: 时间类——日历
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.boot.root.Test;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class TestCalandar {

    @Test
    public void test(){
        //日历类
        Calendar calendar=Calendar.getInstance();
        //get
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
        //set
        calendar.set(Calendar.DAY_OF_MONTH,25);
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
        //add
        calendar.add(Calendar.DAY_OF_MONTH,-5);
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));

        //getTime
        System.out.println(calendar.getTime());

        //setTime
        Date date=new Date();
        calendar.setTime(date);
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));

    }
}
