import java.io.*;
import java.util.*;

public class SegmentTreeOptimized {
    public static void main(String[] args) throws IOException {
        FastInput sc = new FastInput();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));      
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            long[] a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
            }

            // Precompute prefix sum of a[]
            long[] prefixSum = new long[n + 1];
            for (int i = 0; i < n; i++) {
                prefixSum[i + 1] = prefixSum[i] + a[i];
            }

            int q = sc.nextInt();
            while (q-- > 0) {
                int l = sc.nextInt();
                int r = sc.nextInt();
                long sum = 0;

                // simulate b[l] to b[r]
                for (int i = l; i <= r; i++) {
                    int rot = i / n;
                    int idx = i % n;
                    sum += a[(idx + rot) % n];
                }

                bw.write(sum + "\n");
            }
        }

        bw.flush();
        bw.close();
    }
}

class FastInput {
    BufferedReader br;
    StringTokenizer st;

    public FastInput() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    String next() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine());
        }
        return st.nextToken();
    }

    int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    long nextLong() throws IOException {
        return Long.parseLong(next());
    }
}
