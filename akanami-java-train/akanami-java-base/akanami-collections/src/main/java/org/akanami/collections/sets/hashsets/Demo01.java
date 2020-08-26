package org.akanami.collections.sets.hashsets;

import java.util.HashSet;
import java.util.Iterator;

/*
    HashSet
        底层数据结构采用哈希表实现
        元素无序且唯一，线程不安全，效率高，可存储null元素，
        元素的唯一性是靠所存储元素类型是否重写hashCode()和equals()方法来保证的，如果没有重写这两个方法，则无法保证元素的唯一性。
 */
public class Demo01 {
    public static void main(String[] args) {
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("hello");
        hashSet.add("hello");
        hashSet.add("hello");

        hashSet.add("world");

        Iterator<String> iterator = hashSet.iterator();
        while(iterator.hasNext()) {
            System.out.println("value ==> " + iterator.next());
        }
    }
}
