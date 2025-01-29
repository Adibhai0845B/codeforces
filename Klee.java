/*
 * AdiBhai0845R
 */
import java.util.*;
public class Klee {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while(t-->0){
        int n = sc.nextInt();
        String a="aeiou";
       int k =0;
       StringBuilder sb = new StringBuilder(); 
       for (int i = 0; i < 5; ++i) {
        for (int j = 0; j < (n / 5); ++j) {
            sb.append(a.charAt(i));
        }
        if (i < n % 5) {
            sb.append(a.charAt(i));
        }
    }
       System.out.println(sb);
}
}
}