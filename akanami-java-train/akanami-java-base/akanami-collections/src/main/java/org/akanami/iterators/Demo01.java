package org.akanami.iterators;

import java.util.*;

/*
    使用 Iterator 迭代器 遍历 List ArrayList
 */
public class Demo01 {
    public static void main(String[] args) {
        List<String> arr = new ArrayList<>();
        arr.add("hello");
        arr.add("world");

        Iterator<String> iterator = arr.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
