import java.io.*;
import java.util.*;

public class kouk {
    public static void main(String[] args) throws IOException {
        FastInput sc = new FastInput();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt() - 1;
            }
            int dp[] = new int[n]; 
            Arrays.fill(dp, -1);

            String s = sc.next();
            int ans[] = new int[n];
            Arrays.fill(ans, -1);  
            for (int i = 0; i < n; i++) {
                if (ans[i] != -1) continue;  
                int ct = 0;
                Set<Integer> set = new HashSet<>();
                int index = i;
                while (!set.contains(index)) {
                    set.add(index);
                    if (s.charAt(index) == '0') ct++;
                    index = a[index];
                }
                for (int e : set) ans[e] = ct; 
            }
            for (int i = 0; i < n; i++) {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
        }
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
