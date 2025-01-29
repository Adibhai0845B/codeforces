import java.util.Scanner;

public class AliceInChess{

    public static void funct(Scanner sc) {
        long n = sc.nextLong();
        long b = sc.nextLong();
         long c = sc.nextLong();
        if (n == 1) {
            System.out.println(c != 0 ? 1 : 0);
            return;
        }
        if (b == 0) {
            if (c < n - 2) {
                System.out.println("-1");
            } else {
                System.out.println(c >= n ? n : n - 1);
            }
            return;
        }
        long k = (n - c + b - 1) / b;
        System.out.println(c > n ? n : n - k);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while (t-- > 0) {
            funct(sc);
        }
        sc.close();
    }
}
