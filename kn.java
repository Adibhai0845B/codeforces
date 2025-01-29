import java.util.*;

public class kn {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt(); int d = sc.nextInt();  int z = sc.nextInt();
            int[] oi = new int[n];
            for(int i =0;i<n;i++){
                oi[i] = 1;
            }
            d--; 
            z--;  
            for (int i = z - 1; i >= 0; i -= 2) {
                oi[i] = -1;
            }
            for (int i = d + 1; i < n; i += 2) {
                oi[i] = -1;
            }
            for (int i=0;i<oi.length;i++) {
                System.out.print(oi[i] + " ");
            }
            System.out.println();
        }
    }
}
