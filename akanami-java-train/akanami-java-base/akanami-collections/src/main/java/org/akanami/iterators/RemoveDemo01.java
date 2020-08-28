package org.akanami.iterators;

import java.util.ArrayList;
import java.util.Iterator;

/*
    本例是演示 Iterator的 Remove 方法
    Iterator 在删除第一个元素的时候，必须先调用 next() 方法跳过第一个元素，才能执行删除
 */
public class RemoveDemo01 {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("hello");
        arrayList.add("world");
        arrayList.add("my");
        arrayList.add("friend");

        System.out.println(arrayList);

        Iterator<String> iterator = arrayList.iterator();
        //iterator.remove();    //直接执行会抛出  java.lang.IllegalStateException  异常

        iterator.next();
        iterator.remove();

        System.out.println(arrayList);
    }
}
