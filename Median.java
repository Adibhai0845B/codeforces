import java.util.*;

public class Median {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();

        while (t-- > 0) {
            int n = scanner.nextInt();
            int l = scanner.nextInt();
            int r = scanner.nextInt();

            int[] arr1 = new int[n];
            for (int i = 0; i < n; i++) {
                arr1[i] = scanner.nextInt();
            }

            Queue<Integer> que = new LinkedList<>();
            int ans1 = 0;
            int ans2 = 0;
    
            for (int i = 0; i  <n; i++) {
                ans1 += arr1[i];
                que.add(arr1[i]);
    
                // Adjust sum if it exceeds the upper limit r
                while (!que.isEmpty() && ans1> r) {
                    ans1 -= que.poll();
                }
                if (ans1 >= l && ans1 <= r) {
                    ans1 = 0; // Reset the sum for the next round
                    que.clear(); // Clear the round cards
                    ans2++;
                }
            }
            System.out.println(ans2);
        }
    }

}