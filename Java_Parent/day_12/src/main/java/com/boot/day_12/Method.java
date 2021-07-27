/*
 * FileName: Method
 * Author:   Lenovo
 * Date:     2021/7/26 19:53
 * Description: 接口方法测试
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.boot.day_12;


import org.junit.Test;

import java.io.*;

public class Method {

    @Test
    public void test(){
        NewFutureTest.sayWord();
    }

    @Test
    public void test1(){
        //ClassLoader c=this.getClass().getClassLoader();
        //创建输入输出流
        InputStream is=null;
        OutputStream os=null;
        try {
            is=new FileInputStream("hello.txt");
            os=new FileOutputStream("hello1.txt");
            is.transferTo(os);
        } catch (IOException e) {
            e.printStackTrace();
        }finally{

            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if(os!=null){
                    os.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
