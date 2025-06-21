import java.util.*;
import java.io.*;

public class dfs {
    static int n;
    static ArrayList<ArrayList<Integer>> a1;

    public static void main(String[] args) throws IOException {
        FastInput sc = new FastInput();
        int t = sc.nextInt();
        while (t-- > 0) {
            n = sc.nextInt();
            a1 = new ArrayList<>();
            int[] a = new int[n]; // Node values

            // Read node values
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            // Initialize adjacency list for the tree
            for (int i = 0; i < n; i++) {
                a1.add(new ArrayList<>());
            }

            // Read edges
            for (int i = 0; i < n - 1; i++) {
                int u = sc.nextInt() - 1;
                int v = sc.nextInt() - 1;
                a1.get(u).add(v);
                a1.get(v).add(u);
            }

            int[] par = new int[n];
            Arrays.fill(par, -1);
            boolean[] visited = new boolean[n];

            // First BFS to build parent relationships
            int root = 0;
            Queue<Integer> q1 = new LinkedList<>();
            q1.add(root);
            visited[root] = true;
            par[root] = root;

            while (!q1.isEmpty()) {
                int node = q1.poll();
                for (int neighbor : a1.get(node)) {
                    if (!visited[neighbor]) {
                        visited[neighbor] = true;
                        par[neighbor] = node;
                        q1.add(neighbor);
                    }
                }
            }

            int[] ans = new int[n];
            for (int i = 0; i < n; i++) {
                ans[i] = a[i];
            }
            Queue<Pair> q2 = new LinkedList<>();
            q2.add(new Pair(root, a[root], 0));
            while (!q2.isEmpty()) {
                Pair p = q2.poll();
                int node = p.x;
                int value = p.y;
                int depth = p.z;

                for (int child : a1.get(node)) {
                    if (child != par[node]) {
                        int newValue = (depth % 2 == 0) ? value - a[child] : value + a[child];
                        ans[child] = Math.max(ans[child], newValue);
                        q2.add(new Pair(child, newValue, depth + 1));
                    }
                }
            }

            // Print answer array
            for (int i = 0; i < n; i++) {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
        }
    }
}class Pair {
    int x, y, z;

    public Pair(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
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
