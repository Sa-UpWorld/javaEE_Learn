/*
 * FileName: OptionalTest
 * Author:   Lenovo
 * Date:     2021/7/26 22:03
 * Description: Optional新方法
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.boot.day_12;

/**
 * @author Lenovo
 *      Optional新方法
 *          boolean isEmpty()——>判断value是否为空
 *          ifPresentOrElse(Consumer<? super T> action,Runnable emptyAction)——>value非空，执行参数1功能，为空，执行参数2功能
 *          Optional<T> or(Supplier<? extends Optional<? extends >>)——>value非空，返回对于Optional；为空，返回形参封装的Optional
 *          Stream<T> stream()——>value非空，返回仅包含此value的Stream；否则，返回一个空stream
 *          T orElseThrow()——>value非空，返回value；否则抛异常NoSuchElementException
 *
 */
public class OptionalTest {

}
