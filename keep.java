import java.util.*;
public class keep {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            t--;
            int q = sc.nextInt();
            long a[] = new long[q];
            int count = 0;
            long c = 0;
            a[0] = sc.nextLong();
            System.out.print("1");
            for (int i = 1; i < q; i++) {
                a[i] = sc.nextLong();
                if (a[i] >= a[i - 1] && count == 0) {
                    System.out.print("1");
                } else {
                    count++;
                    if (count == 1 && a[i] <= a[0]) {
                        c = a[i];
                        System.out.print("1");
                    } else {
                        if (a[i] <= a[0] && a[i] >= c) {
                            System.out.print("1");
                            c = a[i];
                        } else {
                            System.out.print("0");
                        }
                    }
                }
            }
            System.out.println();
        }
    }
}
