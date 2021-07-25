/*
 * FileName: RandomAccess
 * Author:   Lenovo
 * Date:     2021/7/23 22:45
 * Description: RandomAccessFileTest
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.boot.day_10.day_8;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author Lenovo
 *  RandomAccessFile的使用
 *      1.直接继承java.lang.Object类，实现了DataInput和DataOutput两个接口
 *      2.既可以作为输入流，也可以作为输出流
 *      3.构造器——>new RandomAccessFile（String,mode）
 *          mode——>"r"只读、"rw"读写、"rwd"读写并同步文件内容更新、"rws"读写并同步文件内容和元数据更新
 *      4.作为输出时对文件内容的覆盖:
 *
 */
public class RandomAccess {

    @Test
    public void test(){
        //实例化随机流
        RandomAccessFile raf=null;
        try {
            raf=new RandomAccessFile(new File("hello.txt"),"r");
            byte[] buff=new byte[1024];
            int len;
            while ((len=raf.read(buff))!=-1){
                System.out.println(new String(buff,0,len));
            }
            raf.read(buff);

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(raf!=null){
                    raf.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * RandomAccessFile作为输出流出现
     *      写入文件不存在时则执行过程中自动创建；如果文件存在，则从开始进行覆盖，覆盖写入的数据的长度
     *      如果要指定位置开始覆盖，则利用seek()偏移指针
     */
    @Test
    public void test1(){
        //实例化随机流
        RandomAccessFile raf=null;
        try {
            raf=new RandomAccessFile(new File("hello.txt"),"rw");
            raf.seek(3);
            raf.write("user".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(raf!=null){
                    raf.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 使用RandomInputStream实现插入效果
     */
    @Test
    public void test2() {
        //创建随机流
        RandomAccessFile raf=null;
        try {
            raf=new RandomAccessFile(new File("hello.txt"),"rw");
            raf.seek(3);
            StringBuilder sb=new StringBuilder((int)new File("hello.txt").length());
            byte[] buff=new byte[20];
            int len;
            while ((len=raf.read(buff))!=-1){
                sb.append(new String(buff,0,len));
            }
            raf.seek(3);
            raf.write(("username"+sb).getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                if(raf!=null){
                    raf.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //思考：将StringBuilder替换为ByteArrayOutputStream
        /**
         *      RandomAccessStream可以实现多线程断点下载功能——下载前创建两个临时文件一个是
         *      与下载文件大小相同的空文件，另一个是记录文件指针的位置文件，每次暂停时都会记录指针位置
         */
    }
}
