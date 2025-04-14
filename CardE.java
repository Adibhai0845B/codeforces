import java.util.*;

public class CardE {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();

            int[][] a = new int[n][m];
            int x = 1;

            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < m; ++j) {
                    a[i][j] = x;
                    x = x % k + 1;
                }
                if (m % 2 == 0) {
                    if (m % k == 0) {
                        // x remains the same
                    } else {
                        x = x % k + 1;
                    }
                } else {
                    if (k % 2 == 0) {
                        x = x % k + 1;
                    } else {
                        // x remains the same
                    }
                }
            }

            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < m; ++j) {
                    System.out.print(a[i][j] + " ");
                }
                System.out.println();
            }
        }

        sc.close();
    }
}
