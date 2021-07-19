/*
 * FileName: StrAppearCount
 * Author:   Lenovo
 * Date:     2021/7/19 18:08
 * Description: 一个字符串在另一个字符串出现的次数
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.boot.root.Test;

import org.junit.Test;

public class StrAppearCount {

    /**
     * 获取一个字符串在另一个字符串中出现的次数
     */

    public Integer getCount(String main,String str){
        int length = main.length();
        int length1 = str.length();
        //判断主字符串是否大于从字符串
        if(length<length1){
            return 0;
        }

        /**
         * 在方法区频繁修改String,效率差
         */
//        int sum=0;
//        while (main.indexOf(str)!=-1){
//            int index = main.indexOf(str);
//            sum++;
//            main=main.substring(index+str.length());
//        }

        /**
         * 改进,指定查找位置，不频繁修改String
         */

        int sum=0;
        int index=0;
        while (main.indexOf(str,index)!=-1){
            index = main.indexOf(str,index)+str.length();
            sum++;
        }

        return sum;
        /**
         * 以下为缺陷方法,因为查找子串出现个数时,如果主串中多个子串并列出现，会出现漏计情况
         */
//        String[] s=main.split(str);
//        System.out.println(str+"的个数为:"+(s.length-1));
//        return s.length-1;
    }

    @Test
    public void test1(){
        System.out.println("ab");
        System.out.println("abkkcadkabkebfkaabkskab");
        System.out.println(getCount("abkkcadkabkebfkaabkskab","ab"));
    }
}
