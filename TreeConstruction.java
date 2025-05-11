import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;
import java.util.function.BiConsumer;
import java.math.*;
import static java.lang.System.console;
import static java.lang.System.nanoTime;
import static java.lang.System.out;
public class TreeConstruction {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            solve(sc);
        }
    }
    static void solve(Scanner sc) {
        ArrayList<Integer>[] a1 = new ArrayList[100002];
        int n = sc.nextInt();
        long[] v = new long[100002];
        for (int i = 0; i <= n; i++) {
            if (a1[i] == null) a1[i] = new ArrayList<>();
            else a1[i].clear();
        }
        for (int i=1;i<=n;i++) {
          v[i]=sc.nextLong();
        }
  char[] s = new char[n];  Arrays.fill(s, '0');
        for (int i =0;i<n-1;i++) {
            int u = sc.nextInt();int v1 = sc.nextInt();
            if (v[u] == v[v1]) {
         s[(int)v[u]-1] = '1';
            }
            a1[u].add(v1);
            a1[v1].add(u);
        }
  for(int i=1;i<=n;i++) {
      HashMap<Long,Integer> h1 = new HashMap<>();
            for(int j:a1[i]) {
       h1.put(v[j],h1.getOrDefault(v[j], 0) + 1);
                if (h1.get(v[j]) == 2) {
          s[(int)v[j] - 1] = '1';
         }
            }
        }
System.out.println(s);
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