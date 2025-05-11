import java.util.*;
public class DirectedDSU {
    private int[] parent;
    private int[] size;

    public DirectedDSU(int n) {
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }
    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public void union(int u, int v) {
        int rootU = find(u);
        int rootV = find(v);

        if (rootU == rootV) return;

        // Directed: attach u's root to v's root
        parent[rootU] = rootV;
        size[rootV] += size[rootU];
    }
    public boolean same(int u, int v) {
        return find(u) == find(v);
    }
    public int getSize(int x) {
        return size[find(x)];
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        DirectedDSU d = new DirectedDSU(n);
        int m = sc.nextInt();
        for(int i =0;i<m;i++){
            int u = sc.nextInt()-1;
            int v = sc.nextInt()-1;
            d.union(u, v);
        }
        int count =0;
        for(int i =0;i<n;i++){
            for(int j =0;j<n;j++){
                if(!d.same(i,j)){
         count++;
        System.out.println("NO");
        System.out.println(i+" "+j);
         break;
                }
            }
            if(count>0)
            {
                break;
              }
            }
            if(count==0)System.out.println("YES");
    }
}
