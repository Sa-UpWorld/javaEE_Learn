/*
 * FileName: ObjectStreamTest
 * Author:   Lenovo
 * Date:     2021/7/23 21:56
 * Description: 对象流测试
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.boot.day_8;

import org.junit.Test;

import java.io.*;

/**
 * @author Lenovo
 *      对象流的使用
 *      ObjectInputStream、ObjectOutputStream
 *      作用：用于存储和读取基本数据类型数据或对象的处理流，他可以把java中的对象序列化
 */
public class ObjectStreamTest {

    /**
     * 序列化：将内存中的java对象保存到磁盘或通过网络传输
     */
    @Test
    public  void test(){
        //创建对象流
        ObjectOutputStream oos=null;
        try {
            oos=new ObjectOutputStream(new FileOutputStream("object.bat"));
            oos.writeObject(new String("李晶 23 西南交通大学"));
            //刷新
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {

            try {
                if(oos!=null){
                    oos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 反序列化过程——>磁盘文件中的对象还原为内存中的java对象
     *      使用ObjectInputStream进行反序列化
     */
    @Test
    public void test1(){
        //创建对象读入流
        ObjectInputStream ois = null;
        try {
            ois=new ObjectInputStream(new FileInputStream("object.bat"));
            Object o = ois.readObject();
            System.out.println((String) o);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }finally{
            try {
                if(ois!=null){
                    ois.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 序列化并反序列化对象
     */
    @Test
    public void test2(){
        //创建对象流
        ObjectOutputStream oos=null;
        try {
            oos=new ObjectOutputStream(new FileOutputStream("person.bat"));
            oos.writeObject(new Person("李晶",23));
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(oos!=null){
                    oos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 序列化并反序列化对象
     */
    @Test
    public void test3(){
        //创建对象流
        ObjectInputStream oos=null;
        try {
            oos=new ObjectInputStream(new FileInputStream("person.bat"));
            Object o = oos.readObject();
            System.out.println((Person)o);
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(oos!=null){
                    oos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
