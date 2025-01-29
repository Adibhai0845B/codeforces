import java.util.*;
public class abjk {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        char ch = sc.next().charAt(0);
        String a[] = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.next();
        }
        
        boolean[] seen = new boolean[130];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i].charAt(j) == ch) {
                    if (i > 0 && a[i-1].charAt(j) != '.' && a[i-1].charAt(j) != ch) {
                        seen[a[i-1].charAt(j)] = true;
                    }
                    if (i < n-1 && a[i+1].charAt(j) != '.' && a[i+1].charAt(j) != ch) {
                        seen[a[i+1].charAt(j)] = true;
                    }
                    if (j < m-1 && a[i].charAt(j+1) != '.' && a[i].charAt(j+1) != ch) {
                        seen[a[i].charAt(j+1)] = true;
                    }
                    if (j > 0 && a[i].charAt(j-1) != '.' && a[i].charAt(j-1) != ch) {
                        seen[a[i].charAt(j-1)] = true;
                    }
                }
            }
        }
        int count = 0;
        for (boolean s : seen) {
            if (s) count++;
        }
        System.out.println(count);
    }
}