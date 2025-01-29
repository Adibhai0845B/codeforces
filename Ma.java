import java.util.*;

public class Ma {

    // Function to check if a number is prime
    static boolean pp(long n) {
        if (n <= 1) return false;
        for (long i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
    static long ss(long po) {
        List<Long> ans = new ArrayList<>();

        while (ans.size() < 2) {
            if (pp(po)) ans.add(po);
            po++;
        }

        return ans.get(0) * ans.get(1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {
            long x = scanner.nextLong();
            if (x == 1) x++;
            
            System.out.println(ss(x));
        }
        
        scanner.close();
    }
}
