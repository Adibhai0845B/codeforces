import java.util.*;
public class a1lea {
    static List<List<Integer>> a1 = new ArrayList<>();
    static List<Integer> lea = new ArrayList<>();
    static void bfs(int root, int n) {
        int[] depth = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> q1 = new LinkedList<>();
        q1.add(root);
        visited[root] = true;
        while (!q1.isEmpty()) {
            int node = q1.poll();
            boolean is = true;
            for (int it : a1.get(node)) {
                if (!visited[it]) {
                    visited[it] = true;
                    depth[it] = depth[node] + 1;
                    q1.add(it);
                    is = false;
                }
            }
                if (is && node != root) {
                lea.add(depth[node]);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
        int n = sc.nextInt();
        for (int i = 0; i <= n; i++) {
            a1.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            a1.get(u).add(v);
            a1.get(v).add(u);
        }
        bfs(1, n);
      //  System.out.println(lea);
      long min =Long.MAX_VALUE;
    Collections.sort(lea);
        for(int i = lea.size();i>=0;i--){

        }
}
}
}
