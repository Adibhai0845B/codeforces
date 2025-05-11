import java.util.Scanner;
public class Battle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
           int n = sc.nextInt();
            long differenceSum = 0;
            String[] grid = new String[n];
            for (int i = 0; i < n; i++) {
                grid[i] = sc.next();
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i].charAt(j) != grid[j].charAt(n - 1 - i)) {
                        System.out.println(i+"jhsr"+j);
                        differenceSum += Math.abs(grid[i].charAt(j) - grid[j].charAt(n - 1 - i));
                    }
                }
            }
            System.out.println(differenceSum);
        }
        sc.close();
    }
}