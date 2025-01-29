import java.util.*;

public class milica {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            t--;
            int n = sc.nextInt();
            int k = sc.nextInt();
            String s = sc.next();
            int countB = 0;
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == 'B') {
                    countB++;
                }
            }
            int countA = n - countB;

            if (countB == k) {
                System.out.println("0");
            } else if (countB < k) {
                int diff = k - countB;
                if (diff <= countA) {
                    System.out.println("1");
                    for (int i = 0; i < n; i++) {
                        if (s.charAt(i) == 'A') {
                            diff--;
                            if (diff == 0) {
                                System.out.println((i + 1) + " B");
                                break;
                            }
                        }
                    }
                } else {
                    System.out.println("-1");
                }
            } else { // countB > k
                int diff = countB - k;
                if (diff <= countB) {
                    System.out.println("1");
                    for (int i = 0; i < n; i++) {
                        if (s.charAt(i) == 'B') {
                            diff--;
                            if (diff == 0) {
                                System.out.println((i + 1) + " A");
                                break;
                            }
                        }
                    }
                } else {
                    System.out.println("-1");
                }
            }
        }
    }
}
