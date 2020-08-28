package org.akanami.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Demo01 {
    public static void main(String[] args) {
        ArrayList<Person> personList = new ArrayList<>();
        personList.add(new Person("张", "三"));
        personList.add(new Person("张", "四"));
        personList.add(new Person("王", "六"));
        personList.add(new Person("王", "五"));

        Person[] people = personList.toArray(new Person[personList.size()]);
        Arrays.sort(people, Comparator.comparing(Person::getFirstName).thenComparing(Person::getLastName));

        for (Person person : people) {
            System.out.println(person);
        }
    }


    static class Person {
        String firstName;
        String lastName;

        public Person(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    '}';
        }
    }
}
