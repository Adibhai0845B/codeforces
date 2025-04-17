import java.util.*;
public class aaa {

    ArrayList<ArrayList<Integer>>a1;
    int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            funct(sc);
        }
    }
    public static void funct(Scanner sc){

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
}
