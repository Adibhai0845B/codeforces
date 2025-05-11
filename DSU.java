import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
public class DSU {
    private int[] parent, rank, size;
    private int n, components;
    private int maxSize;
    public DSU(int n) {
        this.n = n;
        parent = new int[n];
        rank = new int[n];
        size = new int[n];
        components = n;
        maxSize = 1;
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
            maxSize = Math.max(maxSize, size[py]);
        } else if (rank[px] > rank[py]) {
            parent[py] = px;
            size[px] += size[py];
            maxSize = Math.max(maxSize, size[px]);
        } else {
            parent[py] = px;
            rank[px]++;
            size[px] += size[py];
            maxSize = Math.max(maxSize, size[px]);
        }
        components--;
        return true;
    }

    public int getComponentCount() {
        return components;
    }

    public int getMaxComponentSize() {
        return maxSize;
    }
public static void main(String args[]) throws IOException {
    FastInput sc = new FastInput();
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = sc.nextInt();
    int m = sc.nextInt();
    DSU d = new DSU(n);
    for (int i = 0; i < m; i++) {
        d.union(sc.nextInt()-1,sc.nextInt()-1);
        bw.write(d.getComponentCount() + " " + d.getMaxComponentSize() + "\n");
    }
    bw.flush();
}
}
 class FastInput{
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
