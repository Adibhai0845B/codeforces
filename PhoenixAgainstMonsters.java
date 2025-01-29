/*import java.util.*;
class Pair implements Comparable<Pair> {
    int x;
    int y; 
    boolean halved;

    Pair(int _x, int _y, boolean _halved) {
        this.x = _x;
        this.y = _y;
        this.halved = _halved;
    }

    @Override
    public int compareTo(Pair p) {
        return this.y - p.y;
    }
}
public class ForeverWinter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt(); 
        ArrayList<ArrayList<Pair>> a1 = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            a1.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            a1.get(u - 1).add(new Pair(v - 1, w, false));
            a1.get(v - 1).add(new Pair(u - 1, w, false));
        }
        int[][] dist = new int[n][2];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        dist[0][0] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, 0, false));
        while (!pq.isEmpty()) {
            Pair node = pq.poll();
            int u = node.x;
            int currentDist = node.y;
            boolean halved = node.halved;

            // Check if we have a better path already
            if (currentDist > dist[u][halved ? 1 : 0]) continue;

            // Traverse adjacent nodes
            for (Pair it : a1.get(u)) {
                int v = it.x;
                int weight = it.y;

                // Case 1: Not using the halving option
                if (dist[u][halved ? 1 : 0] + weight < dist[v][halved ? 1 : 0]) {
                    dist[v][halved ? 1 : 0] = dist[u][halved ? 1 : 0] + weight;
                    pq.add(new Pair(v, dist[v][halved ? 1 : 0], halved));
                }

                // Case 2: Using the halving option (only if not already used)
                if (!halved && dist[u][0] + (weight / 2) < dist[v][1]) {
                    dist[v][1] = dist[u][0] + (weight / 2);
                    pq.add(new Pair(v, dist[v][1], true)); // Now halving is used
                }
            }
        }

        // Find the shortest path to the destination node `n-1`
        int result = Math.min(dist[n - 1][0], dist[n - 1][1]);
        if (result == Integer.MAX_VALUE) {
            System.out.println("No path to destination");
        } else {
            System.out.println(result);
         }
    }
}
*/
import java.util.*;

class Edge {
    int to, monsters;

    Edge(int to, int monsters) {
        this.to = to;
        this.monsters = monsters;
    }
}

public class PhoenixAgainstMonsters {
    static final long INF = Long.MAX_VALUE;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt(); 

        List<Edge>[] graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            int w = scanner.nextInt();
            graph[u].add(new Edge(v, w));
        }
        long[][] dist = new long[n + 1][2];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(dist[i], INF);
        }
        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[1]));
        pq.offer(new long[]{1, 0, 0});
        dist[1][0] = 0;

        while (!pq.isEmpty()) {
            long[] curr = pq.poll();
            int city = (int) curr[0];
            long monsters = curr[1];
            int abilityUsed = (int) curr[2];

            if (monsters > dist[city][abilityUsed]) continue;
            for (Edge edge : graph[city]) {
                int nextCity = edge.to;
                long nextMonsters = monsters + edge.monsters;
                if (nextMonsters < dist[nextCity][abilityUsed]) {
                    dist[nextCity][abilityUsed] = nextMonsters;
                    pq.offer(new long[]{nextCity, nextMonsters, abilityUsed});
                }
                if (abilityUsed == 0) {
                    long reducedMonsters = monsters + edge.monsters / 2;
                    if (reducedMonsters < dist[nextCity][1]) {
                        dist[nextCity][1] = reducedMonsters;
                        pq.offer(new long[]{nextCity, reducedMonsters, 1});
                    }
                    for (Edge edge2 : graph[edge.to]) {
                        int nextCity2 = edge2.to;
                        long combinedMonsters = monsters + (edge.monsters + edge2.monsters) / 2;
                        if (combinedMonsters < dist[nextCity2][1]) {
                            dist[nextCity2][1] = combinedMonsters;
                            pq.offer(new long[]{nextCity2, combinedMonsters, 1});
                        }
                    }
                }
            }
        }
        long result = Math.min(dist[n][0], dist[n][1]);
        System.out.println(result);
    }
}
