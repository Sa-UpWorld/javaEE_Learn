/*
 * FileName: FileTest
 * Author:   Lenovo
 * Date:     2021/7/22 15:43
 * Description: File类使用测试
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.boot.day_6;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author Lenovo
 * File类的使用：
 *  1.File类的对象，代表一个文件或一个文件目录
 *  2.File类的声明在java.io包下
 */
public class FileTest {

    @Test
    public void test(){
        /**
         * 4中初始化构造器
         */
        //构造器1
        File file=new File("hello.txt");
        System.out.println(file);
        //构造器2
        File file1=new File("D:\\yan1xxq\\Java基础\\javaEE_Parent\\Java_Parent\\day_6","Hello");
        System.out.println(file1);
        //构造器3
        File file2 = new File(file1,"he.txt");
        System.out.println(file2);
        //构造器4
        File file3 = new File("URI");

    }

    @Test
    public void test1() {
        /**
         * 常用方法----不涉及IO流的读写
         *      public String getAbsolutePath()——>获取绝对路径
         *      public String getPath()——>获取路径
         *      public String getName()——>获取文件名
         *      public String getParent()——>获取父目录路径
         *      public long length()——>获取文件长度(字节数),不能获取目录长度
         *      public long lastModified()——>获取最后一次修改时间,毫秒值
         *      ---以下方法适用于文件目录
         *      public String[] list()——>获取指定目录下所有文件或者文件目录的名称数组
         *      public File[] listFiles()——>获取指定目录下所有文件或者文件目录的File数组
         *      --文件重命名为目录
         *      public boolean renameTo(file)---file存在且file1不存在
         *      ----判断是否存在或可读的方法
         *      public boolean isDirectory()——>判断文件是否为目录
         *      public boolean isFile()——>判断是否为文件
         *      public boolean exists()——>判断是否存在
         *      public boolean canRead()——>判断是否可读
         *      public boolean canWrite()——>判断是否可读
         *      public boolean isHidden()——>判断是否隐藏
         *      ----创建硬盘文件或文件目录
         *      public boolean createNewFile()——>创建文件，如果文件成功则不创建
         *      public boolean mkdir()——>创建文件目录，如果目录已存在则不创建；如果父目录不存在，也不创建
         *      public boolean mkdirs()——>创建文件目录，如果父目录不存在，也不创建
         *      ----删除文件或目录
         *      public boolean delete()——>该删除不走回收站
         * IO流读写方法:
         *
         */
        File file = new File("hello.txt");
        System.out.println("绝对路径:"+file.getAbsolutePath());
        System.out.println("相对路径:"+file.getPath());
        System.out.println("文件名:"+file.getName());
        System.out.println("获取父目录:"+file.getParent());
        System.out.println("字节数:"+file.length());
        System.out.println("最后修改时间:"+file.lastModified());
//        System.out.println("目录下所有文件名:"+file.list());
//        System.out.println("目录下所有文件:"+file.listFiles());
    }

    @Test
    public void test2(){
        File file=new File("D:\\yan1xxq\\Java基础\\javaEE_Parent\\Java_Parent\\day_6");
//        String[] list = file.list();
//        for (String s : list) {
//            System.out.println(s);
//        }
        File[] files = file.listFiles();
        for (File file1 : files) {
            System.out.println(file1);
        }
    }

    @Test
    public void test3(){
        File file=new File("hello.txt");
        System.out.println(file);
        //构造器2
        File file1=new File("D:\\yan1xxq\\Java基础\\javaEE_Parent\\Java_Parent\\day_6","Hi.txt");
        System.out.println(file.renameTo(file1));
    }

    @Test
    public void test4(){
    File file = new File("D:\\yan1xxq\\Java基础\\javaEE_Parent\\Java_Parent\\day_6");
        System.out.println(file.isDirectory());
        System.out.println(file.isFile());
        System.out.println(file.exists());
        System.out.println(file.canRead());
        System.out.println(file.canWrite());
        System.out.println(file.isHidden());
    }

    @Test
    public void test5() throws IOException {
        //文件创建
        File file = new File("hello.txt");
        if(file.createNewFile()){
            System.out.println("创建成功");
        }else {
            if(file.delete()){
                System.out.println("删除成功!");
            }
        }
    }

    @Test
    public void test6() throws IOException {
        File file = new File("D:\\yan1xxq\\Java基础\\Menu\\he.txt");
        if(file.mkdirs()){
            System.out.println("目录创建成功!");
        }
    }


}
