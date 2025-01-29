import java.util.Scanner;

public class Increase {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while (t > 0) {
            t--;
            int n = sc.nextInt();
            long[] a = new long[n];
            long[] b = new long[n + 1];
            
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
            }
            for (int i = 0; i < n + 1; i++) {
                b[i] = sc.nextLong();
            }

            long  count = 1;
            long count2 = 0;
            long c = b[n];
            
            for (int i = 0; i < n; i++) {
                if ((c >= a[i] && c <= b[i]) || (c <= a[i] && c >= b[i])) {
                    count2++;
                }
                count += Math.abs(a[i] - b[i]);
            }
            //  System.out.println(count);
            if (count2 > 0) {
                System.out.println(count);
            } else {
                long maxVal = Long.MIN_VALUE;
                long minVal = Long.MAX_VALUE;
                
                for (int i = 0; i < n; i++) {
                    long maxAB = Math.max(a[i], b[i]);
                    long minAB = Math.min(a[i], b[i]);
                    
                    if (maxAB > maxVal) {
                        maxVal = maxAB;
                    }
                    if (minAB < minVal) {
                        minVal = minAB;
                    }
                }
                
                long adjustment = Math.min(Math.abs(maxVal - b[n]), Math.abs(minVal - b[n]));
                count += adjustment;
                System.out.println(count);
            }
        }
        
        sc.close();
    }
}
