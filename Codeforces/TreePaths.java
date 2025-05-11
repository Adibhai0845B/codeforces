import java.util.*;

public class TreePaths {
    static List<List<Integer>> graph;
    static int n;
    static int maxDiameter, maxPath;
    static int farthestNode;
    static Set<Integer> diameterNodes;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        sc.close();

        // Step 1: Find the farthest node from any arbitrary node (say, 1)
        maxDiameter = 0;
        diameterNodes = new HashSet<>();
        dfs(1, -1, 0);
        int A = farthestNode;

        // Step 2: Find the farthest node from A (this gives the diameter)
        maxDiameter = 0;
        diameterNodes.clear();
        dfs(A, -1, 0);
        int B = farthestNode;

        // Step 3: Find the longest path not fully overlapping with the diameter
        maxPath = 0;
        dfsExcludePath(A, -1, 0, B);

        // Final Result: Sum of the longest and second longest paths
        System.out.println(maxDiameter + maxPath);
    }

    // DFS to find the farthest node and diameter
    static void dfs(int node, int parent, int dist) {
        if (dist > maxDiameter) {
            maxDiameter = dist;
            farthestNode = node;
        }
        
        diameterNodes.add(node); // Store nodes in the diameter path

        for (int nextNode : graph.get(node)) {
            if (nextNode != parent) {
                dfs(nextNode, node, dist + 1);
            }
        }
    }

    // DFS to find the longest path that doesn't fully overlap with the diameter
    static void dfsExcludePath(int node, int parent, int dist, int exclude) {
        if (dist > maxPath) {
            maxPath = dist;
        }

        for (int nextNode : graph.get(node)) {
            if (nextNode != parent && nextNode != exclude) {
                dfsExcludePath(nextNode, node, dist + 1, exclude);
            }
        }
    }
}
