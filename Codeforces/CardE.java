import java.util.*;

public class CardE {
    static final int MOD = 998244353;
  
    public static void push(Scanner sc) {
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long start = System.nanoTime();

        int tc = sc.nextInt();
        while (tc-- > 0) {
            push(sc);
        }

        long end = System.nanoTime();
        System.err.printf("Time measured: %.9f seconds\n", (end - start) / 1e9);
    }
}
