import java.io.*;
import java.util.*;

public class MatrixDifferenceCheck {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // Number of test cases

        while (t-- > 0) {
            // Read n, m, k
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            long[][] a = new long[n][m];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++) {
                    a[i][j] = Long.parseLong(st.nextToken());
                }
            }

            char[][] num = new char[n][m];
            for (int i = 0; i < n; i++) {
                num[i] = br.readLine().toCharArray();
            }

            // Calculate sum0 and sum1
            long sum1 = 0, sum0 = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (num[i][j] == '0') sum0 += a[i][j];
                    else sum1 += a[i][j];
                }
            }

            int newn = n - k + 1;
            int newm = m - k + 1;
            long[][] newa = new long[newn][newm];

            // Prefix sum for '0' and '1' counts
            int[][] prefix0 = new int[n + 1][m + 1];
            int[][] prefix1 = new int[n + 1][m + 1];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    int val0 = (num[i][j] == '0') ? 1 : 0;
                    int val1 = (num[i][j] == '1') ? 1 : 0;

                    prefix0[i + 1][j + 1] = val0 + prefix0[i][j + 1] + prefix0[i + 1][j] - prefix0[i][j];
                    prefix1[i + 1][j + 1] = val1 + prefix1[i][j + 1] + prefix1[i + 1][j] - prefix1[i][j];
                }
            }

            // Compute newa matrix
            for (int i = 0; i < newn; i++) {
                for (int j = 0; j < newm; j++) {
                    int x1 = i, y1 = j, x2 = i + k - 1, y2 = j + k - 1;

                    int count0 = prefix0[x2 + 1][y2 + 1] - prefix0[x1][y2 + 1] - prefix0[x2 + 1][y1] + prefix0[x1][y1];
                    int count1 = prefix1[x2 + 1][y2 + 1] - prefix1[x1][y2 + 1] - prefix1[x2 + 1][y1] + prefix1[x1][y1];

                    newa[i][j] = Math.abs(count0 - count1);
                }
            }

            // Check condition
            boolean found = false;
            for (int i = 0; i < newn && !found; i++) {
                for (int j = 0; j < newm; j++) {
                    if (newa[i][j] == 0) newa[i][j] = 2;  // Avoid division by zero

                    if (Math.abs(sum1 - sum0) % newa[i][j] == 0) {
                        System.out.println("YES");
                        found = true;
                        break;
                    }
                }
            }

            if (!found) System.out.println("NO");
        }
    }
}
