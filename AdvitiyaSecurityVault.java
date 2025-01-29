import java.io.*;
import java.util.*;

public class AdvitiyaSecurityVault {
    static final int MOD = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[] A = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }

            sb.append(findAttempts(N, K, A)).append("\n");
        }

        System.out.print(sb);
    }

    private static int findAttempts(int N, int K, int[] A) {
        long P = 1, Q = 1, R = 1;
        int half = N / 2;

        for (int i = 0; i < N; i++) {
            int j = N - 1 - i;

            // Calculate P
            if (A[i] == 0) {
                P = P * K % MOD;
            }

            // Calculate Q
            if (i <= j) {
                if (A[i] != 0 && A[j] != 0) {
                    if (A[i] != A[j]) {
                        Q = 0;
                    }
                } else if (A[i] == 0 || A[j] == 0) {
                    Q = Q * K % MOD;
                }
            }

            // Calculate R
            if (i < half) {
                if (A[i] != 0 && A[j] != 0) {
                    if (A[i] != A[j]) {
                        R = 0;
                    }
                } else if (A[i] == 0 && A[j] == 0) {
                    R = R * K % MOD;
                }
            }
        }

        if (N % 2 != 0) {
            int m = N / 2;
            if (A[m] == 0) {
                R = R * K % MOD;
            }
        }

        long twoP = (2 * P) % MOD;
        long numerator = (twoP - Q + R) % MOD;
        if (numerator < 0) {
            numerator += MOD;
        }

        long inv2 = modInverse(2, MOD);
        long attempts = numerator * inv2 % MOD;

        return (int) attempts;
    }

    private static long modInverse(long a, int mod) {
        return power(a, mod - 2, mod);
    }

    private static long power(long base, long exp, int mod) {
        long result = 1;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = result * base % mod;
            }
            base = base * base % mod;
            exp >>= 1;
        }
        return result;
    }
}
