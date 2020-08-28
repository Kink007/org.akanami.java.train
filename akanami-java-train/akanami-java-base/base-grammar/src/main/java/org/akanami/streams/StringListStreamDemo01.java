package org.akanami.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringListStreamDemo01 {
    public static void main(String[] args) {
        String[] arr = new String[]{"hello", "world", "my", "friend"};
        Stream<String> stream = Arrays.stream(arr).filter(t -> t.length() < 5);
        String collect = stream.collect(Collectors.joining());
        System.out.println(stream);
        System.out.println(collect);

        System.out.println(Arrays.stream(arr).filter(t -> t.length() > 3).count());
        System.out.println(Arrays.stream(arr).filter(t -> t.length() == 5).sorted().mapToInt(t -> t.length()).sum());

        class StringPredicate implements Predicate<String> {
            int requiredLength = 0;

            public StringPredicate(int requiredLength) {
                this.requiredLength = requiredLength;
            }

            @Override
            public boolean test(String s) {
                if(s == null)
                    return false;
                if(s.length() < requiredLength)
                    return false;

                return true;
            }
        }
        System.out.println(Arrays.stream(arr).filter(new StringPredicate(5)).findFirst().get());

        Optional<String> first = Arrays.stream(arr).filter(new StringPredicate(10)).findFirst();
        System.out.println("first is present:" + first.isPresent());
    }
}
