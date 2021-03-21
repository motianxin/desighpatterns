package com.zg;

import java.util.Arrays;

public class BagMain {
    private static final int[] COINS = new int[]{1, 5, 6, 8, 4, 2, 7};

    public static void main(String[] args) {
        int amount = 300;
        Integer[] memo = new Integer[amount + 1];
        System.out.println(dp(amount, memo));
        dpFor(amount);
    }

    private static int dp(int amount) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }
        int temp = amount;
        int subAmount;
        for (int coin : COINS) {
            subAmount = dp(amount - coin);
            if (subAmount == -1) {
                continue;
            }
            temp = Math.min(temp, 1 + subAmount);
        }
        return temp == amount ? -1 : temp;
    }

    private static int dp(int amount, Integer[] memo) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }
        if (memo[amount] != null) {
            return memo[amount];
        }
        int temp = amount;
        int subAmount;
        for (int coin : COINS) {
            subAmount = dp(amount - coin, memo);
            if (subAmount == -1) {
                continue;
            }
            temp = Math.min(temp, 1 + subAmount);
        }
        memo[amount] = temp == amount ? -1 : temp;
        return memo[amount];
    }

    private static void dpFor(int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 0; i < amount + 1; i++) {
            for (int coin : COINS) {
                if (i - coin < 0) {
                    continue;
                }
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }
        int result = dp[amount] == amount + 1 ? -1 : dp[amount];
        System.out.println(result);
    }
}
