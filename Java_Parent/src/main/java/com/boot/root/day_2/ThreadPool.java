/*
 * FileName: ThreadPool
 * Author:   Lenovo
 * Date:     2021/7/17 9:44
 * Description: 使用线程池创建多线程
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.boot.root.day_2;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

class MyPool implements Callable{

    @Override
    public Object call() throws Exception {
        for(int i=0;i<=100;i++){
            if(i%2==0){
                System.out.println(i);
            }
        }
        return  null;
    }
}

public class ThreadPool {

    public static void main(String[] args) {
        //1、提供指定线程数量线程池
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        //2、创建具体线程
        MyPool myPool = new MyPool();
        //3、通过FutureTask类封装Callable类型线程
        FutureTask task=new FutureTask(myPool);
//        executorService.submit();//适合适用于Callable
        //4、执行线程
        executorService.execute(task);//使用适用于Runable
        //执行之后关闭连接池
        executorService.shutdown();
    }
}
