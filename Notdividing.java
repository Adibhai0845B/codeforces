import java.math.BigInteger;
import java.util.*;
public class Notdividing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int x = sc.nextInt(); 
            String s = sc.next(); 
            BigInteger ONE = BigInteger.valueOf(1);
            BigInteger TWO = BigInteger.valueOf(2);
            BigInteger THREE = BigInteger.valueOf(3);
            BigInteger ZERO = BigInteger.valueOf(0);
            StringBuilder main = new StringBuilder(); 
            for (int i = s.length() - 1; i >= 0; i--) {
                main.append(s.charAt(i));
            }
            BigInteger sint = new BigInteger(main.toString(), 2); 
            if (sint.equals(ONE)) {
              System.out.println("ALICE");
          } else if (sint.mod(TWO).equals(ONE)) {
              System.out.println("BOB");
          }
          else{
               if(sint.equals(TWO)) System.out.println("BOB");
               else {
                if (sint.mod(THREE).equals(ZERO)) {
                  System.out.println("BOB");
              }
                else{
                System.out.println("ALICE");
                }
               }
          }
        }
          sc.close();
    }
}
