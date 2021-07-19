/*
 * FileName: MaxSameStr
 * Author:   Lenovo
 * Date:     2021/7/19 18:38
 * Description: 获取两个字符串最大的相同子串
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.boot.root.Test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class MaxSameStr {

    /**
     * 找到主串中出现的最大子串
     */
    public String getMaxSameStr(String str1,String str2){
        String maxStr=(str1.length()>=str2.length())?str1:str2;
        String minStr=(str2.length()>=str1.length())?str1 : str2;
        String temp=new String();
        List<String> str=new ArrayList<>();
        for(int i=0;i<minStr.length()-1;i++){
            for(int j=i+1;j<minStr.length();j++){
                if(maxStr.contains(minStr.substring(i,j))){
                    temp=minStr.substring(i,j);
                }
            }
            str.add(temp);
        }
        temp=str.get(0);
        int flag=0;
        for(String s:str){
            if(temp.length()<s.length()){
                temp=s;
            }
        }
        String m=new String();
        for(String s:str){
            if(temp.length()==s.length()&&!temp.equals(s)){
                m+=" "+s;
            }
        }
        temp+=m;
        return temp;
    }

    @Test
    public void test(){
        System.out.println(getMaxSameStr("123065abcwerthellobyuiodefabcdef", "c123065vhellobnabcdefm"));
    }


}
