import java.util.*;
import java.math.BigInteger;
public class DivisorsArray {
    private static final long MOD = 1000000007;
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer >> adj = new ArrayList < > ();
        for (int i = 0; i < 5; i++) {
            adj.add(new ArrayList < > ());
        }
        adj.get(0).add(2);
        adj.get(2).add(0);
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(0).add(3);
        adj.get(3).add(0);
        adj.get(2).add(4);
        adj.get(4).add(2);
        DivisorsArray a1 = new DivisorsArray();
        ArrayList<Integer>a2 = a1.dfsof(5, adj);
        int n = a2.size();
        for(int i =0;i<n;i++){
            System.out.println(a2.get(i)+" ");
        }
    }
    public static void dfs(int node,int vis[],ArrayList<ArrayList<Integer>>a1,ArrayList<Integer> li){
        vis[node] = 1;
        li.add(node);
        for(Integer it:a1.get(node)){
            if(vis[it]==0){
                dfs(it,vis,a1,li);
            }
        }
    }
    public static ArrayList<Integer> dfsof(int V,ArrayList<ArrayList<Integer>>a1){
      int vis[] =new int[V+1];
      vis[0] = 1;
        ArrayList<Integer> la = new ArrayList<>();
        dfs(0,vis,a1,la);
        return la;
    }
}
