import java.util.*;
public class Pulses {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int t =sc.nextInt();
       while(t-->0){
        long n = sc.nextInt();
        int k = sc.nextInt();
           long a[] = new long[k];
        int count = 0;
           for(int i =0;i<k;i++){
            a[i] = sc.nextLong();
        }
        Arrays.sort(a);
        long sum =0;
        for(int i =0;i<k-1;i++){
         sum+=((2*a[i])-1);
        }
     System.out.println(sum);
      }
    }
}