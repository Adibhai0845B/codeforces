import java.util.*;

public class MilitaryProblem {
    static List<Integer>[] tree;
    static List<Integer> sub;
    static int[] start, size;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        tree = new ArrayList[n + 1];
        start = new int[n + 1];
     size = new int[n + 1];
    sub = new ArrayList<>();
        for (int i = 1; i <= n; i++) tree[i] = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            int parent = sc.nextInt();
            tree[parent].add(i);
        }
        for (int i = 1; i <= n; i++) {
            Collections.sort(tree[i]);
        }
        dfs(1);
        StringBuilder answ = new StringBuilder();
        while (q-- > 0) {
            int u = sc.nextInt(); 
            int k = sc.nextInt(); 
            if (size[u] >= k) {
                answ.append(sub.get(start[u] + k - 1)).append("\n");
            } else {
                answ.append("-1\n");
            }
        }
        System.out.print(answ);
        sc.close();
    }

    static void dfs(int node) {
        start[node] = sub.size(); 
           sub.add(node);
        size[node] = 1;
        for (int child : tree[node]) {
            dfs(child);
            size[node] += size[child]; 
                }
    }
}
