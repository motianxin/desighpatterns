package com.zg.solution;

public class Solution {
    public static void main(String[] args) {
        int[] allTimes = new int[]{2, 5, 6, 8, 9};
        int[] arrive = new int[]{2, 4, 5, 6};
        int p1 = 0, p2 = 0;
        while (p2 < arrive.length) {
            if (p1 == allTimes.length) {
                break;
            }
            if (allTimes[p1] >= arrive[p2]) {
                p2++;
            }
            p1++;
        }
        System.out.println(p1);
        System.out.println(p2);
    }
}
