/*
 * FileName: GenericterTest
 * Author:   Lenovo
 * Date:     2021/7/22 10:32
 * Description: 泛型类及接口测试
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

import com.boot.day_5.DAO;
import org.junit.Test;

/**
 * @author Lenovo
 *      泛型——JDK5新增特性
 */
public class GenericterTest {

    @Test
    public void test(){
        DAO<Integer> dao=new DAO<>();
        dao.save("1",123);
        dao.save("2",456);
        dao.save("3",789);
        System.out.println(dao.list());
        System.out.println(dao.get("2"));
        dao.delete("3");
        System.out.println(dao.list());
        dao.update("3",10);
        System.out.println(dao.list());
    }
}
