package com.design.patterns;

import java.util.stream.Stream;

public class MainTest {
    public static void main(String[] args) {
        int[] ints = {4, 3, 1, 1, 2, 9, 1, 9, 9, 0, 0, 1, 2, 3};
        int[] count = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5};
        int sum = Stream.iterate(0, i -> i + 1)
                .limit(ints.length)
                .mapToInt(i -> ints[i] * count[i]).peek(System.out::println)
                .sum();
        System.out.println(sum);
    }
}
