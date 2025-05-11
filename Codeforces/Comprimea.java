import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();

        while (T-- > 0) {
            int N = scanner.nextInt();
            int K = scanner.nextInt();
            int[] diff = new int[N];
            for (int i = 0; i < N; ++i) {
                A[i] = scanner.nextInt();
            }

            // Calculate the initial sum of absolute differences
            int initialSum = 0;
            for (int i = 0; i < N - 1; ++i) {
                initialSum += Math.abs(A[i] - A[i + 1]);
            }

            int maxSum = initialSum;

            // Check all possibilities of changing one element to 1 or K
            for (int i = 0; i < N; ++i) {
                maxSum = Math.max(maxSum, initialSum + calculateChange(A, N, i, 1));
                maxSum = Math.max(maxSum, initialSum + calculateChange(A, N, i, K));
            }

            System.out.println(maxSum);
        }
    }
     public static int calculateChange(int[] A, int N, int index, int value) {
        int change = 0;
        if (index > 0) {
            change += Math.abs(value - A[index - 1]) - Math.abs(A[index] - A[index - 1]);
        }
        if (index < N - 1) {
            change += Math.abs(value - A[index + 1]) - Math.abs(A[index] - A[index + 1]);
        }
        return change;
    }
}
