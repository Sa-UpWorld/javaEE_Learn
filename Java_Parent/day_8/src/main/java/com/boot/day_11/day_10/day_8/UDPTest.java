/*
 * FileName: UDPTest
 * Author:   Lenovo
 * Date:     2021/7/24 14:23
 * Description: UDP网络测试
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.boot.day_11.day_10.day_8;

import org.junit.Test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * @author Lenovo
 */
public class UDPTest {

    /**
     * UDP发送端
     */
    @Test
    public void send(){
        //创建Socket套接字
        DatagramSocket socket = null;
        //创建封装数据的数据包
        DatagramPacket packet = null;
        try {
            socket=new DatagramSocket();
            //要送的数据封装到数据包
            String str="你好,我是UDP客户端";
            byte[] data=str.getBytes();
            packet = new DatagramPacket(data,0,data.length, InetAddress.getByName("127.0.0.1"),8899);
            //通过套接字发送数据
            socket.send(packet);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try{
                if (socket != null) {
                    socket.close();
                }
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * UDP接收端
     */
    @Test
    public void receive(){
        //创建DatagramSocket套接字
        DatagramSocket socket=null;
        //创建封装的数据包
        DatagramPacket packet=null;
        try {
            socket = new DatagramSocket(8899);
            //读取数据封装到数据包
            byte[] buff=new byte[100];
            packet=new DatagramPacket(buff,0,buff.length);
            socket.receive(packet);
            System.out.println(new String(packet.getData(),0,packet.getLength()));
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try{
                if (socket != null) {
                    socket.close();
                }
            }catch (Exception e) {

            }
        }
    }
}
