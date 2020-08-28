package org.akanami.collections.queues;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayDeque;
import java.util.ListIterator;

public class OfferPeekDemo01 {
    public static void main(String[] args) {
        ArrayQueue<User> userQueue = new ArrayQueue<>(10);
        for(int i = 0; i < 10; i++) {
            userQueue.add(new User("name" + i));
        }

        System.out.println(userQueue);

        ArrayDeque<User> userDeque = new ArrayDeque<>(10);
        //从空队列中使用remove方法移除元素的话，会抛出java.util.NoSuchElementException 异常
        //使用poll不会抛出异常，只会返回null
//        User userRemove = userDeque.remove();
//        System.out.println("userRemove:" + userRemove);
        User userPoll = userDeque.poll();
        System.out.println("Poll from empty Deque:" + userPoll);
//        for(int i = 0; i < 10; i++) {
//            userDeque.add(new User("name" + i));
//        }
//
//        System.out.println(userDeque);
//
//        userDeque.add(new User("error"));
//
//        System.out.println(userDeque);
    }

    static class User {
        String name;

        public User(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
}
