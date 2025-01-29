import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class Longest {
    public static void op(BigInteger x) {
        ArrayList<BigInteger> b = new ArrayList<>();
        ArrayList<BigInteger> s1 = new ArrayList<>();
        
        // Collect powers of two that are present in n's binary representation
        for (int k = 0; k <= 60; k++) {
            BigInteger lk = BigInteger.ONE.shiftLeft(k);
            if (x.and(lk).compareTo(BigInteger.ZERO) != 0) {
                b.add(lk);
            }
        }
        
        s1.add(x);
        
        // Construct the sequence by subtracting powers of two from n
        for (BigInteger oi : b) {
            BigInteger a = x.subtract(oi);
            if (a.compareTo(BigInteger.ZERO) > 0) {
                s1.add(a);
            }
        }
        
        System.out.println(s1.size());
        for (int k = s1.size() - 1;k >= 0; k--) {
            System.out.print(s1.get(k) + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            BigInteger x = sc.nextBigInteger();
            op(x);
        }
        sc.close();
    }
}
