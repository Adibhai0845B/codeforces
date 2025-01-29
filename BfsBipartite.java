import java.util.*;
public class BfsBipartite {
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
       int col = 0;
       int count =0;
             for(int i =0;i<n;i++){
                if(color[i]==-1){
                    color[i]=0;
                    Queue<Integer>q1 = new LinkedList();
           q1.add(i);
           while(!q1.isEmpty()){
            int u = q1.poll();
            for(int v:a1.get(u)){
                if(color[v]==-1){
                    color[v]= 1-color[u];
                    q1.add(v);
                }
                else if(color[v]==color[u]){
                    count++;
                    break;
                }
            }
           }
        }
            }
            if(count>0){
                System.out.println("NO");
             }
             else{
                System.out.println("YES");
             }
        }
    }