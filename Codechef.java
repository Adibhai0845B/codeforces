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
    static List<Integer>[] a1;
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
    int q = sc.nextInt();
    while(q-->0){

    }        }
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

public static boolean isBipartite(int V, ArrayList<ArrayList<Integer>> a1, int color[]) {
        for (int i = 0; i < V; i++) {
            if (color[i] == -1) {
                if (dfsBipartite(i, 0, color, a1) == false)
                    return false;
            }
        }
        return true;
    }
    private static boolean dfsBipartite(int node, int col, int color[], ArrayList<ArrayList<Integer>> a1) {
        color[node] = col;
        for (int it : a1.get(node)) {
            if (color[it] == -1) {
                if (dfsBipartite(it, 1 - col, color, a1) == false)
                    return false;
            } else if (color[it] == col) {
                return false;
            }
        }

        return true;
    }

    public  static int funct2(int uy, ArrayList<ArrayList<Integer>>a1,int[] color, int[] anta,int ev) {
        ArrayList<Integer> cher = new ArrayList<>();
        for (int uyr:a1.get(uy)){int answ = funct2(uyr,a1,color,anta,ev);
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
    int first, second;

    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }

}
