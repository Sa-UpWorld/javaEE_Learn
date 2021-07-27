/*
 * FileName: Person
 * Author:   Lenovo
 * Date:     2021/7/23 22:07
 * Description: 序列化Person对象
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.boot.day_10;

import java.io.Serializable;

/**
 * @author Lenovo
 *      对象的序列化必须实现Serializable或Externalizable接口
 *      当前类提供了一个serialVersionUID常量用于版本标识
 *      除当前配置类实现Serializable接口外，其内部属性也必须可以序列化
 *      static或transient修饰的成员变量不能序列化
 */
public class Person implements Serializable {

    /**
     *  用于表示序列化及反序列化的版本信息，反序列化时会进行对比，反序列化，判断版本一致性，一致才允许反序列化
     */
    private static final long serialVersionUID = 1L;

    private String name;
    private Integer age;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public void show(){
        System.out.println("你好，我是"+name+" 今年"+age+"岁");
    }
}
