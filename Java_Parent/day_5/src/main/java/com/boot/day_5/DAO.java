/*
 * FileName: DAO
 * Author:   Lenovo
 * Date:     2021/7/22 15:13
 * Description: DAO泛型类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.boot.day_5;

import java.util.*;

/**
 * @author Lenovo
 * 定义泛型类DAO<T>，在其中定义Map成员变量，Map的键为String类型，值为T类型
 * 分别创建以下方法：
 *      save
 *      T get
 *      update
 *      List<T> list()
 *      delete
 */
public class DAO<T> {

    private Map<String,T> map=new HashMap<>();

    public void save(String id,T entry){
        map.put(id,entry);
    }

    public T get (String id){
        return map.get(id);
    }

    public void update(String id,T entry){
        if(map.containsKey(id)){
            map.put(id,entry);
        }
    }

    public List<T> list(){
        List<T> list=new ArrayList<>();
        Set<Map.Entry<String, T>> entries = map.entrySet();
        Iterator<Map.Entry<String, T>> iterator = entries.iterator();
        while (iterator.hasNext()){
            list.add(iterator.next().getValue());
        }
        return list;
    }

    public void delete(String id){
        map.remove(id);
    }

    public Map<String, T> getMap() {
        return map;
    }

    public void setMap(Map<String, T> map) {
        this.map = map;
    }

    public DAO() {
    }

    public DAO(Map<String, T> map) {
        this.map = map;
    }

    @Override
    public String toString() {
        return "DAO{" +
                "map=" + map +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DAO<?> dao = (DAO<?>) o;
        return Objects.equals(map, dao.map);
    }

    @Override
    public int hashCode() {
        return Objects.hash(map);
    }
}
