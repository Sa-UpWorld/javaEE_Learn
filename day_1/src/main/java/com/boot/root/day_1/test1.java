/*
 * FileName: test1
 * Author:   Lenovo
 * Date:     2021/7/16 17:35
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.boot.root.day_1;

class MyNum implements Runnable{

    private int num=1;
    @Override
    public void run() {
        while (true) {
            synchronized (this) {

                notify();

                if (num <= 100) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "" + num);
                    num++;
                    try {
                        //使得线程阻塞
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    break;
                }
            }
        }
    }
}

public class test1 {
    public static void main(String[] args) {
        MyNum num=new MyNum();
        Thread t1=new Thread(num);
        Thread t2=new Thread(num);
        t1.setName("线程1 ");
        t2.setName("线程2 ");

        t1.start();
        t2.start();

    }
}
