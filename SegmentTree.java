import java.io.*;
import java.util.*;

public class SegmentTree {
    public static void main(String[] args) throws IOException {
        FastInput sc = new FastInput();
        int n = sc.nextInt();
        int a[] = new int[n];
        int max = 0;

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            max = Math.max(max, a[i]);
        }
        max += 1;

        long freq[] = new long[max + 1];
        for (int i = 0; i < n; i++) {
            freq[a[i]]++;
        }
        long seg[] = new long[max * 4];  
        build(0, 0, max - 1, freq, seg);
           long ans[] = new long[n];
        for (int i = 0; i < n; i++) {
            freq[a[i]]--;
            update(0, 0, max - 1, a[i], -1, seg);
           long  count = query(0, 0, max - 1, 1, a[i] - 1, seg);
          ans[i] = count;
        }
        for(int i= n-1;i>=0;i--){
            System.out.print(ans[i]+" ");
        }
        System.out.println();
    }

    public static void build(int ind, int low, int high, long a[], long seg[]) {
        if (low == high) {
            seg[ind] = a[low];
            return;
        }
        int mid = (low + high) / 2;
        build(2 * ind + 1, low, mid, a, seg);
        build(2 * ind + 2, mid + 1, high, a, seg);
        seg[ind] = seg[2 * ind + 1] + seg[2 * ind + 2];
    }

    public static long query(int ind, int low, int high, int l, int r, long seg[]) {
        if (l > r) return 0; // Fix invalid range case
        if (low > r || high < l) return 0;
        if (low >= l && high <= r) return seg[ind];
        int mid = (low + high) / 2;
        long left = query(2 * ind + 1, low, mid, l, r, seg);
        long right = query(2 * ind + 2, mid + 1, high, l, r, seg);
        return left + right;
    }

    public static void update(int ind, int low, int high, int i, long val, long seg[]) {
        if (low == high) {
            seg[ind] += val; // Fix: add val instead of overwriting
            return;
        }
        int mid = (low + high) / 2;
        if (i <= mid) update(2 * ind + 1, low, mid, i, val, seg);
        else update(2 * ind + 2, mid + 1, high, i, val, seg);
        seg[ind] = seg[2 * ind + 1] + seg[2 * ind + 2];
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

    double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }

    String nextLine() throws IOException {
        return br.readLine();
    }

    public void close() throws IOException {
        br.close();
    }
}
