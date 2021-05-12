package org.akanami.collections.list;

import java.util.Arrays;
import java.util.List;

public class Demo01 {
    public static void main(String[] args) {
        int[] myArr = {1,2,3};
        List ints = Arrays.asList(myArr);
        System.out.println(ints.size());
        System.out.println(ints.get(0));
        System.out.println(ints.get(1));
    }
}
