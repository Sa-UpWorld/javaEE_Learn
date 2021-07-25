/*
 * FileName: URLTest
 * Author:   Lenovo
 * Date:     2021/7/24 14:46
 * Description: URL编程测试
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.boot.day_10.day_8;

import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author Lenovo
 *  1.URL:统一资源定位符，对应互联网上某一资源地址
 *  2.格式：传输协议+主机名+端口号+文件名+片段名+参数列表
 */
public class URLTest {

    @Test
    public void test(){
        //拿到URL镀锡
        URL url =null;
        try {
            url = new URL("http://localhost:8080/");
            url.getProtocol();
            url.getHost();
            url.getPath();
            url.getFile();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test1() {

    }
}
