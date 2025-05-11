import java.util.*;
public class Romantic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0) {
            int n = sc.nextInt();
            long a[] = new long[n];
              long sum1 =0;
              long sum2 =0;
              for(int i =0;i<n-1;i++){
                a[i] = sc.nextLong();
            }
            int  i =0;
            int count =0;
            // sum1  for odd sum2 for even 
              while(i<n){
                if(sum1==sum2){
                    count++;
                    break;
                }
              sum1+=a[i];
                 i++;
                 if(i<n){
                    sum2+=a[i];
                i++; 
                }
                if(sum1==sum2){
                    count++;
                    break;
                }
              }
              if(count>0){
                System.out.println("YES");
              }
              else{
                System.out.println("NO");
              }
        }
    }
}
