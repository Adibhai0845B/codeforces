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
import java.util.*; 
public class dsuu {
    static long count =0;
    public static void main(String[] args) throws IOException{
        FastInput sc = new FastInput();
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();            int p[] = new int[n];
            for(int i =0;i<n;i++){
                p[i] = sc.nextInt()-1;
            }
            DSU d1 = new DSU(n);
            ArrayList<ArrayList<Integer>> a1 = new ArrayList<>();
            for(int i =0;i<n-1;i++){
                for(int j = i+1;j<n;j++){
                    if(p[i]>p[j]){
                    d1.union(i,j);
                    }
                }
            }
            System.out.println(d1.getComponentCount());

        }
    }  
}
class DSU {
    private int[] parent, rank;
    private int components;

    public DSU(int n) {
        parent = new int[n];
        rank = new int[n];
        components = n;
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
            components--;
        }
    }

    public int getComponentCount() {
        return components;
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
