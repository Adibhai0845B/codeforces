import java.util.*;

public class minimumlcm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            long n = sc.nextLong();
            if (n % 2 == 0) {
                System.out.print(n / 2 + " ");
                System.out.print(n / 2);
                System.out.println();
            } else {
                if (lcm(n / 2, (n / 2) + 1) < lcm(1, n - 1)) {
                    System.out.print(n / 2 + " ");
                    System.out.print((n / 2) + 1);
                    System.out.println();
                } else {
                    System.out.print(1 + " ");
                    System.out.print(n - 1);
                    System.out.println();
                }
            }
        }
    }

    public static long lcm(long a, long b) {
        return (a * b) / gcd(a, b);
    }

    public static long gcd(long a, long b) {
        while (b > 0) {
            long temp = b;
            b = a % b; // % is remainder
            a = temp;
        }
        return a;
    }
}
