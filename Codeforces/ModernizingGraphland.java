import java.util.*;

public class ModernizingGraphland {
    static int n, m, q, k;
    static List<Integer>[] graph;
    static List<int[]> edges;
    static int[] removalOrder;
    static boolean[] removed;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        
        graph = new ArrayList[n + 1];
        edges = new ArrayList<>();
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();
        
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt(), v = sc.nextInt();
            edges.add(new int[]{u, v});
            graph[u].add(v);
            graph[v].add(u);
        }
        
        q = sc.nextInt();
        k = sc.nextInt();
        
        removalOrder = new int[q];
        removed = new boolean[m];
        for (int i = 0; i < q; i++) {
            removalOrder[i] = sc.nextInt() - 1; // Convert to zero-based index
            removed[removalOrder[i]] = true;
        }
        
        // Initial check for strong connectivity
        if (!isStronglyConnected()) {
            System.out.println(-1);
            return;
        }
        
        // Simulating road removals
        for (int year = 0; year < q; year++) {
            int[] road = edges.get(removalOrder[year]);
            graph[road[0]].remove((Integer) road[1]);
            graph[road[1]].remove((Integer) road[0]);
            
            if (!isStronglyConnected()) {
                System.out.println(year);
                return;
            }
        }
        
        System.out.println(q);
    }
    
    static boolean isStronglyConnected() {
        boolean[] visited = new boolean[n + 1];
        dfs(1, visited);
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) return false;
        }
        return true;
    }
    
    static void dfs(int node, boolean[] visited) {
        visited[node] = true;
        for (int neighbor : graph[node]) {
            if (!visited[neighbor]) dfs(neighbor, visited);
        }
    }
}
