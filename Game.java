import java.util.*;
public class Game {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t  = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            long a[] = new long[n];
            long sum =0;
            for(int i =0;i<n;i++){
                a[i] = sc.nextLong();
            }
            Arrays.sort(a);
          for(int i =0;i<n-1;i++){
            sum+=a[i];
          }
          long s  =  sum-a[n-1];
         if(a[n-1]==0&&sum==0){
            System.out.println("0");
         }
         else if(s>=0){
             System.out.println("1");
        }
        else{
            System.out.println(Math.abs(s));
        }
        }
    }
}
