import java.util.*;

public class MonodogDayOut {
    static final int MOD = 1_000_000_007;
    static int n, m;
    static long[] x, y;
    static List<Integer>[] graph;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        x = new long[n + 1];
        y = new long[n + 1];
        graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
            x[i] = sc.nextLong();
            y[i] = sc.nextLong();
        }

        // Read edges
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph[u].add(v);
            graph[v].add(u);
        }

        // Read number of queries
        int q = sc.nextInt();

        while (q-- > 0) {
            int t = sc.nextInt();
            int u = sc.nextInt();

            if (t == 1 || t == 2) {
                applyReflection(u, t == 1);
            } else if (t == 3) {
                findMaxDistancePark(u);
            }
        }

        sc.close();
    }

    private static void applyReflection(int u, boolean ascending) {
        List<Integer> neighbors = new ArrayList<>(graph[u]);
        if (ascending) {
            Collections.sort(neighbors);
        } else {
            Collections.sort(neighbors, Collections.reverseOrder());
        }

        long newX = x[u], newY = y[u];
        for (int v : neighbors) {
            long sum = x[v] + y[v];
            long tempX = sum - newY;
            long tempY = sum - newX;
            newX = mod(tempX);
            newY = mod(tempY);
        }

        x[u] = newX;
        y[u] = newY;
    }

    private static void findMaxDistancePark(int u) {
        int bestPark = u;
        long bestDist = 0, bestX = x[u], bestY = y[u];

        for (int v : graph[u]) {
            long dist = Math.abs(x[u] - x[v]) + Math.abs(y[u] - y[v]);
            if (dist > bestDist || (dist == bestDist && v > bestPark)) {
                bestDist = dist;
                bestPark = v;
                bestX = x[v];
                bestY = y[v];
            }
        }

        System.out.println(bestPark + " " + bestX + " " + bestY);
    }

    private static long mod(long val) {
        return ((val % MOD) + MOD) % MOD;
    }
}
