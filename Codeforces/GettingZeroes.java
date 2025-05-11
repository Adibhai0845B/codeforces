import java.util.*;
public class GettingZeroes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
      ArrayList<ArrayList<Integer>> a1 = new ArrayList<>();
      for(int i =0;i<=n;i++){
        a1.add(new ArrayList<>());
      }
        for(int i =0;i<m;i++){
             int u = sc.nextInt();
             int v = sc.nextInt();
            a1.get(u).add(v);
            a1.get(v).add(u);
        }
        boolean vis[] = new boolean[n+1];
  int count =0;
        for(int i = 1;i<=n;i++){
        if(!vis[i]&& dfs(i,a1,vis)){
    System.out.println();
    count++;
        }
        }
        System.out.println();
		System.out.println(count);
    }
    public  static boolean dfs(int node,ArrayList<ArrayList<Integer>>a1,boolean vis[]){
        boolean result = a1.get(node).size()==2;
         vis[node] = true;
         for (int x : a1.get(node)) {
			if (!vis[x] && !dfs(x,a1,vis)) {
				result = false;
			}
		}
        return result;
    }
}
