import java.util.Arrays;
import java.util.Scanner;

public class Roma {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[n];
        int negativeCount = 0;
        int sum = 0;

        // Reading array elements and calculating initial sum and negative count
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            if (a[i] < 0) {
                negativeCount++;
            }
            sum += Math.abs(a[i]);
        }

        Arrays.sort(a);

        if (k == 0) {
            System.out.println(sum);
            return;
        }

        if (a[0] >= 0) {
            if (k % 2 == 0) {
                System.out.println(sum);
            } else {
                System.out.println(sum - 2 * Math.abs(a[0]));
            }
            return;
        }

        if (negativeCount < k) {
            for (int i = 0; i < negativeCount; i++) {
                sum += 2 * a[i];
            }
            k -= negativeCount;
            if (k % 2 != 0) {
                int minAbs = Integer.MAX_VALUE;
                for (int i = 0; i < n; i++) {
                    minAbs = Math.min(minAbs, Math.abs(a[i]));
                }
                sum -= 2 * minAbs;
            }
        } else {
            for (int i = 0; i < k; i++) {
                sum += 2 * a[i];
            }
        }

        System.out.println(sum);
    }
}
