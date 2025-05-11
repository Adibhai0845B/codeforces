import java.util.*;
public class KSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t  = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            long a[] =new long[n];
            long max =0;
        long m = 0;
        long mx =0;
            for(int i =0;i<n;i++){
                a[i] = sc.nextLong();
              max+=Math.max(0,mx-a[i]);
              m = Math.max(m,mx-a[i]);
            mx = Math.max(mx,a[i]);
            }
            System.out.println(max+m);
    }
        }
        }