package org.akanami.base;

/**
 * 方法传递引用类型的副本
 * 不是直接传递引用类型？？？
 *
 * 结论
 * 一个方法不能修改一个基本数据类型的参数（即数值型或布尔型）。
 * 一个方法可以改变一个对象参数的状态。
 * 一个方法不能让对象参数引用一个新的对象。
 */
public class SwapDemo {
    public static void main(String[] args) {
        Student s1 = new Student("s1");
        Student s2 = new Student("s2");

        swap(s1, s2);

        System.out.println(s1);
        System.out.println(s2);
    }

    static void swap(Student s1, Student s2) {

        s1.setName("s1_hello");
        s2.setName("s2_hello");

        Student tmp = s1;
        s1 = s2;
        s2 = tmp;

        System.out.println("swap s1:" + s1);
        System.out.println("swap s2:" + s2);
    }

    static class Student {
        private String name;

        public Student(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

}
