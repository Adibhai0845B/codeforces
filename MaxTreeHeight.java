import java.util.*;

public class MaxTreeHeight {
    static List<List<Integer>> tree;
    static int maxHeight;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // Number of test cases

        while (t-- > 0) {
            int n = sc.nextInt(); // Number of vertices
            tree = new ArrayList<>(n + 1);
            for (int i = 0; i <= n; i++) {
                tree.add(new ArrayList<>());
            }

            // Read edges and build the tree
            for (int i = 0; i < n - 1; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                tree.get(u).add(v);
                tree.get(v).add(u);
            }

            // Calculate the maximum height after one operation
            maxHeight = 0;
            int[] heights = new int[n + 1];
            dfs(1, -1, heights); // Start DFS from the root (1)

            // Find the two largest heights
            Arrays.sort(heights);
            int max1 = heights[n - 1]; // Longest height
            int max2 = heights[n - 2]; // Second longest height

            // The maximum height after moving a subtree
            int result = max1 + max2 + 1; // +1 for the new root
            System.out.println(result);
        }

        sc.close();
    }

    // DFS to calculate heights of subtrees
    private static int dfs(int node, int parent, int[] heights) {
        int maxHeight = 0;

        for (int neighbor : tree.get(node)) {
            if (neighbor != parent) {
                maxHeight = Math.max(maxHeight, dfs(neighbor, node, heights) + 1);
            }
        }

        heights[node] = maxHeight; // Store the height of the subtree rooted at this node
        return maxHeight;
    }
}