import java.util.*;

public class oi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();  // Read the number of test cases
        
        while (t-- > 0) {
            int n = sc.nextInt();  // Read the length of the string
            String s = sc.next();  // Read the binary string
            
            int count1 = 0;
            int count0 = 0;
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '1') {
                    count1++;
                } else if (s.charAt(i) == '0') {
                    count0++;
                }
            }
            
            int mid = (int) Math.ceil((double) n / 2.0);
            int count11 = 0;
            int count00 = 0;
            ArrayList<Integer> a1 = new ArrayList<>();
            
            for (int i = mid; i < n; i++) {
                if (s.charAt(i) == '1') {
                    count11++;
                } else if (s.charAt(i) == '0') {
                    count00++;
                }
                
                if ((count00 >= (Math.ceil((i + 1) / 2.0))) && (count1 - count11 >= Math.ceil((double) (n - i+1) / 2.0))) {
                    a1.add(i + 1 - mid);
                }
            }
            
            if (!a1.isEmpty()) {
                Collections.sort(a1);
                System.out.println(a1.get(0)+mid);
            } else {
                System.out.println(-1);
            }
        }
        sc.close();
    }
}
