import java.util.*;

public class TreeDiameter {

    static List<List<Integer>> tree = new ArrayList<>();

    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); 
       for (int i = 0; i < n; i++) tree.add(new ArrayList<>());
 for(int i =0;i<n-1;i++){
    int u = sc.nextInt()-1;
    int v = sc.nextInt()-1;
    tree.get(u).add(v);
    tree.get(v).add(u);
 }
        int farthestFromStart = bfs(0)[0];
        int diameter = bfs(farthestFromStart)[1];
        System.out.println(3*diameter);
    }

    static void addEdge(int u, int v) {
        tree.get(u).add(v);
        tree.get(v).add(u);
    }
    static int[] bfs(int start) {
        int n = tree.size();
        boolean[] visited = new boolean[n];
        int[] dist = new int[n];

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        int farthestNode = start;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : tree.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    dist[neighbor] = dist[node] + 1;
                    queue.offer(neighbor);
                    if (dist[neighbor] > dist[farthestNode]) {
                        farthestNode = neighbor;
                    }
                }
            }
        }

        return new int[]{farthestNode, dist[farthestNode]};
    }
}
