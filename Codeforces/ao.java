import java.util.*;
public class ao {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while(t-- > 0) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            long[][] a = new long[n][m];
            long[][] b = new long[n][m];
            ArrayList<ArrayList<Long>> a1 = new ArrayList<>();
            for(int i = 0; i < n; i++) {
                ArrayList<Long> innerList = new ArrayList<>();
                for(int j = 0; j < m; j++) {
                    a[i][j] = scanner.nextLong();
                    innerList.add(a[i][j]);
                }
                a1.add(innerList);
            }
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    b[i][j] = scanner.nextLong();
                }
            }
            // Just printing a1 to check the values
            System.out.println(a1);
        }
    }
}
