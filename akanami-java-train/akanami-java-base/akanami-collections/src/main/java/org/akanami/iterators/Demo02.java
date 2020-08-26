package org.akanami.iterators;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/*
    使用 Iterator 迭代器遍历Map
 */
public class Demo02 {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("hello1", "hello world 1");
        map.put("hello2", "hello world 2");
        map.put("hello2", "hello world 3");

        System.out.println("通过Map.KeySet遍历Key和Value");
        for (String key : map.keySet()) {
            System.out.println("key=" + key + " value=" + map.get(key));
        }

        System.out.println("通过Map.entrySet使用iterator遍历key和value：");
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while(iterator.hasNext()) {
            Map.Entry<String, String> next = iterator.next();
            System.out.println("key=" + next.getKey() + " value=" + next.getValue());
        }

        //第三种：推荐，尤其是容量大时
        System.out.println("通过Map.entrySet遍历key和value");
        for (Map.Entry<String, String> entryItem : map.entrySet()) {
            System.out.println("key=" + entryItem.getKey() + " value=" + entryItem.getValue());
        }

        //第四种
        System.out.println("通过Map.values()遍历所有的value，但不能遍历key");
        for (String value : map.values()) {
            System.out.println("value=" + value);
        }
    }
}
