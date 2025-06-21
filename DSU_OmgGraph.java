import java.io.*;
import java.util.*;

public class DSU_OmgGraph {
    public static void main(String[] args) throws IOException {
        FastInput sc = new FastInput();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
int a[][] = new int[m][3];
            for (int i = 0;i<m;i++) {
        a[i][0]= sc.nextInt() - 1;
          a[i][1]=sc.nextInt() - 1;
         a[i][2]=sc.nextInt();
            }
          long ans = Long.MAX_VALUE;
                  Arrays.sort(a, Comparator.comparingInt(o->o[2]));
                  DSU d1 = new DSU(n);
          for(int i =0;i<m;i++){
            d1.union(a[i][0],a[i][1],a[i][2]);
            if(d1.find(0)==d1.find(n-1)){
             ans = Math.min(ans,d1.cc(n-1)+a[i][2]);
            }
          }
                  System.out.println(ans);
        }
        bw.flush();
    }
}
class DSU {
    int[] parent, size, ccmin;
    DSU(int n) {
        parent = new int[n];
        size = new int[n];
        ccmin = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
            ccmin[i] = Integer.MAX_VALUE;
        }
    }
    int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    void union(int x, int y, int weight) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            if (size[rootX] < size[rootY]) {
                int temp = rootX;
                rootX = rootY;
                rootY = temp;
            }
            parent[rootY] = rootX;
            size[rootX] += size[rootY];
            ccmin[rootX] = Math.min(Math.min(ccmin[rootX], ccmin[rootY]), weight);
        }
        ccmin[rootX] = Math.min(ccmin[rootX], weight);
    }
    int cc(int x) {
        return ccmin[find(x)];
    }
}
class FastInput {
    BufferedReader br;
    StringTokenizer st;

    public FastInput() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    String next() throws IOException {
        while (st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
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
