/*
 * FileName: ReverseStr
 * Author:   Lenovo
 * Date:     2021/7/19 17:03
 * Description: 反转字符串
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.boot.root.Test;

import org.junit.Test;

public class ReverseStr {

    /**
     * 讲一个字符串反转,反转指定部分,指定开始及结束位置
     *      char型数组反转
     *
     * @param str
     * @param start
     * @param end
     * @return
     */
    //方式1：转为char数组
    public  String reverse(String str,int start,int end){
        if(str == null|str==""){
            return null;
        }
        char[] chars = str.toCharArray();
        for(int x=start,y=end;x<y;x++,y--){
            char temp=chars[x];
            chars[x] = chars[y];
            chars[y] = temp;
        }
        return new String(chars);
    }

    //方式2：String拼接——>先截取再拼接——>每次新造一个对象,效率不高
    public String reverse1(String str,int start,int end){
        String s=str.substring(0, start);
        for(int i=end;i>=start;i--){
            s+=str.charAt(i);
        }
        s+=str.substring(end+1);
        return s;
    }

    //使用StringBuffer或StringBuilder替换String
    public StringBuilder reverse2(String str,int start,int end){
        StringBuilder s=new StringBuilder(str.length());
        s.append(str.substring(0,start));
        for(int i=end;i>=start;i--){
            s.append(str.charAt(i));
        }
        s.append(str.substring(end+1));
        return s;
    }

    @Test
    public void test1(){
        System.out.println(reverse("abcdefg",2,5));
        System.out.println(reverse1("abcdefg",2,5));
        System.out.println(reverse2("abcdefg",2,5));
    }
}
