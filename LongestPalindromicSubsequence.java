import java.util.*;

public class LongestPalindromicSubsequence {
    public static int cSumOfKSubarrays(int[] nums, int k, int m) {
        int n = nums.length;
        int[] pres = new int[n + 1];
        for (int i = 0; i < n; i++) {
            pres[i + 1] = pres[i] + nums[i];
        }
        int[][] a = new int[k + 1][n + 1];
       for(int i =0;i<+k;i++){
        for(int j =0;j<=n;j++){
            a[i][j] = Integer.MIN_VALUE;
        }
       }
        for (int j=0;j<n;j++) {
            a[0][j] = 0;
        }
            for (int i=1;i<= k;i++) {
            for (int j=i*m;j<= n;j++) {
                a[i][j] = a[i][j - 1];
                int c = pres[j] - pres[j - m];
                a[i][j] = Math.max(a[i][j], a[i - 1][j - m] + c);
            }
        }
        return a[k][n];
    }
}