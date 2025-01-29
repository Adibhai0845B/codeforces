import java.util.*;

class Solution {

    public static long computeLuckyValue(long n, long k) {
        long luckyValue = 0;

        while (n >= k) {
            if (n % 2 == 1) {
                long middle = n / 2 + 1;
                luckyValue += middle; // Add the middle element

                long left = n / 2; // Left segment length
                long right = n / 2; // Right segment length

                luckyValue += computeLuckyValue(left, k); // Add left segment value
                luckyValue += computeLuckyValue(right, k); // Add right segment value

                break; // Exit the loop after processing
            } else {
                long left = n / 2; // Left segment length
                long right = n / 2; // Right segment length

                luckyValue += computeLuckyValue(left, k); // Add left segment recursively
                luckyValue += computeLuckyValue(right, k); // Add right segment recursively

                break; // Exit the loop after processing
            }
        }

        return luckyValue;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt(); // Number of test cases
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < t; i++) {
            long n = scanner.nextLong(); // Number of stars
            long k = scanner.nextLong(); // Laziness threshold

            result.append(computeLuckyValue(n, k)).append("\n");
        }

        System.out.print(result.toString());
    }
}
