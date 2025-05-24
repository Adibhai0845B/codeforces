import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Jouorney {
  public static void main(String[] args) throws IOException{
FastInput sc = new FastInput();
  int t = sc.nextInt();
   while(t-->0){
    sd(sc);
   }
  }
  public static void sd(FastInput sc)throws IOException{
        List<Integer> a11 = new ArrayList<>();
        int n = sc.nextInt();
        int[] a1 = new int[n + 2];
        int[] a2 = new int[n + 1];
        int[] a3 = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            a1[i] = sc.nextInt();
        }
        for (int i = 1; i <= n; i++) {
            a2[i] = sc.nextInt();
            a3[i] = sc.nextInt();
        }

        int h = 0;
        boolean ff = false;

        for (int i = 1; i <= n; i++) {
            if (a1[i] != -1) {
                h += a1[i];
            } else {
                a11.add(i);
            }

            if (h > a3[i]) {
                ff = true;
            }

            if (!ff && h < a2[i]) {
                int need = a2[i] - h;
                int take = Math.min(need, a11.size());

                for (int j = 0; j < take; j++) {
                    int idx = a11.remove(a11.size() - 1);
                    a1[idx] = 1;
                    h++;
                }

                if (h < a2[i]) {
                    ff = true;
                    continue;
                }
            }

            if (!ff) {
                int nh = a3[i] - h;
                int toZero = a11.size() - nh;
                for (int j = 0; j < toZero; j++) {
                    int idx = a11.remove(a11.size() - 1);
                    a1[idx] = 0;
                }
            }
        }

        for (int i = a11.size() - 1; i >= 0; i--) {
            a1[a11.get(i)] = 0;
        }

        if (ff) {
            System.out.println(-1);
        } else {
            for (int i = 1; i <= n; i++) {
                System.out.print(a1[i] + " ");
            }
            System.out.println();
        }}}
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