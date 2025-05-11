/*import java.util.Scanner;

public class perm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int n = s.length();
            int countA = 0;
            int countB = 0;
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == 'A') countA++;
                else countB++;
            }
            if (countA <= countB) {
                System.out.println(countA);
            } else {
                int ansFromRight = calculateFromRight(s, n);
                int ansFromLeft = calculateFromLeft(s, n);
                System.out.println(Math.max(ansFromRight, ansFromLeft));
            }
        }
        sc.close();
    }
    private static int calculateFromRight(String s, int n) {
        int ans = 0;
        boolean right = true;

        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == 'B') {
                int a = 0, b = 0;
                int j = i - 1, k = i + 1;
                while (k < n && s.charAt(k) == 'A' && right) {
                    b++;
                    k++;
                }
                while (j >= 0 && s.charAt(j) == 'A') {
                    a++;
                    j--;
                    right = true;
                }
                ans += Math.max(a, b);
                if (a > b) {
                    i = j+1;
                    right = false;
                }
            }
        }

        return ans;
    }
    private static int calculateFromLeft(String s, int n) {
        int ans = 0;
        boolean left = true;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'B') {
                int a = 0, b = 0;
                int j = i - 1, k = i + 1;
                while (j >= 0 && s.charAt(j) == 'A'&&left ) {
                    a++;
                    j--;
                }
                while (k <n && s.charAt(k) == 'A') {
                    b++;
                    k++;
                   left = true;
                }
                System.out.println(ans);
                ans += Math.max(a, b);
                if (b>a) {
                    i = k-1; 
                    left = false;
                }
            }
        }

        return ans;
    }
}
*/
import java.util.Scanner;

public class perm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int n = s.length();
            int countA = 0;
            int countB = 0;
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == 'A') countA++;
                else countB++;
            }
            if (countA <= countB) {
                System.out.println(countA);
            } else {
                int ansFromRight = calculateFromRight(s, n);
                int ansFromLeft = calculateFromLeft(s, n);
                System.out.println(Math.min(ansFromRight, ansFromLeft));
            }
        }
        sc.close();
    }
    private static int calculateFromRight(String s, int n) {
        int ans = 0;
        boolean right = true;
         int j =0;
         int a =0;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == 'B') {
                int b = 0;
                int k = i +1;
                while (k < n && s.charAt(k) == 'A' && right) {
                    b++;
                    k++;
                }
              /*   while (j >= 0 && s.charAt(j) == 'A') {
                    a++;
                    j--;
                    right = true;
                }*/
                ans += Math.max(a, b);
              //  if (a > b) {
                //    i = j+1;
                //    right = false;
               // }
            }
        }
   while(s.charAt(j)=='A'){
    a++;
    j++;
   }
        return ans+a;
    }
    private static int calculateFromLeft(String s, int n) {
        int ans = 0;
        boolean left = true;
        int k = n-1;
        int b =0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'B') {
                int a = 0;
                int j = i - 1;
                while (j >= 0 && s.charAt(j) == 'A'&&left ) {
                    a++;
                    j--;
                }
               // System.out.println(ans);
                ans += Math.max(a, b);
              //  if (b>a) {
                //    i = k-1; 
              //      left = false;
              //  }
            }
        }
        while(s.charAt(k)=='A'){
            b++;
            k--;
        }
        return ans+b;
    }
}
