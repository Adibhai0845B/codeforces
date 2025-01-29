/*import java.util.*;
public class MonstersAttack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0){
            t--;
            int n = sc.nextInt();
            int k = sc.nextInt();   
            long a[][] = new long[n][2];
            int x[] = new int[n];
           long sum =0;
            for(int i =0;i<n;i++){
                a[i][0] = sc.nextLong();
             sum+=a[i][0];
             a[i][1] = sum;
            }
            for(int i =0;i<n;i++){
                x[i] = Math.abs(sc.nextInt());
            }
            int count =0;
            for(int i =0;i<n;i++){
                if((k*x[i])<a[i][1]){
              count++;
              break;
                }
            }
            if(count>0){
                System.out.println("NO");
            }
            else{
                System.out.println("YES");
            }
        }
    }
}
*/
import java.util.*;

public class MonstersAttack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while (t > 0) {
            t--;
            int n = sc.nextInt();
            int k = sc.nextInt();
            
            long[] power = new long[n];
            long[] cumulativeSum = new long[n];
            int[] distances = new int[n];
            
            for (int i = 0; i < n; i++) {
                power[i] = sc.nextLong();
                if (i == 0) {
                    cumulativeSum[i] = power[i];
                } else {
                    cumulativeSum[i] = cumulativeSum[i - 1] + power[i];
                }
            }
            
            for (int i = 0; i < n; i++) {
                distances[i] = Math.abs(sc.nextInt());
            }
            
            boolean defeated = false;
            
            for (int i = 0; i < n; i++) {
                if (k * distances[i] < cumulativeSum[i]) {
                    defeated = true;
                    break;
                }
            }
            
            if (defeated) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        }
        
        sc.close();
    }
}
