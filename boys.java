import java.util.*;
public class boys {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        if(n > m) {
            while(n > 0 && m > 0) {
                sb.append("BG");
                n--;
                m--;
            }
            while(n > 0) {
                sb.append("B");
                n--;
            }
            System.out.println(sb);
        } else {
            while(n > 0 && m > 0) {
                sb.append("GB");
                n--;
                m--;
            }
            while(m > 0) {
                sb.append("G");
                m--;
            }
            System.out.println(sb);
        }
    }
}
