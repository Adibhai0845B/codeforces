/*import java.util.*;
public class Datatypes{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long a[] = new long[n];
        for(int i =0;i<n;i++){
            a[i] =sc.nextLong();
        }
        Arrays.sort(a);
        long t = (long)Math.pow(2,(double)a[n-2])-1;
        long y  = t*t;
        String s = Long.toBinaryString(y);
        if(s.length()<=a[n-1]) System.out.println("NO");
        else System.out.println("YES");
    }
}*/
import java.util.*;
import java.math.BigInteger;
public class Datatypes{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        BigInteger a[] = new BigInteger[n];

        for(int i = 0; i < n; i++) {
            a[i] = sc.nextBigInteger();  // Use BigInteger for input
        }

        Arrays.sort(a, new Comparator<BigInteger>() {
            @Override
            public int compare(BigInteger o1, BigInteger o2) {
                return o1.compareTo(o2);  // Sort BigInteger array
            }
        });

        BigInteger two = new BigInteger("2");
        BigInteger t = two.pow(a[n-2].intValue()).subtract(BigInteger.ONE);  // t = 2^(a[n-2]) - 1
        BigInteger y = t.multiply(t);  // y = t * t

        String s = y.toString(2);  // Convert y to binary string

        if(s.length() <= a[n-1].intValue()) 
            System.out.println("NO");
        else 
            System.out.println("YES");
    }
}
