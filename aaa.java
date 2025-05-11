import java.io.IOException;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;
import java.util.function.BiConsumer;
import java.math.*;
import static java.lang.System.console;
import static java.lang.System.nanoTime;
import static java.lang.System.out;

public class aaa {

   static ArrayList<ArrayList<Integer>>a1;
   static int n;
   static int k;
   static boolean vis[];
   static int temp;
    public static void main(String[] args)throws IOException{
        FastInput sc = new FastInput();
        int t = sc.nextInt();
        while(t-->0){
            funct(sc);
        }
    }
    public static void funct(FastInput sc)throws IOException{
          n  = sc.nextInt();
         a1 = new ArrayList<>();
         vis = new boolean [n];
         for(int i =0;i<n;i++){
            a1.add(new ArrayList<>());
         }
          k = sc.nextInt();
         for(int i =0;i<n-1;i++){
            int u =sc.nextInt()-1;
            int v = sc.nextInt()-1;
            a1.get(u).add(v);
            a1.get(v).add(u);
   }
         temp = 0;
      ArrayList<Integer> leaf = new ArrayList<>();
      for(int i =0;i<n;i++){
        if(a1.get(i).size()<=1){
        leaf.add(i);
        }
      }
 Arrays.fill(vis,false);
      for(int jh:leaf){
        temp=1;
        vis[jh]=true; 
           dfs(jh);
      }
      int count =0;
      for(int i =0;i<n;i++){
        if(!vis[i]){
            count++;
        }
    }
    System.out.println(count);
    }
    public static void dfs(int node){
        if(temp==k){
            return;
        }
    for(int gh:a1.get(node)){
        if(!vis[gh]){
        vis[gh]=true;
        temp++;
        dfs(gh);
  }
    }
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
