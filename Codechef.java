/*
 * AdiBhai0845R
 * AdiBhai0845R
 * AdiBhai0845R
 * AdiBhai0845R
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;
import java.util.function.BiConsumer;
import java.math.*;
import static java.lang.System.console;
import static java.lang.System.nanoTime;
import static java.lang.System.out;
 public class Codechef{
    private int V;
    static long e,v;
    static final int MAXN = 200005;
    static final int MOD =998244353;
    static int ans =0;
    static final int see = 400005;
    List<Integer> ranfirst = new ArrayList<>();
    static double tr = 0;
    List<Integer> pare = new ArrayList<>();
    static final long INF = (long) 1e18;
    static final int max = (int) 1e7 + 10;
    static final int N = (int) 2e5 + 5;
    static List<Integer>[] a;
    static int[] tree2;
    static int[] color;
    static int n;
    public static void main(String[] args) throws IOException {
        FastInput sc = new FastInput();
          int t = sc.nextInt();
        //  int t = 1;
            while (t-- > 0) {
          func(sc);
        }
    sc.close();
  }
public static void func(FastInput sc) throws IOException{
    int n = sc.nextInt();
    int m = sc.nextInt();
    char[][] a = new char[n][n];
    for (int i = 0; i < n; i++) {
        a[i]=sc.next().toCharArray();
    }
    boolean ans=false;
    int ax=1;
    int ay=2;
    for (int i = 0; i < n; i++) {
        for (int j = i + 1; j < n; j++) {
            if (a[i][j]==a[j][i]) {
                ans=true;
        ax=i+1;
          ay=j+1;
            }
        }
    }
    if(ans||m%2==1) {
        out.println("YES");
        for (int i=0;i<m;i++) {
      if (i%2==0){
          out.print(ax + " ");
           }else{
         out.print(ay + " ");
  }
    }
        if (m % 2 == 0)
            out.println(ax);
        else
            out.println(ay);
       return;
        }
    int aax = 0, aay = 0, aaz = 0;
    int[] have = new int[n + 1];
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (i != j && a[i][j] == 'a') {
                have[i + 1] = j + 1;
            }
        }
    }
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (i == j) continue;
            if (a[i][j] == 'a' && have[j + 1] != 0) {
                aax = i + 1;
                aay = j + 1;
                aaz = have[j + 1];
            }
        }
    }
    if (aax == 0) {
        out.println("NO");
    } else {
        out.println("YES");
        if (m != 2) {
            if ((m / 2) % 2 == 1) {
                int tmp = aax;
                aax = aay;
                aay = tmp;
            }
            out.print(aay);
            for (int i = 1; i <= m / 2; i++) {
                if (i % 2 == 1)
                    out.print(" " + aax);
                else
                    out.print(" " + aay);
            }

            if ((m / 2) % 2 == 1) {
                int tmp = aax;
                aax = aay;
                aay = tmp;
            }
            for (int i = 1; i <= m / 2; i++) {
                if (i%2==1){
                    System.out.print(" " + aaz);
                  }  else{
                    System.out.print(" " + aay);
                  }}
            out.println();
        } else {
            out.println(aax + " " + aay + " " + aaz);
        }
    }
}
    public static boolean isPowerOf2(int n){
        return n > 0 && (n & (n - 1)) == 0;
    }
    public static void dfs(int node, ArrayList<ArrayList<Pair>> adj, boolean[] visited, int[] a, int prev, int index) {
    visited[node] = true;

    if (index != -1) {
        if (a[index] == -1) {
            a[index] = prev;
        }
    }

    int nextPrev = (prev == 2) ? 3 : 2;

    for (Pair nei : adj.get(node)) {
        if (!visited[nei.first]) {
            dfs(nei.first, adj, visited, a, nextPrev, nei.second);
        }
    }
}

public static boolean isPrime(int n) {
    if (n <= 1) return false;
    if (n == 2 || n == 3) return true;
    if (n % 2 == 0 || n % 3 == 0) return false;
    for (int i = 5; i * i <= n; i += 6) {
        if (n % i == 0 || n % (i + 2) == 0)
            return false;
    }
    return true;
}
public static boolean isBipartite(int V, ArrayList<ArrayList<Integer>> a, int color[]) {
        for (int i = 0; i < V; i++) {
            if (color[i] == -1) {
                if (dfsBipartite(i, 0, color, a) == false)
                    return false;
            }
        }
        return true;
    }
    public static long nCr(int n, int r) {
        if (r > n) return 0;
        if (r == 0 || r == n) return 1;
        r = Math.min(r, n - r);
        long result = 1;
        for (int i = 0; i < r; i++) {
            result *= (n - i);
            result /= (i + 1);
        }
        return result;
    }
    private static boolean dfsBipartite(int node, int col, int color[], ArrayList<ArrayList<Integer>> a) {
        color[node] = col;
        for (int it : a.get(node)) {
            if (color[it] == -1) {
                if (dfsBipartite(it, 1 - col, color, a) == false)
                    return false;
            } else if (color[it] == col) {
                return false;
            }
        }

        return true;
    }

    public  static int funct2(int uy, ArrayList<ArrayList<Integer>>a,int[] color, int[] anta,int ev) {
        ArrayList<Integer> cher = new ArrayList<>();
        for (int uyr:a.get(uy)){int answ = funct2(uyr,a,color,anta,ev);
            if (answ != -1) {
                cher.add(answ);
            }
        }
        ev++;
        for (int i=cher.size()-1;i>0;i-=2) {
            int dt = cher.get(i);
      int dt2 = cher.get(i - 1);
      if(ev%2==0){
      color[dt]=color[dt2]=anta[0]++;
      ev++;
        }        
        else{
            color[dt]=color[dt2]=anta[0]--;
        ev++;
        }
        ev++;
    } 
        if (uy != 0) {
            if (cher.isEmpty()) {
                return uy;
            }
            if(ev%2==0){
            color[uy] = color[cher.get(0)] = anta[0]++;
            ev++;
            }
            else{
                color[uy] = color[cher.get(0)] = anta[0]--;
            
            ev++;}
            ev++;
            return -1;
        }
        if (!cher.isEmpty()) {
            if(ev%2==0){
            color[uy] = color[cher.get(0)] = anta[0]++;
        }
        else{
            color[uy] = color[cher.get(0)] = anta[0]--;
        }
        ev++;
    }
        return -1;        
    }
    public static long upperbound1(long[] a, int j, long end, long vseare) {
        long low = j;
        long high = end;

        while (low < high) {
            long mid = (low + high) / 2;
            if (a[(int) mid] <= vseare) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
    public static boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        return (n & (n - 1)) == 0;
    }

  /*   public static boolean isPrime(int n) {
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
*/
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

    public static long lowerbound(long[] a, long vsear) {
        int low = 0, high = a.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (a[mid] < vsear) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    public static long upperbound(Long[] a, long vsear) {
        int left = 0;
        int right = a.length;
        long dotult = -1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (a[mid] <= vsear) {
                dotult = a[mid];
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return dotult;
    }

    public static int binarySearch(int[] a, int j, int end, int vsear) {
        while (j <= end) {
            int mid = j + (end - j) / 2;
            if (a[mid] == vsear) {
                return mid;
            }
            if (a[mid] < vsear) {
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

    Pair3(int first, int second,int third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }
}
class Pair4 {
    int first, second, third, fourth;
    Pair4(int first, int second,int third,int fourth){
        this.first = first;
        this.second = second;
        this.third = third;
        this.fourth  = fourth;
    }
}
class Pair {
    int first;
    int second;
    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
