/*
 * FileName: TCPTest
 * Author:   Lenovo
 * Date:     2021/7/24 10:53
 * Description: TCP测试
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
 */
public class TCPTest {

    @Test
    public void client(){
        //创建套接字
        Socket socket=null;
        OutputStream os =null;
                BufferedInputStream bis =null;
        try {
            socket=new Socket(InetAddress.getByName("127.0.0.1"),8899);
            //创建输出流
            os=socket.getOutputStream();
            bis=new BufferedInputStream(new FileInputStream("hello.txt"));
            byte[] buff=new byte[20];
            int len;
            while ((len=bis.read(buff))!=-1){
                os.write(buff, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
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
            while ((len=in.read(buff))!=-1){
                bos.write(buff, 0, len);
            }
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
