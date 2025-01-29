import java.util.*;
public class VeryDifferent {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t  = sc.nextInt();
        while (t > 0) {
            t--;
            int n = sc.nextInt();
            int m = sc.nextInt();
            long a[] = new long[n];
            Integer b[] = new Integer[m];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
            }
            for (int i = 0; i < m; i++) {
                b[i] = sc.nextInt();
            }
            Arrays.sort(a);
            Arrays.sort(b, Comparator.reverseOrder());
            int i = 0, j = b.length - 1;
            int k = 0;
            long sum = 0;
            while (k < n) {
                if ( Math.abs(a[k] - b[i]) >= Math.abs(a[k] - b[j])) {
                    sum += Math.abs(a[k] - b[i]);
                    i++;
                } else {
                    sum += Math.abs(a[k] - b[j]);
                    j--;
                }
                k++;
            }
            System.out.println(sum);
        }
        sc.close();
    }
}
