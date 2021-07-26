/*
 * FileName: day_10
 * Author:   Lenovo
 * Date:     2021/7/25 11:57
 * Description: 静态及动态代理测试
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.boot.day_11.day_10;

interface ClothFactory{
    /**
     * 衣服生产方法
     */
    void produceCloth();
}

/**
 * 代理类
 */
class ProxyClothFactory implements ClothFactory{

    /**
     * 用被代理对象进行实例化
     */
    private ClothFactory factory;

    public ProxyClothFactory(ClothFactory factory){
        this.factory=factory;
    }

    @Override
    public void produceCloth() {
        System.out.println("代理工厂准备生产衣服了!");
        factory.produceCloth();
        System.out.println("衣服生产完了!");
    }
}

/**
 * 被代理类
 */
class HxerProxyFactory implements ClothFactory {

    @Override
    public void produceCloth() {
        System.out.println("鸿星尔克最近卖疯了!");
    }
}

/**
 * @author Lenovo
 * 静态代理
 */
public class ProxyTest {

  public static void main(String[] args) {
      //创建被代理类
      HxerProxyFactory hxerProxyFactory=new HxerProxyFactory();
      //创建代理类
      ProxyClothFactory proxyClothFactory = new ProxyClothFactory(hxerProxyFactory);
      proxyClothFactory.produceCloth();
  }
}
