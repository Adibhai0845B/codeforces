import java.math.BigInteger;
import java.util.Scanner;

public class Correct {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            BigInteger a = sc.nextBigInteger();
            BigInteger s = sc.nextBigInteger();
            
            String aStr = a.toString();
            String sStr = s.toString();
            
            StringBuilder b = new StringBuilder();
            int i = aStr.length() - 1;
            int j = sStr.length() - 1;
            boolean valid = true;
            
            while (i >= 0 && j >= 0) {
                int aDigit = aStr.charAt(i) - '0';
                int sDigit = sStr.charAt(j) - '0';
                
                if (sDigit < aDigit) {
                    if (j == 0 || sStr.charAt(j - 1) != '1') {
                        valid = false;
                        break;
                    }
                    j--;
                    sDigit += Integer.parseInt(String.valueOf(sStr.charAt(j))) * 10;

                }
                
                b.append(sDigit - aDigit);
                i--;
                j--;
            }
            
            while (j >= 0) {
                b.append(sStr.charAt(j) - '0');
                j--;
            }
            
            if (i >= 0) {
                valid = false;
            }
            
            if (valid) {
                BigInteger bNum = new BigInteger(b.reverse().toString());
                if (a.add(bNum).equals(s)) {
                    System.out.println(bNum);
                } else {
                    System.out.println(-1);
                }
            } else {
                System.out.println(-1);
            }
        }
        sc.close();
    }
}
