import java.util.*;
import java.io.*;
public class dfs {
    static int n, k, d;
    static ArrayList<ArrayList<Pair>> a1;
    static boolean vis[];
    public static void main(String[] args) throws IOException {
        FastInput sc = new FastInput();
        n = sc.nextInt();
        k = sc.nextInt();
        d = sc.nextInt();
        a1 = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            a1.add(new ArrayList<>());
        }
        Queue<Pair> q1 = new LinkedList<>();
      ArrayList<Integer> kc = new ArrayList<>();
      vis= new boolean[n];
        for (int i = 0; i < k; i++) {
            int x = sc.nextInt()-1;
                kc.add(x);
             vis[x] = true;
        }
        for (int i = 0; i <n-1; i++) {
            int u = sc.nextInt()-1;
            int v = sc.nextInt()-1;
a1.get(u).add(new Pair(v,i));       
     a1.get(v).add(new Pair(u,i));
        }
        int ans =0;
        HashSet<Integer> fina = new HashSet<>();
        int par[] = new int[n];
        for(int i =0;i<k;i++){
            int c  =kc.get(i);
            q1.add(new Pair(c,0));
            while(!q1.isEmpty()){
                Pair p = q1.poll();
                int u = p.x;
                int w = p.y;
                if(w>=d) {
                    q1.clear();
                    break;
                }
                for(Pair v:a1.get(u)){
                    int v1 = v.x;
                    int v2 = v.y;
                    if(vis[v1]){
                        ans++;
                        System.out.println(v1+"v1");
                        System.out.println(u+"u");
                        fina.add(v2+1);
                    }
                    else{
                       vis[v1] = true;
                       q1.add(new Pair(v1, w+1));
                    }
                }
            }
        }
        System.out.println(fina.size());
        for(int va:fina){
            System.out.println(va+" ");
        }
        System.out.println();
    }      
}

class Pair {
    int x, y;
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class FastInput {
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