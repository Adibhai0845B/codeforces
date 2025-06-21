import java.util.*;
import java.io.*;

public class DSU {
    private int[] parent, rank, size;
    private int components;

    public DSU(int n) {
        parent = new int[n];
        rank = new int[n];
        size = new int[n];
        components = n;

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int find(int x) {
        if (parent[x] != x)
            parent[x] = find(parent[x]);
        return parent[x];
    }

    public boolean union(int x, int y) {
        int px = find(x), py = find(y);
        if (px == py) return false;

        if (rank[px] < rank[py]) {
            parent[px] = py;
            size[py] += size[px];
        } else if (rank[px] > rank[py]) {
            parent[py] = px;
            size[px] += size[py];
        } else {
            parent[py] = px;
            rank[px]++;
            size[px] += size[py];
        }
        components--;
        return true;
    }

    public int getComponentCount() {
        return components;
    }

    public int getComponentSize(int x) {
        return size[find(x)];
    }

    public static void main(String args[]) throws IOException {
        FastInput sc = new FastInput();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] p = new int[n];
            int[] d = new int[n];
            DSU d1 = new DSU(n);

            for (int i = 0; i < n; i++) {
                p[i] = sc.nextInt();
                d1.union(p[i] - 1, i);
            }

            for (int i = 0; i < n; i++) {
                d[i] = sc.nextInt() - 1;
            }

            HashSet<Integer> visited = new HashSet<>();
            long ans = 0;
            for (int i = 0; i < n; i++) {
                int root = d1.find(d[i]);
                if (!visited.contains(root)) {
                    visited.add(root);
                    ans += d1.getComponentSize(d[i]);
                }
                            System.out.print(ans+" ");
            }
            System.out.println();
        }
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
