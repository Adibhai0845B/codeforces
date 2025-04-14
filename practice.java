import java.util.*;

public class practice{
	static int n, m, ans, a1[];
	static ArrayList<Integer>[] adj;
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		a1 = new int[n];
		adj = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			a1[i] = sc.nextInt();	adj[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < n - 1; i++) {
			int u = sc.nextInt() - 1;int v = sc.nextInt() - 1;
			adj[v].add(u);adj[u].add(v);
		}ans = 0;
		dfs(0, 0, 0);
		System.out.print(ans);
	}
public static void dfs(int node, int parent, int conse) {
		conse = a1[node] == 1 ? conse + 1 : 0;
		if (conse > m)
			return;
		boolean seepare = true;
		for (int neigh : adj[node])
			if (neigh != parent) {
				dfs(neigh, node, conse);
				seepare = false;
			}
		if (seepare)
			ans++;
	}

}