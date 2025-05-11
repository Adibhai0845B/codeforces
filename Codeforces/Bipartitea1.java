import java.util.*;

public class Bipartitea1 {
    static class Graph {
        int V;
        List<List<Integer>> adj;
        Graph(int V) {
            this.V = V;
            adj = new ArrayList<>();
            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }
        }

        void addEdge(int u, int v) {
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
    }
    static int[] color, par;
    static List<Integer> cycle = new ArrayList<>();
    static boolean dfsbipart(Graph graph, int u, int c) {
        color[u] = c;
        for (int v : graph.adj.get(u)) {
            if (color[v] == -1) {
                par[v] = u;
                if (dfsbipart(graph, v, 1 - c)) {
                    return true;
                }
            } else if (color[v] == color[u]) {
                cr(u, v);
                return true;
            }
        }
        return false;
    }
    static void cr(int u, int v) {
        List<Integer> pathU = new ArrayList<>();
        List<Integer> pathV = new ArrayList<>();

        while (u != v) {
            pathU.add(u);
            u = par[u];
            pathV.add(v);
            v = par[v];
        }
        pathU.add(u);
        Collections.reverse(pathV);

        cycle.addAll(pathU);
        cycle.addAll(pathV);
    }

    static boolean bipart(Graph graph) {
        int n = graph.V;
        color = new int[n];
        par = new int[n];
        Arrays.fill(color, -1);
        Arrays.fill(par, -1);

        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {
                if (dfsbipart(graph, i, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
        int n = sc.nextInt();
        int m = sc.nextInt();
        HashSet<Integer>[] originalAdj = new HashSet[n];
        for (int i = 0; i < n; i++) {
            originalAdj[i] = new HashSet<>();
        }
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            originalAdj[u].add(v);
            originalAdj[v].add(u);
        }
        Graph a1 = new Graph(n);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (!originalAdj[i].contains(j)) {
                    a1.addEdge(i, j);
                }
            }
        }
        if (bipart(a1)) {
            for (int node : cycle) {
                System.out.print(node + " ");
            }
            System.out.println();
        } else {
            System.out.println("-1");
        }
    }
}
}
