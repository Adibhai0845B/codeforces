import java.util.*;

public class CountPathsInTree {
    static List<Integer>[] modifiedTree;
    static boolean[] visited;
    static int pathCount = 0;
    static int n; 

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
        n = sc.nextInt();
        modifiedTree = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            modifiedTree[i] = new ArrayList<>();
        }
        List<Integer>[] originalTree = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            originalTree[i] = new ArrayList<>();
        }

        for (int i = 2; i <= n; i++) {
            int parent = sc.nextInt();
            originalTree[parent].add(i);
        }

        boolean[] connected = new boolean[n + 1];
        connected[1] = true;

        for (int child : originalTree[1]) {
            modifiedTree[1].add(child);
            modifiedTree[child].add(1);
            connected[child] = true;
        }

        for (int i = 2; i <= n; i++) {
            if (!connected[i]) {
                for (int j = 2; j <= n; j++) {
                    if (i != j && !connected[j]) {
                        modifiedTree[i].add(j);
                        modifiedTree[j].add(i);
                        connected[i] = true;
                        connected[j] = true;
                        break;
                    }
                }
            }
        }

        // Count paths from every node using DFS
        visited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(visited, false);
            dfs(i);
        }

        System.out.println("Total Different Paths: " + pathCount);
    }
        sc.close();
    }

    static void dfs(int node) {
        visited[node] = true;
        pathCount++; // Every time we visit a new node, it counts as a path

        for (int neighbor : modifiedTree[node]) {
            if (!visited[neighbor]) {
                dfs(neighbor);
            }
        }

        visited[node] = false; // Backtrack
    }
}
