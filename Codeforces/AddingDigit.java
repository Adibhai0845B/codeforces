import java.io.*;
import java.util.*;

public class AddingDigit {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();
        
        int t = Integer.parseInt(br.readLine());
        
        while (t-- > 0) {
            String[] nkx = br.readLine().split(" ");
            int n = Integer.parseInt(nkx[0]);
            int k = Integer.parseInt(nkx[1]);
            long x = Long.parseLong(nkx[2]);
            
            String[] aStr = br.readLine().split(" ");
            long[] a = new long[n];
            long sumA = 0;
            
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(aStr[i]);
                sumA += a[i];
            }
            
            long[] prefixSum = new long[2 * n + 1];
            
            // Prefix sum of two copies of array a
            for (int i = 0; i < 2 * n; i++) {
                prefixSum[i + 1] = prefixSum[i] + a[i % n];
            }
            
            long ans = 0;
            
            for (int l = 1; l <= n * k; l++) {
                int idxL = (l - 1) % n;
                int start = l;
                int end = Math.min(n * k, l + n * 2); // At most 2n elements
                
                int lo = l, hi = end;
                int res = -1;
                
                while (lo <= hi) {
                    int mid = (lo + hi) / 2;
                    long currSum = prefixSum[(mid - 1) % (2 * n) + 1] - prefixSum[(l - 1) % (2 * n)];
                    
                    long fullCycleSum = ((mid - l + 1) / n) * sumA;
                    currSum += fullCycleSum;
                    
                    if (currSum >= x) {
                        res = mid;
                        hi = mid - 1;
                    } else {
                        lo = mid + 1;
                    }
                }
                
                if (res != -1) ans++;
                
                if (l % n == 0 && l + n > n * k) break; // Optimization
            }
            
            out.append(ans).append("\n");
        }
        
        System.out.print(out);
    }
}
