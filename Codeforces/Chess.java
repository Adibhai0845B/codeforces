import java.util.*;
public  class Chess{
    static int n;
   static int m;
   static  ArrayList<ArrayList<Integer>>a1 = new ArrayList<>();
 static boolean vis[] ;
 static boolean cycle = true;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
     n = sc.nextInt();
     m = sc.nextInt();
     for(int i =0;i<n;i++) a1.add(new ArrayList<>());
     for(int i =0;i<m;i++){
        int u = sc.nextInt()-1;
        int v = sc.nextInt()-1;
        a1.get(u).add(v);
        a1.get(v).add(u);
     }
      int ans =0;
        vis =new boolean[n];
      for(int i =0;i<n;i++){
        if(!vis[i]){
            cycle = true;
            dfs(i);
            if(cycle) ans++;;
        }
      }
      System.out.println(ans);
    }
    public static void dfs(int node){
        vis[node] =true;
        if(a1.get(node).size()!=2)cycle=false;
        for(int ne:a1.get(node)){
           if(!vis[ne]){
            dfs(ne);
           }
        }
    }
  }
