import java.util.*;

public class Bear {
   static  ArrayList<ArrayList<Integer>>a1;
    static boolean visited[];
  static double leng =0;
 static double sum =0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
     int n = sc.nextInt();
     a1 = new ArrayList<>();
     for(int i =0;i<n;i++){
        a1.add(new ArrayList<>());
     }
       for(int i=0;i<n-1;i++){
        int u = sc.nextInt()-1;
        int v = sc.nextInt()-1;
        a1.get(u).add(v);
        a1.get(v).add(u);
       }
         visited = new boolean[n+1];
          Arrays.fill(visited,false);
          dfs(0);
          System.out.println(leng+" "+sum);
          System.out.println(leng/sum);
    }
    public static void dfs(int node) {
        visited[node] = true;
        for (int neighbor : a1.get(node)) {
            if (!visited[neighbor]) {
             dfs(neighbor);
                leng++;
            }
        }
        sum++;
    }
    }        