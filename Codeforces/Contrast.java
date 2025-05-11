import java.util.*;

public class Contrast {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t > 0) {
            t--;
            int n = sc.nextInt();
            long[] a = new long[n];
            long[] b = new long[n - 1];

            a[0] = sc.nextLong();
            long totalSum = 0;
            
            for (int i = 1; i < n; i++) {
                a[i] = sc.nextLong();
                long diff = Math.abs(a[i] - a[i - 1]);
                b[i - 1] = diff;
                totalSum += diff;
            }

            long partialSum = 0;
            int count = 0;
            List<Integer> counts = new ArrayList<>();

            for (int i = 0; i < n - 1; i++) {
                partialSum += b[i];
                count++;
                if (partialSum == totalSum) {
                    counts.add(count);
                    count = 0;
                    partialSum = 0;
                } else if (partialSum > totalSum) {
                    // Logic to handle cases where partialSum exceeds totalSum
                    count = 0;
                    partialSum = 0;
                }
            }

            // Print the counts for debugging or further processing
            for (int c : counts) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
        
        sc.close();
    }
}
