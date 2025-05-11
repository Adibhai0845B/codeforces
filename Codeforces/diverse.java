import java.util.*;
import java.io.*;

public class diverse {
    public static void main(String[] args)throws IOException {
        FastInput sc = new FastInput();
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            
        }
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