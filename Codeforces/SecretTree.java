import java.util.*;
public class SecretTree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] parent = new int[n + 1];
            Arrays.fill(parent, -1);
            parent[1] = 0;
            for (int i = 2; i <= n; i++) {
                System.out.println("? " + 1 + " " + i);
                System.out.flush();
                int x = sc.nextInt();
                parent[i] = x;
            }
            List<int[]> edges = new ArrayList<>();
            for (int i = 2; i <= n; i++) {
                edges.add(new int[]{i, parent[i]});
            }
            System.out.print("!");
            for (int[] edge : edges) {
               System.out.print(" " + edge[0] + " " + edge[1]);
            }
            System.out.println();
            System.out.flush();
        }
        sc.close();
    }
}
