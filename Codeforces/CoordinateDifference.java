import java.util.Scanner;

public class CoordinateDifference {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read coordinates
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();

        // Calculate differences
        int ans1 = a - b;
        int ans2 = c - d;

        // Check conditions and output result
        if ((ans1 > 0 && ans2 > 0) || (ans1 < 0 && ans2 < 0) || (ans1== ans2)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
