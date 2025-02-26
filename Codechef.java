import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;
import java.math.*;
import static java.lang.System.arraycopy;
import static java.lang.System.nanoTime;
import static java.lang.System.out;
  public class Codechef{
    private int V;
    private LinkedList<Integer>[] adj;
    static final int see = 400005;
    List<Integer> ranfirst = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    static final long INF = (long) 1e18;
    static final int MOD =  (int)998244353;
    static final int N = (int) 2e5 + 5;
    static int[] a12 = new int[N + 1];
    static int[] b12 = new int[N + 1];
    public Codechef(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList<>();
        } 
    public static void main(String[] args) throws IOException {
        FastInput sc = new FastInput();
     int t = 1;
     ////int t = sc.nextInt();
        while (t-- > 0) {
          funct(sc);
        }
        sc.close();
    }
    public static void funct(FastInput sc) throws IOException{
        int n=sc.nextInt();
        int q =sc.nextInt();
        ArrayList<ArrayList<Integer>>a1 = new ArrayList<>();
       for(int i =0;i<=n;i++) a1.add(new ArrayList<>());
        for(int i =1;i<=n-1;i++){
            int u = i+1;
            int v = sc.nextInt();
            a1.get(u).add(v);
            a1.get(v).add(u);
          }
          while(q-->0){
         int u =sc.nextInt();
         int k = sc.nextInt();
       ArrayList<Integer> h1 = new ArrayList<>();
         boolean vis[] = new boolean [n+1];
         dfs(u,a1,h1,vis,k);
         System.out.println(h1);
         if(h1.size()>=k){
       System.out.println(h1.get(k-1));
         }
         else{
            System.out.println("-1");
         }
          }
    }
    public static void dfs(int node,ArrayList<ArrayList<Integer>>a1,ArrayList<Integer> h1,boolean vis[],int k){
        vis[node]=true;
        for(int it:a1.get(node)){
            if(!vis[it]){
                h1.add(it);
                if(h1.size()==k) return;
                dfs(it,a1,h1,vis,k);
            }
        }
    }
   public static long modInverse(long a, long mod) {
        return powerMod(a, mod - 2, mod);
    }
    public static long powerMod(long base, long exp, long mod) {
        long dotult = 1;
        while (exp > 0) {
            if ((exp & 1) == 1) { 
                dotult = (dotult * base) % mod;
            }
            base = (base * base) % mod;
            exp >>= 1;
        }
        return dotult;
    }
    public static long upperbound1(long[] a, int j, long end, long value) {
        long low = j;
        long high = end;
 
        while (low < high) {
            long mid = (low + high) / 2;
            if (a[(int) mid] <= value) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
    static long count(long x) {
        long cnt = 0;
        char[] s = Long.toString(x).toCharArray();
        int n = s.length;
        for(int i = n - 1; i >= 0; i--) {
            if(s[i] != '0') break;
            cnt++;
        }
        return cnt;
    }
    public static void sieve(int n) {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
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
    public static List<Boolean> segmentedSieve(long L, long R) {
      long limit = (long) Math.sqrt(R);
      boolean[] marfirst = new boolean[(int) limit + 1];
       Arrays.fill(marfirst, false);
    List<Long> primes = new ArrayList<>();
       for (long i = 2; i <= limit; ++i) {
        if (!marfirst[(int) i]) {
              primes.add(i);
          for (long j = i * i; j <= limit; j += i) {
               marfirst[(int) j] = true;
              }
         }
     }
      boolean[] isPrime = new boolean[(int) (R - L + 1)];
      Arrays.fill(isPrime, true);
     for (long prime : primes) {
            long j = Math.max(prime * prime, (L + prime - 1) / prime * prime);
            for (long i = j; j <= R; j += prime) {
                isPrime[(int) (j - L)] = false;
            }
        }
 
        if (L == 1) {
            isPrime[0] = false;
        }
 
        List<Boolean> dotult = new ArrayList<>();
        for (boolean b : isPrime) {
            dotult.add(b);
        }
 
        return dotult;
    }
 
    public static boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        return (n & (n - 1)) == 0;
    }
 
    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        if (n <= 3) {
            return true;
        }
        if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }
 
    public static long gcd(long a, long b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }
 
    public static long lcm(long x, long y) {
        return (x / gcd(x, y)) * y;
    }
 
    public static void sort(int[] a) {
        Arrays.sort(a);
    }
 
    public static HashMap<Integer, Integer> hashh1(int[] a) {
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
            if (!visited[n])
                DFSUtil(n, visited);
        }
    }
 
    public void DFS(int jVertex) {
        boolean[] visited = new boolean[V];
        DFSUtil(jVertex, visited);
    }
 
    public void bFS(int jVertex) {
        boolean[] visited = new boolean[V];
        LinkedList<Integer> queue = new LinkedList<>();
        visited[jVertex] = true;
        queue.add(jVertex);
 
        while (!queue.isEmpty()) {
            jVertex = queue.poll();
            System.out.print(jVertex + " ");
            for (int n : adj[jVertex]) {
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }
 
    public static long lowerbound(long[] a, long target) {
        int low = 0, high = a.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (a[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
 
    public static long upperbound(Long[] a, long target) {
        int left = 0;
        int right = a.length;
        long dotult = -1;
 
        while (left < right) {
            int mid = left + (right - left) / 2;
 
            if (a[mid] <= target) {
                dotult = a[mid];
                left = mid + 1;
            } else {
                right = mid;
            }
        }
 
        return dotult;
    }
 
    public static int binarySearch(int[] a, int j, int end, int target) {
        while (j <= end) {
            int mid = j + (end - j) / 2;
            if (a[mid] == target) {
                return mid;
            }
            if (a[mid] < target) {
                j = mid + 1;
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
}
class Pair3 {
    int first, second, third;
    
    Pair3(int first, int second, int third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }
}
class Pair5 {
        int first, second, steps, consecutive, dir;
        Pair5(int first, int second, int steps, int consecutive, int dir) {
            this.first = first;
            this.second = second;
            this.steps = steps;
            this.consecutive = consecutive;
            this.dir = dir;
        }
    }
    class Pair implements Comparable<Pair> {
        int first;
        int second;
    
        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    
        @Override
        public int compareTo(Pair other) {
            return Integer.compare(this.second, other.second);
        }
    }
    