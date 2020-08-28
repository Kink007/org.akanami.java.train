package org.akanami.collections.sets.hashsets;

import java.util.HashSet;
import java.util.Objects;

/*
    HashSet 是不允许重复的，重写泛型类的 equals和 hashCode方法之后可以防止重复，但新增的貌似不会替换旧值
 */
public class NoRepeatDemo01 {
    public static void main(String[] args) {
        HashSet<User> userSet = new HashSet<>();
        userSet.add(new User(1, "张三"));
        userSet.add(new User(2, "张三"));
        userSet.add(new User(2, "李四"));
        userSet.forEach(t -> {
            System.out.println(t);
        });
    }

    static class User {
        int id;
        String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }


        public int getId() {
            return this.id;
        }

        public String getName() {
            return this.name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            User user = (User) o;
            return id == user.id;
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }

        @Override
        public String toString() {
            return "User{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}
