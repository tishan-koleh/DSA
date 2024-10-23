package DP;

import java.util.Arrays;

/**
 * The {@code MaximumSumOfNoAdjacentElements} class provides two methods for finding the maximum
 * sum of elements in an array such that no two adjacent elements are picked.
 *
 * - {@code maxSum}: Solves the problem using a top-down approach (recursion + memoization).
 * - {@code maxSumWithTabulation}: Solves the problem using a bottom-up approach (tabulation).
 */
public class MaximumSumOfNoAdjacentElements {
    /**
     * The main method demonstrates both the recursive and tabulation approach to find
     * the maximum sum of non-adjacent elements in an array.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        int[] arr = {1, 2, 4};  // Example array
        int[] dp = new int[arr.length];  // Array to store results for memoization/tabulation
        Arrays.fill(dp, -1);  // Initialize dp array with -1 for memoization
        System.out.println("Max sum using recursion + memoization: " + maxSum(arr.length - 1, arr, dp));
        System.out.println("Max sum using tabulation: " + maxSumWithTabulation(arr, dp));
    }

    /**
     * Finds the maximum sum of non-adjacent elements in the array using a top-down approach
     * (recursion + memoization).
     *
     * @param index The current index in the array being considered.
     * @param arr The input array of integers.
     * @param dp The memoization array to store results of subproblems.
     * @return The maximum sum of non-adjacent elements up to the given index.
     */
    private static int maxSum(int index, int[] arr, int[] dp) {
        // Base case: If we're at index 0, the only element we can pick is arr[0]
        if (index == 0) return arr[index];
        // Base case: If the index is negative, no elements can be picked, so return 0
        if (index < 0) return 0;
        // If the result for this index has already been computed, return it from dp
        if (dp[index] != -1) return dp[index];

        // Recursively find the maximum sum by either picking or not picking the current element
        int pick = arr[index] + maxSum(index - 2, arr, dp);  // Pick the current element, skip 1
        int notPick = maxSum(index - 1, arr, dp);  // Don't pick the current element

        // Store the result in dp and return the maximum of picking or not picking the element
        return dp[index] = Math.max(pick, notPick);
    }

    /**
     * Finds the maximum sum of non-adjacent elements in the array using a bottom-up approach
     * (tabulation).
     *
     * @param arr The input array of integers.
     * @param dp The table to store results of subproblems.
     * @return The maximum sum of non-adjacent elements for the entire array.
     */
    private static int maxSumWithTabulation(int[] arr, int[] dp) {
        // Base case: Initialize dp[0] to arr[0] since only one element can be picked
        dp[0] = arr[0];

        // Variables to store the sum when picking or not picking an element
        int pick;
        int notPick;

        // Iterate over the array starting from index 1
        for (int i = 1; i < arr.length; i++) {
            pick = arr[i];  // Option to pick the current element
            // If we can go back by 2 indices, add the sum of dp[i-2]
            if (i - 2 >= 0) pick += dp[i - 2];
            notPick = dp[i - 1];  // Option to not pick the current element

            // Store the maximum of picking or not picking the current element
            dp[i] = Math.max(pick, notPick);
        }

        // The last element of dp contains the result for the entire array
        return dp[dp.length - 1];
    }
}
