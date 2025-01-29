import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
/*
  AdiBhai0845R
  AdiBhai0845R 
  AdiBhai0845R
  AdiBhai0845R
  */
public class CollidingBalls{
    private int V;
    private LinkedList<Integer>[] adj; 
    static final int top = 400005;
    static final long INF = (long) 1e18;
    static final int MOD = 1000000007;
    public CollidingBalls(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList<>();
    }
    public static void main(String[] args) throws IOException {
        FastInput input = new FastInput();
            functi1(input);
        input.close();
    }
    static void functi1(FastInput sc) throws IOException {
      int n = sc.nextInt();
      int m =sc.nextInt();
      int ar[] = new int[n+1];
      int answ[] = new int[n+1];
      for(int i =0;i<m;i++){
        int a = sc.nextInt();
        int b = sc.nextInt();
        ar[a]++;
        ar[b]++;
      }
      for(int i=1;i<=n;i++){
        answ[ar[i]]++;
      }
       if(answ[1]==0){
        System.out.println("0");
       }
       else{
        long sum =0;
        boolean ans = false;
        for(int i =n;i>=1;i--){
        if(!ans){
            if(answ[i]>0){
               if(answ[i]==1){}
               else sum++;
            ans = true;
        }
        }
        else{
            if(answ[i]>0){
                sum++;
        }
       }
    }
    System.out.println(sum);
    }
}
    public static void sieve(int n) {
        boolean[] isPrime = new boolean[n + 1];
        for (int i = 0; i <= n; i++) isPrime[i] = true;
        for (int p = 2; p * p <= n; p++) {
            if (isPrime[p]) {
                for (int multiple = p * p; multiple <= n; multiple += p) {
                    isPrime[multiple] = false;
                }
            }
        }
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                System.out.print(i + " ");
            }
        }
    }
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    public static int lcm(int x, int y) {
        return (x / gcd(x, y)) * y;
    }
    public static void sort(int a[]) {
        Arrays.sort(a);
    }

    public static int completeBinarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                return mid;
            }
            if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static HashMap<Integer, Integer> hashmap(int a[]) {
        HashMap<Integer, Integer> h1 = new HashMap<>();
        for (int i : a) {
            h1.put(i, h1.getOrDefault(i, 0) + 1);
        }
        return h1;
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    private void DFSUtil(int v, boolean[] visited) {
        visited[v] = true;
        System.out.print(v + " ");
        for (int n : adj[v]) {
            if (!visited[n]) DFSUtil(n, visited);
        }
    }

    public void DFS(int startVertex) {
        boolean[] visited = new boolean[V];
        DFSUtil(startVertex, visited);
    }

    public boolean[] BFS(int startVertex) {
        boolean[] visited = new boolean[V];
        LinkedList<Integer> queue = new LinkedList<>();
        visited[startVertex] = true;
        queue.add(startVertex);

        while (!queue.isEmpty()) {
            startVertex = queue.poll();
            System.out.print(startVertex + " ");
            for (int n : adj[startVertex]) {
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
        return visited;
    } 
    public static int binarySearch(int[] arr, int start, int end, int target) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    static class FastInput {
        BufferedReader br;
        StringTokenizer st;

        public FastInput() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() throws IOException {
            while (st == null || !st.hasMoreElements()) {
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
}
