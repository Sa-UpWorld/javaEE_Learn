/*
 * FileName: TCPTest1
 * Author:   Lenovo
 * Date:     2021/7/24 11:06
 * Description: TCP测试2
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.boot.day_8;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Lenovo
 *      客户端与服务端通信
 *          服务端成功后为客户端反馈
 */
public class TCPTest1 {

    @Test
    public void client(){
        //创建套接字
        Socket socket=null;
        OutputStream os =null;
        BufferedInputStream bis =null;
        ByteArrayOutputStream bos=null;
        InputStream is = null;
        try {
            socket=new Socket(InetAddress.getByName("127.0.0.1"),8899);
            //创建输出流
            os=socket.getOutputStream();
            //创建文件缓冲流读取文件
            bis=new BufferedInputStream(new FileInputStream("hello.txt"));
            byte[] buff=new byte[20];
            int len;
            while ((len=bis.read(buff))!=-1){
                os.write(buff, 0, len);
            }
            //停止数据输出
            socket.shutdownOutput();

            //创建字节读取字符流
            bos=new ByteArrayOutputStream();
            //接收服务端反馈信息
            is=socket.getInputStream();
            byte[] cbuff = new byte[20];
            int len1;
            while ((len1=is.read(cbuff))!=-1){
                bos.write(cbuff, 0, len1);
            }
            System.out.println(bos.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {

            try {
                if(bos != null){
                    bos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if(is != null){
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if(bis != null){
                    bis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if(os != null){
                    os.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if(socket != null){
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Test
    public void server(){
        //创建服务端套接字
        ServerSocket ss=null;
        Socket socket = null;
        InputStream in=null;
        BufferedOutputStream bos=null;
        OutputStream out=null;
        try {
            ss=new ServerSocket(8899);
            socket=ss.accept();
            //创建输入流
            in=socket.getInputStream();
            //创建文件输出流
            bos = new BufferedOutputStream(new FileOutputStream("hel.txt"));
            //读取数据
            byte[] buff=new byte[20];
            int len;
            //read——>阻塞式方法，
            while ((len=in.read(buff))!=-1){
                bos.write(buff, 0, len);
            }
            //向客户端反馈成功信息
            out=socket.getOutputStream();
            //写入输出信息
            out.write("文件接收成功".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {

            try {
                if(out != null){
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if(bos != null){
                    bos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if(in!=null){
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if(socket != null){
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if(ss != null){
                    ss.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
