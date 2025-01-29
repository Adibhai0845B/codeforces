import java.util.*;

public class Teleports {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();  // number of test cases
        while (t-- > 0) {
            int n = sc.nextInt();  // number of teleporters
            long c = sc.nextLong();  // available cost
            long[][] a = new long[n][2];  // array to store teleporters

            // Read teleporter costs and their indices
            for (int i = 0; i < n; i++) {
                a[i][0] = sc.nextLong();
                a[i][1] = i + 1;
            }

            // Sort the teleporters by cost
            Arrays.sort(a, Comparator.comparingLong(o -> o[0]));

            // Calculate the effective cost of using each teleporter
            long[] b = new long[n];
            for (int i = 0; i < n; i++) {
                b[i] = a[i][0] + a[i][1];
            }

            // Sort the effective costs
            Arrays.sort(b);

            // Determine how many teleporters can be used
            int count = 0;
            int i = 0;
            while (c > 0 && i < n) {
                c -= b[i];
                if (c >= 0) {
                    count++;
                }
                i++;
            }
            
            // Output the result for the current test case
            System.out.println(count);
        }
    }
}
