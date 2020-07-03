package org.akanami.lambda;

import java.awt.*;
import java.util.ArrayList;

public class Lambda01 {
    interface MatchPredicate {
        boolean match(Person p);
    }

    class Person {
        int age;

        public Person(int aAge) {
            this.age = aAge;
        }

        public int getAge() {
            return this.age;
        }

        @Override
        public String toString() {
            return Integer.valueOf(this.age).toString();
        }
    }

    public void test() {
        ArrayList<Person> list = new ArrayList<>();
        list.add(new Person(1));
        list.add(new Person(5));
        list.add(new Person(10));
        list.add(new Person(15));
        list.add(new Person(20));

        ArrayList<Person> filterResult = this.filter(list, (p) -> p.age > 10);

        for (Person p : filterResult) {
            System.out.println(p);
        }
    }

    public ArrayList<Person> filter(ArrayList<Person> list, MatchPredicate predicate) {
        ArrayList<Person> result = new ArrayList<>();

        for (Person p: list) {
            if(predicate.match(p)) {
                result.add(p);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Lambda01 demo = new Lambda01();
        demo.test();
    }
}
