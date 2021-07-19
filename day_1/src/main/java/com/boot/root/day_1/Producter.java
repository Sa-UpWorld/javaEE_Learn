/*
 * FileName: Producter
 * Author:   Lenovo
 * Date:     2021/7/16 19:01
 * Description: 生产者/消费者问题
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.boot.root.day_1;

/**
 * 生产者/消费者问题——>生产者线程，消费者线程，共享产品
 */

/**
 * 产品
 */
class Clerk{

    private int product=0;

    //生产产品
    public synchronized void produce() {
        synchronized (this){
            if(product<20){
                product++;
                System.out.println(Thread.currentThread().getName() + " 开始生产第"+product+"个产品了!");
                notify();
            }else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //消费产品
    public synchronized void cosume() {
        if(product>0){
            System.out.println(Thread.currentThread().getName() + " 开始消费第"+product+"个产品了!");
            product--;
            notify();
        }else {
            //等待
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

/**
 * 生产者
 */
class Producer implements Runnable{

    private Clerk clerk;

    public Producer(Clerk clerk){
        this.clerk=clerk;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" 开始生产产品");
        while (true){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.produce();
        }
    }
}

/**
 * 消费者
 */
class Cosumer implements Runnable {

    private Clerk clerk;

    public Cosumer(Clerk clerk){
        this.clerk=clerk;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" 开始消费产品");
        while (true){
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.cosume();
        }
    }
}

public class Producter {
    public static void main(String[] args) {
        Clerk c=new Clerk();
        Thread t1=new Thread(new Producer(c));
        t1.setName("生产者");

        Thread t2=new Thread(new Cosumer(c));
        t2.setName("消费者");

        t1.start();
        t2.start();
    }
}
