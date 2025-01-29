import java.util.*;

public class Reverse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            t--;
            int n = sc.nextInt();
            int m = sc.nextInt();
            int count = n;
            for (int i = 1; i <= n; i++) {
                for (int j = 2; j <= m; j++) {
                    if ((i + j) % (j * gcd(i, j)) == 0) {
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

}
