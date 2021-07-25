/*
 * FileName: InternetAddressTest
 * Author:   Lenovo
 * Date:     2021/7/24 9:34
 * Description: 网络编程
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.boot.day_10.day_8;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author Lenovo
 *
 * 网络编程中的两个问题：
 *      定位远程主机及其上的特定应用
 *      如何可靠高效传输数据
 * 网络编程两要素：
 *      IP和端口号
 *      网络通信协议——TCP/IP
 *
 *      IP用来唯一标识互联网上的主机
 *          Java中使用InternetAddress类代表IP
 *          IP分类：IPv4、IPv6——广域网、局域网
 *          域名：www.baidu.com
 *      本地的回路地址——127.0.0.1——localhost:8080\\
 *   如何实例化InetAddress
 *      getByName()——静态
 *      getLocalHost()——静态
 *      getHostName()——静态，获取本机名
 *      getHostAddress()——静态，获取本机地址
 *   端口号：区分不同应用进程端口号和IP结合组成网络套接字：Scoket
 */
public class InternetAddressTest {

  public static void main(String[] args) {
      try {
          //InetAddress对象对用一个IP
          InetAddress byName = InetAddress.getByName("192.168.1.107");
          InetAddress byName1 = InetAddress.getByName("www.baidu.com");
          InetAddress localHost = InetAddress.getLocalHost();
          System.out.println(byName);
          System.out.println(byName1);
          System.out.println(localHost);
      } catch (UnknownHostException e) {
          e.printStackTrace();
      }
  }

    /**
     * 客户端
     *      1.创建套接字
     *      2.获取输出流
     *      3.写入数据
     *      4.资源关闭
     */
    @Test
    public void test(){
        //创建IP类InetAddress
        InetAddress iner= null;
        Socket socket =null;
        OutputStream os=null;
        try {
            iner = InetAddress.getByName("127.0.0.1");
            socket = new Socket(iner,8899);
            os=socket.getOutputStream();
            os.write("你好,我是客户端".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(os!=null){
                    os.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if(socket!=null){
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 服务端
     *      1.创建套接字
     *      2.获取输入流
     *      3.读取数据
     *      4.关闭资源
     */
    @Test
    public void test1(){
        //创建服务端套接字
        ServerSocket ss=null;
        Socket accept =null;
        InputStream is =null;
        ByteArrayOutputStream bos=null;
        try {
            ss=new ServerSocket(8899);
            accept=ss.accept();
            is = accept.getInputStream();
            bos=new ByteArrayOutputStream();
            byte[] buff=new byte[5];
            int len;
            while ((len=is.read(buff))!=-1){
                bos.write(buff, 0, len);
            }
            System.out.println(bos.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {

            try {
                if(is!=null){
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if(accept!=null){
                    accept.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if(ss!=null){
                    ss.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
