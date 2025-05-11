import java.util.*;
public class LittleElephant{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long a[] = new long[n];
        
        for(int i = 0; i < n; i++) {
            a[i] = sc.nextLong();
        }    
        long b[] = Arrays.copyOf(a, n);
        Arrays.sort(b);
        int count = 0;
        
        for(int i = 0; i < n; i++) {
            if(a[i] != b[i]) count++;
        }
        
        if(count <= 2) System.out.println("YES");
        else System.out.println("NO");
    }
}
