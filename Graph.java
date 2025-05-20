import java.util.*;

public class Graph {
    static int n,m, h;
    static List<List<int[]>> a1;
    static int[] a;
    public static long[] dijkstra(int s) {
      long[][] dis = new long[n + 1][2];
    boolean[][] vis = new boolean[n + 1][2];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dis[i], Long.MAX_VALUE);
        }
      dis[s][a[s]] = 0;
  PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        pq.offer(new long[]{0, s, a[s]});
        while (!pq.isEmpty()) {
     long[] ui = pq.poll();
       int u = (int) ui[1];
      int f = (int) ui[2];
      if(vis[u][f]) continue;
            vis[u][f] = true;
            for (int[] it : a1.get(u)) {
          int v = it[0];
                int w = it[1];
                if (f == 1) w /= 2;
                int f1 = f | a[v];
                if (!vis[v][f1] && dis[u][f] + w < dis[v][f1]) {
                    dis[v][f1] = dis[u][f] + w;
                    pq.offer(new long[]{dis[v][f1], v, f1});
                }
            }
        }
        long[] ans = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            ans[i] = Math.min(dis[i][0],dis[i][1]);
        }
        return ans;
    }  public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
    n = sc.nextInt();
      m = sc.nextInt();
       h = sc.nextInt();
  a1 = new ArrayList<>();
        for (int i = 0; i <= n; i++) a1.add(new ArrayList<>());
        a = new int[n + 1];
        for (int i = 0; i < h; i++) {
           a[sc.nextInt()]=1;
        }
        for(int i = 0; i < m; i++) {
       int u = sc.nextInt();
 int v = sc.nextInt();
      int w = sc.nextInt();
   a1.get(u).add(new int[]{v, w});
   a1.get(v).add(new int[]{u, w});
        }
        long[] a1 = dijkstra(1);
        long[] d2 = dijkstra(n);
        long ans = Long.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            ans = Math.min(ans, Math.max(a1[i], d2[i]));
        }
        System.out.println(ans == Long.MAX_VALUE ? -1 : ans);        }
    }
}
