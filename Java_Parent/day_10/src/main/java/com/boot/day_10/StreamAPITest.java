/*
 * FileName: StreamAPITest
 * Author:   Lenovo
 * Date:     2021/7/25 21:01
 * Description: Stream API测试
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.boot.day_10;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author Lenovo
 *      1.Stream关注的是对数据的运算，与CPU打交道
 *      集合关注的是数据存储，与内存dajiaod
 *      2.Stream 自己不会存储元素
 *               不变改变源数据，相反，它们会返回一个持有结果的新Stream
 *               操作时延迟执行的，即需要结果才执行
 *      3.Stream API执行流程——新建、中间操作（过滤、映射等）、终止
 */
public class StreamAPITest {

    /**
     * 方式1：集合创建Stream
     */
    @Test
    public void test(){
        List<String> str= Arrays.asList("123","456","789");
        //实例化Stream，返回一个顺序流
        Stream<String> stream = str.stream();
        //实例化Stream，返回一个并行流
        Stream<String> stringStream = str.parallelStream();
    }

    /**
     * 方式2：数组创建Stream
     */
    @Test
    public void test1(){
        String[] str= {"123","456","789"};
        //通过调用Arrays类的static <T> Stream<T> stream(T[] array):返回一个流
        Stream<String> stream = Arrays.stream(str);
    }

    /**
     * 方式3：通过Stream的of()
     */
    @Test
    public void test2(){
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4);

    }

    /**
     * 方式4.创建无限流
     */
    @Test
    public void test3(){
        /** 迭代 public static<T> Stream<T> iterate(final T seed,final UnaryOperator<T> f) 例如：遍历前10个偶数 */
        Stream.iterate(0, t -> t + 2).limit(10).forEach(System.out::println);
        /** 生成 public static<T> Stream<T> generate(Supplier<T> s) */
        Stream.generate(Math::random).limit(10).forEach(System.out::println);
    }

    /**
     * 筛选与切片
     *      filter(Predicate p)——>接收lambda，从流中排除某些元素
     *      limit(n)——>截断流，使其元素不超过给定数量
     *      skip(n)——>跳过元素，返回一个扔掉了前n个元素的流，不足时返回null
     *      distinct()——>筛选，通过流所生成元素的hashCode()和equals()去除重复元素
     */
    @Test
    public void test4(){
        List<Integer> list=Arrays.asList(3000,4000,2000,6000,7000,6000,7000);
        Stream<Integer> stream = list.stream();
        System.out.println("筛选大于3000的数:");
        //筛选大于3000的工资
        stream.filter(t -> t > 3000).forEach(System.out::println);
        //截断流
        Stream<Integer> stream1 = list.stream();
        System.out.println("只输出前三个数:");
        stream1.limit(3).forEach(System.out::println);
        //跳表
        Stream<Integer> stream2 = list.stream();
        System.out.println("跳过前3个数输出:");
        stream2.skip(3).forEach(System.out::println);
        //去重
        Stream<Integer> stream3 = list.stream();
        System.out.println("去重:");
        stream3.distinct().forEach(System.out::println);
    }

    /**
     * 映射
     *      map(Function f) 接收函数作为参数，该函数被应用到每个元素，并将其映射为一个新元素
     *      mapToDouble(ToDoubleFunction f) 接收一个函数作为参数，该函数被应用到每个元素上，产生一个新的Double Stream
     *      mapToInt(ToIntFunction f) 接收一个函数作为参数，该函数被应用到每个元素，产生一个新的IntStream
     *      mapToLong(ToLongFunction f) 接收一个函数作为参数，该函数会被应用到每个元素上，产生一个新的LongStream
     *      flatMap(Function f) 接收一个函数作为参数，将流中的每个值换乘另一个流，然后把所有流连接成一个流
     */
    @Test
    public void test5(){
        //map()
        List<String> list = Arrays.asList("aa", "bb", "cc", "dd");
        list.stream().map(s -> s.toUpperCase()).forEach(System.out::println);
        //练习2
        Stream<Stream<Character>> streamStream = list.stream().map(e -> StringToStream(e));
        streamStream.forEach(s -> {s.forEach(System.out::println);});
        /**
         * flatMap() 将流中的每个值都换乘另一个流，最后将所有的流转换为一个流
         */
        Stream<Character> characterStream = list.stream().flatMap(str -> StringToStream(str));
        characterStream.forEach(System.out::println);
    }

    public Stream<Character> StringToStream(String str){
        ArrayList<Character> list = new ArrayList<>();
        for (char c : str.toCharArray()) {
            list.add(c);
        }
        return list.stream();
    }

    /**
     * 排序：
     *      sorted()——>产生一个新流,按自然排序排序
     *      sorted(Comparator com)——>产生一个新流，按比较顺序排序
     */
    @Test
    public void test6(){
        /**
         * 自然排序
         */
        List<String> list = Arrays.asList("aa","ee","vv", "bb", "cc", "dd");
        System.out.println("自然排序:");
        Stream<String> sorted = list.stream().sorted();
        sorted.forEach(System.out::println);
        /** 按比较器排序 */
        System.out.println("比较排序:");
        Stream<String> sorted1 = list.stream().sorted((o1,o2)->-o1.compareTo(o2));
        sorted1.forEach(System.out::println);
    }
}
