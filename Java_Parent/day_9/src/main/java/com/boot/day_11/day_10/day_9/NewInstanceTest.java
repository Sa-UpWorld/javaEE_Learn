/*
 * FileName: NewInstanceTest
 * Author:   Lenovo
 * Date:     2021/7/24 18:11
 * Description: 创建运行时类对象
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.boot.day_11.day_10.day_9;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;

/**
 * @author Lenovo
 *      通过反射创建对应的运行时类的对象
 */
public class NewInstanceTest {

    @Test
    public void test(){

        Class clazz=Person.class;

        try {
            /**
             * 调用此方法创建运行时类的对象
             *      此方法正常的创建运行时类的对象，要求：
             *          1.运行时类必须提供空参构造器
             *          2.空参构造器的访问权限必须为public
             *          3.javaBean中要求提供一个public空参构造器
             *              便于通过反射，创建运行时类的对象
             *              便于子类继承此运行时类时，默认调用super()时，保证父类由此构造器
             */
            Object o = clazz.newInstance();
            Person person=(Person)o;
            person.setAge(23);
            person.setName("李晶");
            person.show();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test1(){
        Class clazz = Person.class;
        //获取属性结构
        //getFields():获取当前运行时类及其父类中声明为public访问权限的属性
        Field[] fields = clazz.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }

        /**
         * getDeclaredFields():获取当前运行时类中声明的所有属性（不包含父类中声明的属性）
         */
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            //1.权限修饰符
            int modifiers = declaredField.getModifiers();
            //数据类型
            Class<?> type = declaredField.getType();
            //变量名
            String name = declaredField.getName();
            System.out.println(declaredField+" "+type+" "+" "+name+modifiers);
        }
    }

    /**
     * 权限修饰符   返回值类型   方法名（参数类型1, 形参名，……）
     */
    @Test
    public void test2(){
        Class clazz=Person.class;
        Method[] methods = clazz.getMethods();
        System.out.println("方式1");
        for (Method method : methods) {
            System.out.println(method);
        }
        System.out.println("方式2");
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod);
          // 权限修饰符
          System.out.println(Modifier.toString(declaredMethod.getModifiers()));
          // 返回值类型
          System.out.println(declaredMethod.getReturnType());
          // 方法名
          System.out.println(declaredMethod.getName());
          //形参列表
          Class<?>[] parameterTypes = declaredMethod.getParameterTypes();
          for (Class<?> parameterType : parameterTypes) {
                System.out.println(parameterType);
          }
        }
    }

    /**
     * 获取运行时类的带泛型的父类的泛型
     */
    @Test
    public void test3(){
        Class clazz=Person.class;
        //获取父类泛型
        Type genericSuperclass = clazz.getGenericSuperclass();
        ParameterizedType parameterizedType=(ParameterizedType)genericSuperclass;
        System.out.println(2);
        //获取泛型类型
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        System.out.println(((Class)actualTypeArguments[0]).getName());
    }

    /**
     * 获取运行时类实现的接口
     */
    @Test
    public void test4(){
        Class clazz = Person.class;
        Class[] interfaces = clazz.getInterfaces();
        for (Class anInterface : interfaces) {
            System.out.println(anInterface);
        }

        /**
         * 获取运行时类的父类的接口
         */
        Class[] interfaces1 = clazz.getSuperclass().getInterfaces();
        for (Class aClass : interfaces1) {
          System.out.println(aClass);
        }
    }

    /**
     * 获取运行时类声明的注解
     */
    @Test
    public void test5(){
        Class clazz=Person.class;
        Package aPackage = clazz.getPackage();
        System.out.println(aPackage);
    }

    /**
     * 获取运行时类的声明注解
     */
    @Test
    public void test6(){
        Class clazz=Person.class;
        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }
    }

    /**
     * 调用运行时类中指定的结构——>属性、方法、构造器
     */

    @Test
    public void test7(){
        //创建运行时类
        Class clazz=Person.class;
        //获取指定的属性
        try {
            //创建运行时类的对象
            Person o = (Person) clazz.newInstance();
            //获取运行时类指定属性
            Field name = clazz.getDeclaredField("name");
            //保证当前属性可访问
            name.setAccessible(true);
            //设置值
            name.set(o,"李晶");
            o.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void test8(){
        Class clazz = Person.class;
        //创建运行时类的对象
        try {
            //获取运行时类的实例
            Person o = (Person) clazz.newInstance();
            //获取指定方法
            Method getName = clazz.getDeclaredMethod("getName");
            getName.setAccessible(true);
            o.setName("李晶");
            Object invoke = getName.invoke(o);
            System.out.println(invoke.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 调用运行时指定类构造器
     */
    @Test
    public void test9(){
        //获取运行时类
        Class clazz=Person.class;
        try {
            //获取指定运行时类构造器
            Constructor declaredConstructor = clazz.getDeclaredConstructor(String.class);
            //保证此构造器可访问
            declaredConstructor.setAccessible(true);
            Person o1 = (Person) declaredConstructor.newInstance("李晶");
            System.out.println(o1);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }catch (NoSuchMethodException e) {
            e.printStackTrace();
        }catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
