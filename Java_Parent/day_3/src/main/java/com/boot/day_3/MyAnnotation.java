/*
 * FileName: MyAnnotation
 * Author:   Lenovo
 * Date:     2021/7/20 14:38
 * Description: 自定义注解
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.boot.day_3;

/**
 * 自定义注解,以@Annotation声明
 * @author Lenovo
 */
public @interface MyAnnotation {

    String value() default "hello";
}
