import java.util.*;

public class MinimizeTheDifference {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while (t-- > 0) {
            int n = sc.nextInt();
            long a[] = new long[n];
            
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
            }
            
            long ans = Long.MAX_VALUE;
            long max = Long.MIN_VALUE;
            long min = Long.MAX_VALUE;
            long prevans = 0;

            // Calculate initial max and min
            for (long num : a) {
                max = Math.max(max, num);
                min = Math.min(min, num);
            }
            
            prevans = max - min;

            // Keep modifying until difference cannot be minimized further
            while (true) {
                int index = -1;
                long diff = Long.MAX_VALUE;

                // Find the closest pair of adjacent elements
                for (int i = 0; i < n - 1; i++) {
                    long c = a[i + 1] - a[i];
                    if (c < diff) {
                        diff = c;
                        index = i;
                    }
                }

                // Break if no more optimization can be done
                if (index == -1) break;

                // Adjust elements to try and minimize the difference
                a[index]--;
                a[index + 1]++;

                // Recalculate max and min
                max = Long.MIN_VALUE;
                min = Long.MAX_VALUE;
                for (long num : a) {
                    max = Math.max(max, num);
                    min = Math.min(min, num);
                }

                // Check the new difference
                long newDifference = max - min;
                if (newDifference >= prevans) {
                    break;
                }

                prevans = newDifference;
            }
            
            System.out.println(prevans);
        }
        
        sc.close();
    }
}
