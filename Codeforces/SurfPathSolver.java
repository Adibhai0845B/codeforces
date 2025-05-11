import java.util.*;

public class SurfPathSolver {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // Number of test cases

        while (t-- > 0) {
            int n = sc.nextInt(); // Number of hurdles
            int m = sc.nextInt(); // Number of power-ups
            int L = sc.nextInt(); // Path end position

            int[][] hurdles = new int[n][2];
            for (int i = 0; i < n; i++) {
                hurdles[i][0] = sc.nextInt(); // li
                hurdles[i][1] = sc.nextInt(); // ri
            }

            int[][] powerUps = new int[m][2];
            for (int i = 0; i < m; i++) {
                powerUps[i][0] = sc.nextInt(); // xi
                powerUps[i][1] = sc.nextInt(); // vi
            }

            int result = solve(L, hurdles, powerUps, n, m);
            System.out.println(result);
        }
    }

    private static int solve(int L, int[][] hurdles, int[][] powerUps, int n, int m) {
        PriorityQueue<Integer> powerQueue = new PriorityQueue<>();
        int currentJumpPower = 1;
        int collectedPowerUps = 0;

        int powerIndex = 0;
        int hurdleIndex = 0;
        int currentPosition = 1;

        while (currentPosition < L) {
            // Add all power-ups within the current jump range to the priority queue
            while (powerIndex < m && powerUps[powerIndex][0] <= currentPosition) {
                powerQueue.add(powerUps[powerIndex][1]);
                powerIndex++;
            }

            // Handle hurdles that block the current path
            while (hurdleIndex < n && hurdles[hurdleIndex][1] < currentPosition + currentJumpPower) {
                if (hurdles[hurdleIndex][0] > currentPosition) {
                    currentPosition = hurdles[hurdleIndex][1] + 1;
                }
                hurdleIndex++;
            }

            // Check if we're blocked by a hurdle
            if (hurdleIndex < n && currentPosition >= hurdles[hurdleIndex][0] &&
                currentPosition <= hurdles[hurdleIndex][1]) {
                if (powerQueue.isEmpty()) {
                    return -1; // No power-ups left to bypass the hurdle
                }
                // Use the smallest power-up to increase jump power
                currentJumpPower += powerQueue.poll();
                collectedPowerUps++;
                continue;
            }

            currentPosition += currentJumpPower;

            if (currentPosition > L) {
                break;
            }
        }

        return currentPosition >= L ? collectedPowerUps : -1;
    }
}
