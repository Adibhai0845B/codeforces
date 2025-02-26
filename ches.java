import java.util.*;

class ches {
    private int V; 
    private List<List<Integer>> adj;

    public ches(int V) {
        this.V = V;
        adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u); 
    }
    private boolean isCyclicUtil(int v, boolean[] visited, int parent) {
        visited[v] = true;
        for (int neighbor : adj.get(v)) {
            if (!visited[neighbor]) { 
                if (isCyclicUtil(neighbor, visited, v)) {
                    return true;
                }
            } else if (neighbor != parent) { 
                return true; 
            }
        }
        return false;
    }
    public boolean isCyclic() {
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (isCyclicUtil(i, visited, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
       
        ches graph = new ches(n);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 1); // This edge creates a cycle
        
        if (graph.isCyclic()) {
            System.out.println("Graph contains a cycle");
        } else {
            System.out.println("Graph does not contain a cycle");
        }
    }
}
