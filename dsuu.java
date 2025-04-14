import java.util.*;

public class dsuu {
    static long count =0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<HashSet<Integer>>a1 = new ArrayList<>();
        for(int i=0;i<n;i++){
          a1.add(new HashSet<>());
        }
        for(int i =0;i<m;i++){
           int u = sc.nextInt()-1;
           int v = sc.nextInt()-1;
           a1.get(u).add(v);
           a1.get(v).add(u);
        }
        int color[]  = new int[n];
       Arrays.fill(color,-1);
       boolean ans = true;
       for (int i = 0; i < n; i++) {
        if (color[i]==-1){
         ans = isBipartite(n, a1, color);
          if(ans==false){
            break;
          }
        }
    }
        if(!ans){
           System.out.println(-1);
        }
        else{
            System.out.println(n-count);
            for(int i=0;i<n;i++){
                if(color[i]==0){
                    System.out.print((i+1)+" ");
                }
            }
            System.out.println();
            System.out.println(count);
            for(int i =0;i<n;i++){
                if(color[i]==1){
                  System.out.print((i+1)+" ");
                }
                }

        }
        System.out.println();
    }
    public static boolean isBipartite(int V, ArrayList<HashSet<Integer>> a1, int[] color) {
        for (int i = 0; i < V; i++) {
            if (color[i] == -1) {
                if (!dfsBipartite(i, 0, color, a1)) {
                    return false;
                }
            }
        }
        return true;
    }
    private static boolean dfsBipartite(int node, int col, int[] color, ArrayList<HashSet<Integer>> a1) {
        color[node] = col;
        if(color[node]==1)count++;
        for (int neighbor : a1.get(node)) {
            if (color[neighbor] == -1) {
                if (!dfsBipartite(neighbor, 1 - col, color, a1)) {
                    return false;
                }
            } else if (color[neighbor] == col) {
                return false;
            }
        }
        return true;
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