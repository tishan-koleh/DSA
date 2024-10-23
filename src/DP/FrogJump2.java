package DP;

import java.util.Arrays;

public class FrogJump2 {
    public static void main(String[] args) {
        int N = 5;
        int K = 3;
        int[] stones = {10,30,40,50,20};
        int[] dp = new int[N];
        Arrays.fill(dp, -1);
        System.out.println(minCost(N, K, stones, dp));
    }

    private static int minCost(int N, int K, int[] stones, int[] dp){
        return findMinCost(N - 1, K, stones, dp);
    }

    private static int findMinCost(int index, int k,  int[] stones, int[] dp){
        if (index == 0) return 0;
        if (dp[index] != -1) return dp[index];
        int minEnergy = Integer.MAX_VALUE;
        for (int i = 1; i <= k; i++){
            if (index >= i){
                int energy = findMinCost(index - i, k, stones, dp) + Math.abs(stones[index] - stones[index - i]);
                minEnergy = Math.min(minEnergy, energy);
            }
        }
        return dp[index] = minEnergy;
    }

}
