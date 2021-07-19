/*
 * FileName: NewDate
 * Author:   Lenovo
 * Date:     2021/7/19 20:45
 * Description: JDK新的日期格式
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.boot.root.Test;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;

public class NewDate {

    @Test
    public void test(){

        //now——>获取当前时间
//        LocalDateTime localDateTime=LocalDateTime.now();
//        System.out.println(localDateTime);
//        LocalDate localDate=LocalDate.now();
//        System.out.println(localDate);
//        LocalTime localTime=LocalTime.now();
//        System.out.println(localTime);
        //of——>设置指定时间
        LocalDateTime localDate1 = LocalDateTime.of(2020,9,8,21,45,37);
        System.out.println(localDate1);
        //getXXX——>获取当前的第几天、第几年、周的第几天等
        System.out.println(localDate1.getDayOfWeek());
        //withXXOfXX——>设置带指定时间的时间对象
        System.out.println(localDate1.withDayOfMonth(25));
        System.out.println(localDate1.getDayOfMonth());

        //plus——>加上指定时间
        //minus——>减指定时间
    }

    /**
     * Instant使用
     */
    @Test
    public void test1(){
        //得到格林时间
        Instant instant=Instant.now();
        //计算时间偏移量
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);
        //获取自1970年1月1日0时0分0秒的时间戳——>即毫秒数
        System.out.println(instant.toEpochMilli());
        Instant instant1=Instant.ofEpochMilli(1626699979141L);
        System.out.println(instant1);
    }

    /**
     * DateTimeFormatter
     */
    @Test
    public void test2(){
//        //方式一：预定义的标准格式，如:ISO_LOCAL_DATE_TIME;ISO_LOCAL_DATE;ISO_LOCAL_TIME
//        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
//        //格式化:日期——>字符串
//        LocalDateTime localDate=LocalDateTime.now();
//        String str1=formatter.format(localDate);
//        System.out.println(localDate);
//        System.out.println(str1);
//
//        TemporalAccessor parse = formatter.parse(str1);
//        System.out.println(parse);

        //本地相关格式,如:ofLocalizedDateTime(FormatStyle.LONG)
        DateTimeFormatter formatter=DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        //格式化时间
        System.out.println(formatter.format(LocalDateTime.now()));

    }
}
