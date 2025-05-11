import java.io.*;
import java.util.*;

public class A_GENERAL {
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Integer> primes = new ArrayList<>();
    static int n, m, k;
    static ArrayList<Integer>[] adj;
    static boolean[] vis;
    static final long MOD = 998244353;
    static int[] rank;
    static int[] pa;
    static int x, y;
    static long t1 = 0;
    static long t2 = 0;
    static long t3 = 0;
    static long[] ch;
    static boolean found = false;

    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        scanr sc = new scanr();
        n = sc.nextInt();
        x = sc.nextInt();
        y = sc.nextInt();
        ch = new long[n + 1];
        adj = new ArrayList[n + 1];
        vis = new boolean[n + 1];
        pa = new int[n + 1];
        rank = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<>();
            pa[i] = i;
            rank[i] = 0;
        }
        for (int i = 1; i <= n - 1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj[u].add(v);
            adj[v].add(u);
        }
        dfs(x);
        long ans = t2 * (n - 1) + (n - t2) * (n - 1 - ch[y]);
        out.println(ans);
        out.close();
    }
    public static long dfs(int u) {
        vis[u] = true;
        if (u == y)
            found = true;long cnt = 1;
        for (int v : adj[u]) {
            if (!vis[v]) {
                boolean oldfound = found;
                long cc = dfs(v);
                cnt += cc;
                if (found && !oldfound) {
                    t2 = cc;
                }
            }
        }
        ch[u] = cnt;
        return cnt;
    }
    public static class scanr {
        BufferedReader br;
        StringTokenizer st;

        public scanr() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
