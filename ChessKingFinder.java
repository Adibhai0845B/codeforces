import java.io.*;
import java.util.*;

public class ChessKingFinder {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(System.out);

    static int query(int r, int c) throws IOException {
        out.println("? " + r + " " + c);
        out.flush();
        return Integer.parseInt(br.readLine().trim());
    }
    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine().trim()); // Number of test cases
        while (t-- > 0) {
            String[] input = br.readLine().trim().split(" ");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);

            // First query: the approximate center of the board
            int r1 = (n + 1) / 2, c1 = (m + 1) / 2;
            int d1 = query(r1, c1);

            // Possible king position must be on the square boundary at distance d1 from (r1, c1)
            int r2 = Math.max(1, Math.min(n, r1 - d1)); 
            int c2 = Math.max(1, Math.min(m, c1 - d1));
            int d2 = query(r2, c2);

            // Compute possible king position based on d2
            int kingRow = r2 + d2;
            int kingCol = c2 + d2;

            // Final answer
            out.println("! " + kingRow + " " + kingCol);
            out.flush();
        }
    }
}
