/*
 * FileName: DayProxyTest
 * Author:   Lenovo
 * Date:     2021/7/25 15:12
 * Description: 动态代理
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.boot.day_10;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface Human{
    /**
     * 获取信息
     * @return
     */
    public String getBelief();

    /**
     * 吃什么
     * @param food
     */
    public void eat(String food);


}

/**
 * 被代理类
 */
class SuperMan implements Human {

    @Override
    public String getBelief() {
        return "中国第一!";
    }

    @Override
    public void eat(String food) {
        System.out.println("中国人吃"+food);
    }
}

class MyInvotationHandler implements InvocationHandler {

    /**
     * 当我们通过代理对象调用方法a时，就会自动调用如下方法：invoke()
     *      将被代理类要执行的方法a的功能声明在invoke（）中
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    /**
     * 需要使用被代理类对象进行赋值
     */
    private Object obj;

    public void bind(Object obj){
        this.obj=obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //代理类对象调用的方法，此方法也作为被代理类调用的方法
        Object invoke = method.invoke(obj, args);
        //代理类对象的返回值
        return invoke;
    }
}

/**
 * 代理工厂——返回代理类
 */
class ProxyFactory{
    /**
     * @param obj——被代理类对象
     * @return——代理类对象
     */
    public static Object getProxyInstance(Object obj){
        MyInvotationHandler myInvotationHandler=new MyInvotationHandler();
        myInvotationHandler.bind(obj);
            return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(),myInvotationHandler);
    }
}

/**
 * @author Lenovo
 *      动态代理举例
 *      要想实现动态代理
 *          根据加载到内存中的被代理类，动态创建一个代理类及其对象
 *          当通过代理类对象调用方法时，动态调用被代理类同名方法
 */
public class DayProxyTest {
      public static void main(String[] args) {
            SuperMan superMan=new SuperMan();
            //proxyInstance：代理类对象
            Human proxyInstance = (Human) ProxyFactory.getProxyInstance(superMan);
            proxyInstance.eat("麻辣烫!");
      }
}
