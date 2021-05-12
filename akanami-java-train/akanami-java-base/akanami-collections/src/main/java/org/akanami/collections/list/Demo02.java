package org.akanami.collections.list;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Demo02 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);

        List<Integer> collect = list.stream().filter(t -> t > 1).collect(Collectors.toList());

        for (Integer integer : collect) {
            System.out.println(integer);
        }
    }
}
