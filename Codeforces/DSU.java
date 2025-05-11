import java.util.*;
import java.io.*;
public class DSU {
    private int[] parent, rank, size;
    private int n, components;
    public DSU(int n) {
        this.n = n;
        parent = new int[n];
        rank = new int[n];
        size = new int[n];
        components = n;

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }
    public int find(int x) {
        if (parent[x] != x)
            parent[x] = find(parent[x]);
        return parent[x];
    }

    public boolean union(int x, int y) {
        int px = find(x), py = find(y);
        if (px == py) return false;

        if (rank[px] < rank[py]) {
            parent[px] = py;
            size[py] += size[px];
        } else if (rank[px] > rank[py]) {
            parent[py] = px;
            size[px] += size[py];
        } else {
            parent[py] = px;
            rank[px]++;
            size[px] += size[py];
        }
        components--;
        return true;
    }
    public int getComponentCount() {
        return components;
    }
    public void printComponentMembers() {
        Map<Integer, List<Integer>> componentMap = new HashMap<>();
            for (int i = 0; i < n; i++) {
            int root = find(i);
            componentMap.computeIfAbsent(root, k -> new ArrayList<>()).add(i + 1);
        }
            PriorityQueue<List<Integer>> sortedComponents = new PriorityQueue<>(Comparator.comparingInt(List::size));
        for (List<Integer> component : componentMap.values()) {
            Collections.sort(component);
            sortedComponents.offer(component);
        }
            while (!sortedComponents.isEmpty()) {
              System.out.print(sortedComponents.size()+" ");
            for (int node : sortedComponents.poll()) {
                System.out.print(node + " ");
            }
            System.out.println();
        }
    }
        public static void main(String args[]) throws IOException {
        FastInput sc = new FastInput();
       int n = sc.nextInt();
       int m = sc.nextInt();
       int a[][] = new int[m][3];
       for(int i =0;i<m;i++){
        a[i][0] = sc.nextInt()-1;
        a[i][1] = sc.nextInt()-1;
        a[i][2] = sc.nextInt();
       }
       Arrays.sort(a,Comparator.comparingInt(o->o[2]));
       long answ =0;
       DSU d1 = new DSU(n);
       for(int i =0;i<m;i++){
        if(d1.find(a[i][0])!=d1.find(a[i][1])){
                d1.union(a[i][0], a[i][1]);
           answ+=a[i][2];
            }
       }
       for(int i =0;i<n;i++){
        if(d1.getComponentCount()>1){
            System.out.println("IMPOSSIBLE");
        return;
        }
       }
       System.out.println(answ);
    }
    }
 class FastInput{
    BufferedReader br;
    StringTokenizer st;
    public FastInput() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    String next() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine());
        }
        return st.nextToken();
    }

    int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }

    String nextLine() throws IOException {
        return br.readLine();
    }

    public void close() throws IOException {
        br.close();
    }
}