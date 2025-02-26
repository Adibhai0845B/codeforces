import java.util.*;
public class bfs {
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
 Queue<Integer> q1 = new LinkedList<>();
  for(int i =0;i<n;i++){
    if(vis[i]==0)  q1.add(i);
    vis[i] = 1;
 while(!q1.isEmpty()){
     int x = q1.poll();
     vis[x] = 1;
     System.out.println(x);
     for(int it:a1.get(x)){
           if(vis[it]!=1){
            q1.add(it);
            vis[it] = 1;
    
           }
         }
    }
 }
    }
}
