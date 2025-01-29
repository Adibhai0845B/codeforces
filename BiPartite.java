import java.util.*;
public class BiPartite {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int color[] = new int[n+1];
        ArrayList<ArrayList<Integer>>a1 = new ArrayList<>();
        for(int i =0;i<=n;i++){
            a1.add(new ArrayList<>());
        }
        //int col =0;
        for(int i =0;i<m;i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            a1.get(u).add(v);
            a1.get(v).add(u);
        }
        Arrays.fill(color,-1);
        if(bipartite(n, a1, color)){
            System.out.println("YES");
        }
        else{
            System.out.println("NO");
        }

    }
    public static boolean bipartite(int n , ArrayList<ArrayList<Integer>> a1,int color[]){
     for(int i =0;i<n;i++){
        if(color[i]==-1){
           if(!dfs(i, a1, color, 0, n)){
                return false;
            }
        }
     }
     return true;
    }
    public static boolean dfs(int node,ArrayList<ArrayList<Integer>>a1,int color[],int col,int n){
        color[node]= col;
              for(int it:a1.get(node)){
          if(color[it]==-1){
            if(!dfs(it,a1,color,1-col,n)){
             return false;
            }
        }
        else if(color[it]==col){  
            return false;
          
        }
              }
          return true;
            }
    }
