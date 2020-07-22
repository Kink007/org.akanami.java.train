package org.akanami.chapter13;

import org.junit.Assert;
import org.junit.Test;

public class StringTest5 {

    @Test
    public void test1() {
        String s1 = "a" + "b" + "c";    //都是常量的拼接，编译器直接优化了
        String s2 = "abc";  //放在字符串常量池中

        System.out.println(s1 == s2);   // true
        System.out.println(s1.equals(s2)); // true
    }

    @Test
    public void test2() {
        String s1 = "javaEE";
        String s2 = "hadoop";

        String s3 = "javaEEhadoop";
        String s4 = "javaEE" + "hadoop";

        //如果拼接符号的前后出现了变量，则相当于在堆空间中new String()，具体的内容为拼接的结果。
        String s5 = s1 + "hadoop";
        String s6 = "javaEE" + s2;
        String s7 = s1 + s2;

        System.out.println(s3 == s4);   //true
        System.out.println(s3 == s5);   //false
        System.out.println(s3 == s6);   //false
        System.out.println(s3 == s7);   //false
        System.out.println(s5 == s6);   //false
        System.out.println(s5 == s7);   //false
        System.out.println(s6 == s7);   //false

        String s8 = s6.intern();
        System.out.println(s3 == s8);   //true
    }

    @Test
    public void test6() {
        String s1 = "";
        s1 = s1 + "a";

        StringBuilder sb = new StringBuilder();
        sb.append("a");

        //使用append方法效率远远大于 字节串拼接，因为字符串拼接的内部实现是创建StringBuilder 调用append toString的时候再new String对象
    }

    @Test
    public void question01() {
        String s = new String("1");
        s.intern();

        String s2 = "1";
        System.out.println(s == s2);

        String s3 = new String("1") + new String("1");
        s3.intern();
        String s4 = "11";
        System.out.println(s3 == s4);
    }
}
