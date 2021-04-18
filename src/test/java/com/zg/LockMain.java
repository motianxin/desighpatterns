package com.zg;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class LockMain {
    public static final Set<String> DEADENDS = new HashSet<String>() {
        private static final long serialVersionUID = -7579303754743260572L;

        {
            add("8531");
        }
    };

    public static final String STAR = "0000";

    public static final String TARGET = "8532";

    public static void main(String[] args) {
        oneSide();
        doubleWays();
    }

    private static void oneSide() {
        int step = 0;
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        visited.add(STAR);
        queue.offer(STAR);
        while (!queue.isEmpty()) {
            int qsz = queue.size();
            for (int i = 0; i < qsz; i++) {
                String cur = queue.poll();
                if (DEADENDS.contains(cur)) {
                    continue;
                }
                if (TARGET.equals(cur)) {
                    System.out.println(step);
                    return;
                }
                if (cur == null) {
                    return;
                }
                // 周围的
                Set<String> surround = getAround(cur);
                for (String around : surround) {
                    if (visited.add(around)) {
                        queue.offer(around);
                    }
                }
            }
            step++;
        }
        System.out.println(-1);
    }

    private static Set<String> getAround(String cur) {
        Set<String> around = new HashSet<>(cur.length());
        for (int i = 0; i < cur.length(); i++) {
            around.add(plusOne(cur, i));
            around.add(minusOne(cur, i));
        }
        return around;
    }

    private static String minusOne(String cur, int index) {
        char[] curChars = cur.toCharArray();
        if (curChars[index] == '0') {
            curChars[index] = '9';
        } else {
            curChars[index] -= 1;
        }
        return new String(curChars);
    }

    private static String plusOne(String cur, int index) {
        char[] curChars = cur.toCharArray();
        if (curChars[index] == '9') {
            curChars[index] = '0';
        } else {
            curChars[index] += 1;
        }
        return new String(curChars);
    }

    private static void doubleWays() {
        Set<String> q1 = new HashSet<>();
        q1.add(STAR);
        Set<String> q2 = new HashSet<>();
        q2.add(TARGET);
        Set<String> visited = new HashSet<>();
        Set<String> deads = new HashSet<>(DEADENDS);
        int step = 0;
        while (!q1.isEmpty() && !q2.isEmpty()) {
            Set<String> temp = new HashSet<>();
            for (String cur : q1) {
                if (deads.contains(cur)) {
                    continue;
                }
                if (q2.contains(cur)) {
                    System.out.println(step);
                    return;
                }
                visited.add(cur);
                // 周围的
                Set<String> surround = getAround(cur);
                for (String around : surround) {
                    if (!visited.contains(around)) {
                        temp.add(around);
                    }
                }
            }
            step++;
            q1 = q2;
            q2 = temp;
        }
        System.out.println(-1);
    }
}
