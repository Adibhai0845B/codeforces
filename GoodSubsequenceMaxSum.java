import java.util.*;

public class GoodSubsequenceMaxSum {

    static final int MOD = 1_000_000_007;

    public static int getMaxGoodSubsequenceSum(int n, int[] arr) {
        int k = n / 2;
        int[][] dp = new int[n + 1][k + 1];

        // Initialize dp with very small values except dp[0][0]
        for (int i = 0; i <= n; i++)
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        dp[0][0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                // Exclude current element
                dp[i][j] = dp[i - 1][j];

                // Include current element if possible (non-adjacent constraint)
                if (i >= 2 && j >= 1 && dp[i - 2][j - 1] != Integer.MIN_VALUE) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 2][j - 1] + arr[i - 1]);
                }
            }
        }

        // Ensure non-negative result under modulo
        return (dp[n][k] % MOD + MOD) % MOD;
    }

    // Example usage
    public static void main(String[] args) {
        int n = 5;
        int[] arr = {-1000, -100, -10, 0, 10};
        int result = getMaxGoodSubsequenceSum(n, arr);
        System.out.println("Maximum Good Subsequence Sum: " + result);
    }
}
