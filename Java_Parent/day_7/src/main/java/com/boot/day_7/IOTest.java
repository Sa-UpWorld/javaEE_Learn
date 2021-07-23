/*
 * FileName: IOTest
 * Author:   Lenovo
 * Date:     2021/7/22 22:24
 * Description: IO流测试
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.boot.day_7;

import org.junit.Test;

import java.io.*;

/**
 * @author Lenovo
 *  流的分类：
 *      数据单位：字节流（8bit）、字符流（16bit）
 *      数据流向：输入流、输出流
 *      流的角色：节点流、处理流
 *  流的体系结构：
 *          抽象基类：           节点流（文件流）            缓冲流(处理流的一种)
 *          InputStream         FileInputStream         BufferedInputStream
 *          OutputStream        FileOutputStream        BufferedOutputStream
 *          Reader              FileReader              BufferedReader
 *          Writer              FileWriter              BufferedWriter
 *
 */
public class IOTest {

    /**
     * 将hello.txt文件内容读入内存
     * 异常的处理:为了保证流资源一定执行关闭操作，需要使用try-catch-finally捕获异常
     * 读入的文件必须存在,否则会抛出文件找不到异常
     */
    @Test
    public void test() {
        //实例化file对象
        File file=new File("hello.txt");
        //提供具体流
        FileReader reader = null;
        try {
            reader = new FileReader(file);
            //数据读取,read()返回读入的字符,如果读完返回-1
            int data;
            while ((data=reader.read())!=-1){
                System.out.print((char) data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            //关闭流
            try {
                if(reader!=null){
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     *     read()的其他重载方法
     */
    @Test
    public void test1(){
        //File类的实例化
        File file = new File("hello.txt");
        //FileReader流的实例化
        FileReader reader=null;
        try {
            reader = new FileReader(file);
            //读入操作
            char[] cbuf=new char[5];
            int len;
            while((len=reader.read(cbuf))!=-1){
                for(int i=0;i<len;i++){
                    System.out.print(cbuf[i]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            //流资源关闭
            try {
                if(reader!=null){
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 从内存中写出数据到硬盘指定文件
     *      write时,文件不存在则自动创建;存在则指定追加还是覆盖——由流的构造器指定覆盖(false)还是追加
     */
    @Test
    public void test2(){
        //提供File类对象，指明写出到的文件
        File file=new File("hello1.txt");
        //提供FileWriter对象,用于数据写出
        FileWriter fw=null;
        try {
            fw=new FileWriter(file,true);
            //向文件写出数据
            fw.write("\nusername=sa;\npassword=13663526455");
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            //关闭流资源
            try {
                if(fw!=null){
                    fw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 文件读写操作
     */
    @Test
    public void test3() {
        //创建File类对象
        File in = new File("hello.txt");
        File out=new File("hello1.txt");
        //创建输入流和输出流对象
        FileReader fr=null;
        FileWriter fw=null;
        try {
            fr=new FileReader(in);
            fw = new FileWriter(out);
            //数据的读入和写出操作
            char[] cbuf=new char[5];
            //记录每次读入的cbuf数组中的字符个数
            int len;
            while((len=fr.read(cbuf))!=-1){
                fw.write(cbuf, 0, len);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally{
            //关闭流资源
            try {
                if(fw!=null){
                    fw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }finally{
                try {
                    if(fr!=null){
                        fr.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * FileInputStream和FileOutPutStream字节流
     *      读文本文件，使用字符流处理
     *      非文本文件，使用字节流处理
     */
    @Test
    public void test5(){
        //造文件
        File f=new File("hello.txt");
        //造字节流对象
        FileInputStream in=null;
        try {
            in=new FileInputStream(f);
            //读数据
            byte[] buf=new byte[5];
            int len;
            while ((len=in.read(buf))!=-1){
//                for(int i=0;i<len;i++){
//                    System.out.print(buf[i]);
//                }
                String str=new String(buf,0,len);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                if(in!=null){
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 字符流不适合处理图片等字节流数据
     */
    @Test
    public void test4(){
        //创建File对象
        File input=new File("a0.jfif");
        File output = new File("杨幂.jfif");
        //创建字节流读取写入对象
        FileInputStream inputStream=null;
        FileOutputStream outputStream=null;
        try {
            inputStream=new FileInputStream(input);
            outputStream=new FileOutputStream(output);
            //读取数据
            byte[] buff=new byte[5];
            //记录每次读取的字节长度
            int len;
            while((len=inputStream.read(buff))!=-1){
                //写出数据
                outputStream.write(buff, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                if(outputStream!=null){
                    outputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }finally{
                try {
                    if(inputStream!=null){
                        inputStream.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }



    }

    /**
     *      缓冲流（处理流的一种）——对字节流或字符流的包装
     *      缓冲流相对于字节流或字符流效率更高
     *      BufferedInputStream
     *      BufferedOutputStream
     *      BufferedReader
     *      BufferedWriter
     */
    @Test
    public void test6(){
        //造文件
        File input = new File("杨幂.jfif");
        File output = new File("唐嫣.jfif");
        //造处理流
        FileInputStream inputStream =null;
        FileOutputStream outputStream =null;
        BufferedInputStream bis =null;
        BufferedOutputStream bos=null;
        try {
            //造文件流
            inputStream = new FileInputStream(input);
            outputStream = new FileOutputStream(output);
            //造缓冲流
            bis = new BufferedInputStream(inputStream);
            bos = new BufferedOutputStream(outputStream);
            byte[] buff=new byte[5];
            //记录读取的字符长度
            int len;
            while ((len=bis.read(buff))!=-1){
                bos.write(buff, 0, len);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            //关闭外层流资源,内层自动关闭
            try {
                bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 处理流就是包装已有流之上
     * 处理文本数据的处理流
     *      使用BufferedReader和BufferedWriter复制文本文件
     */
    @Test
    public void test7(){
        //造文件、字符流、处理流
        BufferedReader br=null;
        BufferedWriter bw=null;
        try {
            br=new BufferedReader(new FileReader(new File("map.xml")));
            bw=new BufferedWriter(new FileWriter(new File("mapper.xml")));
            char[] cbuf=new char[5];
            //记录每次读取的字符长度
            int len;
            while ((len=br.read(cbuf))!=-1){
                bw.write(cbuf, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 利用字节流加密图片
     */
    @Test
    public void test8(){
        //创建字节流——输入流和输出流
        FileInputStream inputStream=null;
        FileOutputStream outputStream = null;
        try {
            inputStream=new FileInputStream(new File("杨幂.jfif"));
            outputStream=new FileOutputStream(new File("骚货.jfif"));
            //读取数据
            byte[] buff=new byte[20];
            //记录读取的字节长度
            int len;
            while ((len=inputStream.read(buff))!=-1){
                //加密
                for(int i=0;i < len; i++){
                    buff[i] = (byte)(buff[i] ^ 5);
                }
                outputStream.write(buff,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                if(inputStream != null){
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 利用字节流解密图片
     */
    @Test
    public void test9(){
        //创建字节流——输入流和输出流
        FileInputStream inputStream=null;
        FileOutputStream outputStream = null;
        try {
            inputStream=new FileInputStream(new File("骚货.jfif"));
            outputStream=new FileOutputStream(new File("杨幂骚货.jfif"));
            //读取数据
            byte[] buff=new byte[20];
            //记录读取的字节长度
            int len;
            while ((len=inputStream.read(buff))!=-1){
                //加密
                for(int i=0;i < len; i++){
                    buff[i] = (byte)(buff[i] ^ 5);
                }
                outputStream.write(buff,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                if(inputStream != null){
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 转换流——提供字节流和字符流之间的转换
     *      InputStreamReader
     *      OutputStreamWriter
     */
    @Test
    public void test10(){
        FileInputStream inputStream= null;
        InputStreamReader inputStreamReader =null;
        try {
            //创建字节流、转换流
            inputStream = new FileInputStream(new File("hello.txt"));
            inputStreamReader = new InputStreamReader(inputStream,"UTF-8");
            char[] cbuf=new char[5];
            int len;
            while ((len=inputStreamReader.read(cbuf))!=-1){
                String str=new String(cbuf, 0, len);
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(inputStreamReader!=null){
                    inputStreamReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(inputStream!=null){
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 标准输入输出流
     *      从键盘输入字符串,读取并转换为大写后输出
     */
//    @Test
    public static void main(String[] args){
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String data="";
        while (true){
            System.out.println("请输入字符串:");
            try {
                data=br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if("e".equalsIgnoreCase(data)|"exit".equalsIgnoreCase(data)){
                System.out.println("程序结束!");
                break;
            }
            data.toUpperCase();
            System.out.println(data);
        }
        try {
            if(br!=null){
                br.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 打印流  PrintStream 和 PrintWriter
     */
    @Test
    public void test12(){
           //打印流可指定sout是打印到控制台还是保存到文件
    }

    /**
     * 数据流
     *      DataInputStream
     *      DataOutputStream
     *      将内存中的数据类型写到文件中
     */
    @Test
    public void test13(){
        DataOutputStream out=null;
        try {
            out=new DataOutputStream(new FileOutputStream(new File("he.txt")));
            out.writeUTF("李晶");
            out.flush();
            out.writeInt(123);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 数据流
     *      DataInputStream
     *      DataOutputStream
     *      将内存中的数据类型写到文件中
     */
    @Test
    public void test14(){
        DataInputStream out=null;
        try {
            out=new DataInputStream(new FileInputStream(new File("he.txt")));
            String s = out.readUTF();
            int i = out.readInt();
            System.out.println(s+" "+i);
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
