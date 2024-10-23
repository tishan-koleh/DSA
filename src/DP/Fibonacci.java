package DP;

public class Fibonacci {
    public static void main(String[] args) {
        int n = 4;
        int[] dp = new int[n+1];
        System.out.println(fibonacci(4, dp));
    }

    public static int fibonacci(int n, int[] dp){
        if(n <= 1){
            return n;
        }
        if (dp[n] != 0) return dp[n];

        return dp[n] = fibonacci(n-2, dp) + fibonacci(n-1, dp);
    }
}
