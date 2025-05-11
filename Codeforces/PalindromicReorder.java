import java.util.*;

public class PalindromicReorder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m1 = sc.nextInt();
        int m2 = sc.nextInt();
        DisjointSet ds1 = new DisjointSet(n);DisjointSet ds2 = new DisjointSet(n);
        for (int i = 0; i < m1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            ds1.unionByRank(u, v);
        }
        for (int i = 0; i < m2; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            ds2.unionByRank(u, v);
        }
        int ans = 0;
        ArrayList<Pair> a1 = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (ds1.findUPar(i) != ds1.findUPar(j) && ds2.findUPar(i) != ds2.findUPar(j)) {
                    ds1.unionByRank(i, j); ds2.unionByRank(i, j);
                    ans++;a1.add(new Pair(i, j));
                }
            }
        }
        System.out.println(ans);
        for (Pair it : a1) {
            System.out.println(it.first + " " + it.second);
        }
  }
}
class DisjointSet {
  List<Integer> rank = new ArrayList<>();
  List<Integer> parent = new ArrayList<>();
  List<Integer> size = new ArrayList<>(); 

  public DisjointSet(int n) {
      for (int i = 0; i <= n; i++) {
          rank.add(0); 
          parent.add(i); 
          size.add(1); 
      }
  }
  public int findUPar(int node) {
      if (node == parent.get(node)) {
          return node; 
      }
      int ulp = findUPar(parent.get(node)); 
      parent.set(node, ulp);
      return ulp; 
  }
  public void unionByRank(int u, int v) {
      int ulp_u = findUPar(u); 
      int ulp_v = findUPar(v); 

      if (ulp_u == ulp_v) return;

      if (rank.get(ulp_u) < rank.get(ulp_v)) {
          parent.set(ulp_u, ulp_v); 
      } else if (rank.get(ulp_v) < rank.get(ulp_u)) {
          parent.set(ulp_v, ulp_u); 
      } else {
          parent.set(ulp_v, ulp_u); 
          rank.set(ulp_u, rank.get(ulp_u) + 1); 
      }
  }
}
class Pair{
  int first, second;
  public Pair(int first, int second) {
      this.first = first;
      this.second = second;
      }
}