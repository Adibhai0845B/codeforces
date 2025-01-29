import java.util.Scanner;

public class oneo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long x = sc.nextLong();
        String y = String.valueOf(x);
        int n = y.length();
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        long d = 0;

        while (x != 0) {
            long c = x % 10;
            if (first) {
                d = c;
                first = false;
            }
            if (c > 4) {
                sb.append(9 - c);
            } else {
                sb.append(c);
            }
            x /= 10;
        }

        // Reverse the StringBuilder since the digits were processed in reverse order
        sb.reverse();

        // Check and handle leading zero
        if (sb.charAt(0) == '0') {
            sb.setCharAt(0, (char) (d + '0'));
        }

        System.out.println(sb.toString());
    }
}
