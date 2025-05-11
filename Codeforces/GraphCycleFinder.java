import java.util.*;
public class GraphCycleFinder {
   static int n;
   static List<List<Integer>> adj;
   static boolean[] visited;
    static int[] parent;
    static int st=-1;
    static int en=-1;
    public GraphCycleFinder(int n){
        this.n = n;
        adj = new ArrayList<>();
        for (int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
 }
        visited = new boolean[n];
        parent = new int[n];
        Arrays.fill(parent, -1);
    }
    public void addEdge(int u,int v){
  adj.get(u).add(v);adj.get(v).add(u);
    }  
    public static void findCycle() {
        Arrays.fill(visited, false);
        Arrays.fill(parent, -1);
        st=-1;
        for (int v=0;v<n;v++) {
    if(!visited[v]&&dfs(v, -1)){
  break;
        }
     }
        if(st==-1) {
            System.out.println("Acyclic");
        }else{
            List<Integer>cycle=new ArrayList<>();
            cycle.add(st);
        for(int v=en;v!=st;v=parent[v]){
             cycle.add(v);
            }
            cycle.add(st);
            System.out.print("Cycle found: ");
            for (int v:cycle) {
                System.out.print(v+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        GraphCycleFinder g = new GraphCycleFinder(5);
      Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
      adj = new ArrayList<>();
        for(int i =0;i<m;i++){
            int u = sc.nextInt()-1;
            int v = sc.nextInt()-1;
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        g.findCycle();
    }
    private static boolean dfs(int v, int par) {
        visited[v] = true;
        for (int u : adj.get(v)) {
            if(u == par) continue;
            if(visited[u]){
                en=v;st=u;
                return true;
            }
            parent[u]=v;
            if (dfs(u,parent[u]))
                return true;
        }
        return false;
    }
}
