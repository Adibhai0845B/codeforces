import java.util.*;
import java.math.BigInteger;

public class sec {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            BigInteger[] a = new BigInteger[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextBigInteger();
            }
            int ans = min(a);
            System.out.println(ans);
        }
    }

    public static int min(BigInteger[] a) {
        int n = a.length;
        int ans = 0;
        BigInteger limit = new BigInteger("1000000");
        for (int i = n - 2; i >= 0; i--) {
            while (a[i].compareTo(a[i + 1]) > 0) {
                if (a[i].equals(BigInteger.ONE)) {
                    return -1;
                }
                a[i] = a[i].multiply(a[i]);
                ans++;
                if (a[i].compareTo(limit) > 0) {
                    return -1;
                }
            }
        }
        return ans;
    }
}