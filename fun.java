import java.util.*;

public class fun {
    static final long MOD = 1000000007;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            hi(sc);
        }
        sc.close();
    }

    static void hi(Scanner sc) {
        int n = sc.nextInt();    String s = sc.next();   String k = sc.next();  boolean kl = false;
        for (int o = 0; o < n; o++) {
            if (s.charAt(o) == '.' || k.charAt(o) == '.') {
                kl = true;
                break;
            }
        }if (!kl) {    System.out.println(0);    return;
        }
        int sum = 0;
        int[] get = new int[n + 2];
        int io = 0;
        for (int i = 0; i < n; i++) {   if (s.charAt(i) == '.') io++;    if (k.charAt(i) == '.') io++;
            get[i] = io;
        }for (int jk = 1; jk < n - 1; jk++) {   int pich = get[jk - 1];   int aaga = get[n - 1] - pich - 2;
            if (s.charAt(jk) == '.' && k.charAt(jk - 1) == 'x' && k.charAt(jk + 1) == 'x' && pich > 0 && aaga > 0 && k.charAt(jk) == '.') {
              sum++;
            }

            if (k.charAt(jk) == '.' && s.charAt(jk - 1) == 'x' && s.charAt(jk + 1) == 'x' && pich > 0 && aaga > 0 && s.charAt(jk) == '.') {
                sum++;
            }
        }

        System.out.println(sum);
    }
}
