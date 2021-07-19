/*
 * FileName: NewThread
 * Author:   Lenovo
 * Date:     2021/7/17 9:15
 * Description: 新的多线程实现方法
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.boot.root.day_2;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

//1、创建实现Callable接口的实现类
class NumThread implements Callable{

    //2、实现Call方法,执行逻辑操作
    @Override
    public Object call() throws Exception {
        int sum=0;
        for(int i=1;i<=100;i++){
            if(i%2==0){
                System.out.println(Thread.currentThread().getName()+i);
                sum+=i;
            }
        }
        return sum;
    }
}

public class NewThread  {

    public static void main(String[] args) {
        //3、创建Callable接口实现类的对象
        NumThread num=new NumThread();
        //4、将Callable的实现类对象作为参数传递到FutureTask构造器
        FutureTask task=new FutureTask(num);    //唤醒线程的call方法
        //5、通过Thread的start方法使FutureTask中的线程的call方法执行
        new Thread(task).start();
        //6、获取线程执行结果
        try {
            //get()返回值即为futureTask构造器参数Callable实现类的重写的call方法的返回值
            Object sum=task.get();
            System.out.println(sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
