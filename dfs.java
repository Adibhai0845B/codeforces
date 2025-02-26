import java.util.*;
public class dfs{
   public static void dfs(int node,ArrayList<ArrayList<Integer>> a1,int vis[]){
        vis[node] = 1;
        System.out.println(node);
        for(int it:a1.get(node)){
          if(vis[it]!=1){
            dfs(it,a1,vis);
          }
        }
   }
    public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
        ArrayList<ArrayList<Integer>> a1= new ArrayList<>();
     int  n =sc.nextInt();
     int m = sc.nextInt(); 
     for(int i =0;i<n;i++){
       a1.add(new ArrayList<>());
     }
     for(int i =0;i<m;i++){
     int u = sc.nextInt();
     int v = sc.nextInt();    
    a1.get(u).add(v);
    a1.get(v).add(u);
    }
 int vis[] = new int[n];
        for(int  i=0;i<n;i++){
            dfs(i,a1,vis);
        }
   }  
}