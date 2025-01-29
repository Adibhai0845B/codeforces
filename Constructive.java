import java.util.Scanner;

public class Constructive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int d = sc.nextInt();
        int[] b = new int[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }

        for (int i = 1; i < n; i++) {
            if (b[i] <= b[i - 1]) {
                int neededIncrease = b[i - 1] - b[i] + 1;
                int diff = (int) Math.ceil((double) neededIncrease / d);
                b[i] += diff * d;
                count += diff;
            }
        }

        System.out.println(count);
    }
}
