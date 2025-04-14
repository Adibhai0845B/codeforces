import java.util.*;

public class quuens {
    static List<Integer>[] tree;
    static int[] depth, maxSubtree, parent;
    static int farthestNode, maxDepth;
    static Set<Integer> diameterNodes;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            tree = new ArrayList[n + 1];
            for (int i = 1; i <= n; i++) tree[i] = new ArrayList<>();

            for (int i = 0; i < n - 1; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                tree[u].add(v);
                tree[v].add(u);
            }

            if (n == 1) {
                System.out.println(0);
                continue;
            }

            // Step 1: Find the farthest node from node 1 (This finds one end of the diameter)
            depth = new int[n + 1];
            parent = new int[n + 1];
            maxDepth = -1;
            dfs(1, -1, 0);
            int A = farthestNode;

            // Step 2: Find the farthest node from A (This gives the diameter)
            depth = new int[n + 1];
            parent = new int[n + 1];
            maxDepth = -1;
            dfs(A, -1, 0);
            int B = farthestNode;
            int diameter = maxDepth;

            // Step 3: Find all nodes in the diameter path
            diameterNodes = new HashSet<>();
            int node = B;
            while (node != A) {
                diameterNodes.add(node);
                node = parent[node];
            }
            diameterNodes.add(A);

            // Step 4: Find the deepest subtree outside the diameter
            maxSubtree = new int[n + 1];
            int maxSubtreeHeight = 0;

            for (int i = 1; i <= n; i++) {
                if (!diameterNodes.contains(i)) {
                    maxSubtreeHeight = Math.max(maxSubtreeHeight, computeSubtreeHeight(i, -1));
                }
            }

            // The final height is the diameter + longest subtree outside diameter
            System.out.println(diameter + maxSubtreeHeight);
        }
        sc.close();
    }

    static void dfs(int node, int parentNode, int d) {
        depth[node] = d;
        parent[node] = parentNode;
        if (d > maxDepth) {
            maxDepth = d;
            farthestNode = node;
        }
        for (int child : tree[node]) {
            if (child != parentNode) {
                dfs(child, node, d + 1);
            }
        }
    }

    static int computeSubtreeHeight(int node, int parent) {
        int maxHeight = 0;
        for (int child : tree[node]) {
            if (child != parent) {
                maxHeight = Math.max(maxHeight, computeSubtreeHeight(child, node) + 1);
            }
        }
        return maxSubtree[node] = maxHeight;
    }
}
