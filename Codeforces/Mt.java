import java.util.*;

public class Mt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while(t-->0){
        int n = scanner.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
        }

        int m = scanner.nextInt();
        int[] array = new int[m];
        Map<Integer, Integer> h1 = new HashMap<>();
        
        for (int i = 0; i < m; i++) {
            array[i] = scanner.nextInt();
            h1.put(array[i], h1.getOrDefault(array[i], 0) + 1);
        }
        boolean ans = false;
        for (int i = 0; i < n; i++) {
            if (array[m - 1] == b[i]) {
                ans = true;
            }
            if (a[i] != b[i]) {
                h1.put(b[i], h1.getOrDefault(b[i], 0) - 1);
            }
        }

        for (int i: h1.values()) {
            if (i < 0) {
                ans = false;
                break;
            }
        }

        if (ans) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
    }
}