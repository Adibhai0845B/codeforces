/*import java.util.*;
public class Lis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         int t = sc.nextInt();
         while(t-->0){
            int n = sc.nextInt();
            long a[] = new long[n];
            HashSet<Long> h1  =  new HashSet<>();
            for(int i =0;i<n;i++){
                a[i] = sc.nextInt();
       h1.add(a[i]);
            }
         System.out.println((int)Math.max(Math.ceil(h1.size()/2),Math.ceil(n/2)));
        
        }
    }
}
*/
import java.util.*;
public class Lis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            long[] a = new long[n];
            HashSet<Long> h1 = new HashSet<>();
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
                h1.add(a[i]);
            }
            int uniqueCount = h1.size();
            // Calculate the ceiling of half of the sizes
            int ceilUniqueHalf = (int) Math.ceil(uniqueCount / 2.0);
            int ceilTotalHalf = (int) Math.ceil(n / 2);
            System.out.println(Math.max(ceilUniqueHalf, ceilTotalHalf));
        }
        sc.close();
    }
}
