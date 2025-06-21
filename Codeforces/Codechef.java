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
   static final int max=(int)1e9 + 5;
    static final int MOD =998244353;
    static ArrayList<Integer>viol;
        static final long MAX = (long) 4e18;
    static int[] color;
    public static void main(String[] args)throws IOException {
        FastInput sc = new FastInput();
          int t = sc.nextInt();
        //  int t = 1;
            while (t-- > 0) {
          func(sc);
        }
    sc.close();
    }
    public static void func(FastInput sc)throws IOException{
   int a[] = new int[4];
   for(int i =0;i<4;i++){
     a[i] = sc.nextInt();
   }
        boolean cond1 = (a[0]<a[3]&&a[1]<=a[2]);
        boolean cond2 = (a[0]>=a[3]&&a[1]<=a[2]);
        boolean cond3 = (a[0]<a[3]&& a[1]>=a[2]+1);
        boolean cond4 = (a[3]<=a[2]);
        if(cond1){
            System.out.println(a[1]<=a[0]?"Gellyfish" : "Flower");
        } 
        else if (cond2) {
            System.out.println("Gellyfish");
        } 
        else if (cond3) {
            System.out.println("Flower");
        } 
        else {
            System.out.println(cond4 ? "Gellyfish" : "Flower");
        }

    }
public static int dfs(int p,int a[][],String s){
        if(a[p][0]==0&&a[p][1]==0)return 0;
     int res=1000000;
        if(a[p][0]!=0){
            res = Math.min(res,dfs(a[p][0],a,s)+((s.charAt(p-1)=='L')?0:1));
        }
        if(a[p][1]!=0){
            res =Math.min(res,dfs(a[p][1],a,s)+((s.charAt(p-1)=='R')?0:1));
        }
     return res;
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
    public static long modex(long x, long y, int m) {
        long val = 1;
        x %= m;
        while (y > 0) {
            if ((y & 1) == 1)
                val=(val*x) % m;
            y >>= 1;
            x = (x*x) % m;
        }
        return val;
    } 
    private static boolean dfsBipartite(int node, int col, int color[], ArrayList<ArrayList<Integer>> a) {
        color[node] = col;
        for (int it : a.get(node)) {
            if (color[it] == -1) {
                if (dfsBipartite(it, 1 - col, color, a) == false)
                    return false;
            } else if (color[it] == col) {
            viol.add(node);
                viol.add(it);
                return false;
            }
        }

        return true;
    }
    public static List<List<Integer>> graphcomplementbfs(int n,List<List<Integer>> adj) {
        List<List<Integer>> complement = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            complement.add(new ArrayList<>());
        }
            boolean[] visited = new boolean[n];
        for (int start = 0; start < n; start++) {
            if (visited[start]) continue;
    
            Queue<Integer> queue = new LinkedList<>();
            queue.add(start);
            visited[start] = true;
    
            while (!queue.isEmpty()) {
                int node = queue.poll();
                    for (int i = 0; i < n; i++) {
                    if (i != node && !visited[i] && !adj.get(node).contains(i)) {
                        complement.get(node).add(i);
                        complement.get(i).add(node); 
                        visited[i] = true;
                        queue.add(i);
                    }
                }
            }
        }
    
        return complement;
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
    public  static int funct2(int uy, ArrayList<ArrayList<Integer>>a,int[] color, int[] anta,int ev) {
        ArrayList<Integer> cher = new ArrayList<>();
        for (int uyr:a.get(uy)){int countw = funct2(uyr,a,color,anta,ev);
            if (countw != -1) {
                cher.add(countw);
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
        String line = br.readLine();
        if (line == null) return null; 
        st = new StringTokenizer(line);
    }
    return st.nextToken();
}



       int nextInt() throws IOException {
    String token = next();
    if (token == null) throw new NoSuchElementException("No more tokens available");
    return Integer.parseInt(token);
}


       long nextLong() throws IOException {
    String token = next();
    if (token == null) throw new NoSuchElementException("No more tokens available");
    return Long.parseLong(token);
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