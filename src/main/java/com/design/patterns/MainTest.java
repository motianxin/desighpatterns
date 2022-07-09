package com.design.patterns;

import java.util.stream.Stream;

public class MainTest {
    public static void main(String[] args) {
        int[] ints = {4, 3, 1, 1, 2, 9, 1, 9, 9, 0, 0, 1, 2, 3};
        int[] count = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5};
        int[] unknown = {8, 4, 2};
        int sum = Stream.iterate(0, i -> i + 1)
                .limit(ints.length)
                .peek(System.out::println)
                .mapToInt(i -> ints[i] * count[i])
                .sum();
        System.out.println(sum);
        for (int i = 0; i < 1000; i++) {
            int sss = (sum + (i % 10) * unknown[2] + (i / 10 % 10) * unknown[1] + (i / 100) * unknown[0]) % 11;
            if (sss == 3) {
                System.out.println(i);
            }
        }
    }
}
