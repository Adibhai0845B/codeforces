/*import java.util.*;
public class Bazoka {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0){
            t--;
            int n = sc.nextInt();
            int[] a = new int[n];
           // a[0] = sc.nextInt();
            for(int i =0;i<n;i++){
                a[i] = sc.nextInt();
            }
            int c =0;
            for(int i =0;i<n-1;i++){
                if(a[i]>a[i+1]){
                      c = i+1;
                }
            }
            int count =0;
            for(int i = c;i<n;i++){
                if(i!=c&&a[i]<=a[0]&&a[i]>=a[i-1]){
                }
                if(i==c){
                    continue;
                }
                else{
                    count++;
                }
            }
            if(count>0){
                System.out.println("No");
            }
            else{
                System.out.println("Yes");
            }
        }
    }
}
*/
import java.util.*;

public class Bazoka {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // Number of test cases
        while (t > 0) {
            t--;
            int n = sc.nextInt(); // Size of the array
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt(); // Array elements
            }

            // Find the first point of decrease
            int c = 0;
            for (int i = 0; i < n - 1; i++) {
                if (a[i] > a[i + 1]) {
                    c = i + 1;
                    break;
                }
            }

            boolean isValid = true;
            // Check if the array can be rotated to form a non-decreasing sequence
            for (int i = c; i < n + c - 1; i++) {
                if (a[i % n] > a[(i + 1) % n]) {
                    isValid = false;
                    break;
                }
            }

            if (isValid) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
        sc.close();
    }
}
