/*
 * FileName: ReflectionTest
 * Author:   Lenovo
 * Date:     2021/7/24 16:04
 * Description: 反射练习
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.boot.day_9;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @author Lenovo
 */
public class ReflectionTest {

    /**
     * 反射之前对于Person类的操作
     */
    @Test
    public void test(){
        //创建Person类对象
        Person person=new Person("李晶",24);
        //通过对象调用内部属性和方法
        person.show();
    }

    /**
     * 反射后的操作方法
     */
    @Test
    public void test1(){
        Class clazz=Person.class;
        try {
            //通过反射创建Person类的对象
            Constructor c=clazz.getConstructor(String.class,Integer.class);
            Object obj = c.newInstance("李晶", 23);
            System.out.println((Person)obj);
            //通过反射，调用指定对象的属性和方法
            Method show = clazz.getDeclaredMethod("show");
            show.invoke((Person)obj);
            //通过反射，可以调用私有资源
            //调用私有构造器
            Constructor declaredConstructor = clazz.getDeclaredConstructor(String.class);
            declaredConstructor.setAccessible(true);
            Object obj1 = declaredConstructor.newInstance("玉凤");
            show.invoke((Person)obj1);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
    /**
     * new和反射都可以调用公共结构
     *      建议直接new，但在以下情况推荐用反射
     *          编译前不确定造哪个类对象
     */

    /**
     * 获取Class实例的方式
     */
    @Test
    public void test2(){
        //方式1.反射
        Class clazz=Person.class;
        //方式2,.new对象
        //方式3.调用Class静态方法：forName(String classpath)
        Class clazz1=null;
        try {
            clazz1=Class.forName("com.boot.day_9.Person");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        // 方式4.使用类加载器
        ClassLoader clazzLoader=ReflectionTest.class.getClassLoader();
        Class clazz2=null;
        try {
            clazz2=clazzLoader.loadClass("com.boot.day_9.Person");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(clazz+" "+clazz1+" "+clazz2);
    }

    @Test
    public void test3(){
        //对于自定义类，使用系统类加载器进行加载
        ClassLoader clazzLoader=ReflectionTest.class.getClassLoader();
        System.out.println(clazzLoader);
        //调用系统类加载器的getParent()方法：获取扩展类加载器
        ClassLoader parent = clazzLoader.getParent();
        System.out.println(parent);
        //调用扩展类加载器的getParent()方法：无法获取引导类加载器
        //主要负责加载java核心类库，无法加载自定义类
        ClassLoader parent1 = parent.getParent();
        System.out.println(parent1);
    }

    /**
     * Properties：用来读取配置文件
     */
    @Test
    public void test4() {
        //读取配置文件方式1
        Properties pros=new Properties();
        FileInputStream fis=null;
        try {
            fis=new FileInputStream("db.properties");
            pros.load(fis);
            String username=pros.getProperty("prop.username");
            String password = pros.getProperty("prop.password");
            System.out.println(username+" "+password);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * Properties：用来读取配置文件
     */
    @Test
    public void test5() {
        //读取配置文件方式2
        Properties pros=new Properties();
        ClassLoader classLoader=ReflectionTest.class.getClassLoader();
        //默认从src下找对应文件
        InputStream is = classLoader.getResourceAsStream("db.properties");
        try {
            pros.load(is);
            String username=pros.getProperty("prop.username");
            String password = pros.getProperty("prop.password");
            System.out.println(username+" "+password);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
