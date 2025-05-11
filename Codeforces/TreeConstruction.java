import java.io.*;
import java.util.*;

public class TreeConstruction {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine()); // Number of test cases
        while (t-- > 0) {
            String[] inputs = br.readLine().split(" ");
            int n = Integer.parseInt(inputs[0]);
            int d = Integer.parseInt(inputs[1]);
            int l = Integer.parseInt(inputs[2]);

            // Check if it's impossible to construct the tree
            if (l > n || l == 1 || d < l - 1 || d > n - 1) {
                sb.append("-1\n");
                continue;
            }

            List<int[]> edges = new ArrayList<>();
            int[] degree = new int[n + 1];
            int currentNode = 1;

            // Create the main path of length d
            for (int i = 0; i < d; i++) {
                edges.add(new int[]{currentNode, currentNode + 1});
                degree[currentNode]++;
                degree[currentNode + 1]++;
                currentNode++;
            }

            int remainingLeaves = l; // Number of leaves needed
            // Deduct leaves already on the main path
            if (degree[1] == 1) remainingLeaves--;
            if (degree[d + 1] == 1) remainingLeaves--;

            // Add leaves to intermediate nodes
            for (int i = 1; i <= d && remainingLeaves > 0; i++) {
                while (degree[i] < 2 && remainingLeaves > 0 && currentNode < n) {
                    edges.add(new int[]{i, ++currentNode});
                    degree[i]++;
                    degree[currentNode]++;
                    remainingLeaves--;
                }
            }

            // If leaves are not fulfilled, attach to the root
            for (int i = d + 2; i <= n && remainingLeaves > 0; i++) {
                edges.add(new int[]{1, i});
                degree[1]++;
                degree[i]++;
                remainingLeaves--;
            }

            if (edges.size() != n - 1 || remainingLeaves > 0) {
                sb.append("-1\n");
            } else {
                for (int[] edge : edges) {
                    sb.append(edge[0]).append(" ").append(edge[1]).append("\n");
                }
            }
        }

        System.out.print(sb.toString());
    }
}
