import java.util.*;
public class LIrttle {
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    long a[] = new long[n];
    for(int i =0;i<n;i++){
     a[i] = sc.nextLong();
    }
    long total =0;
    long min =Long.MAX_VALUE;
    for(int i =0;i<n-1;i++){
         for(int j = i+1;j<n;j++){
            if(a[j]<a[i]){
                long diff = a[i]-a[j];
                if(j==1){
                  total+=(a[i]-a[j]);
                //  System.out.println(total+"1");
                }
                else{
           total+=(a[i]-(a[j]+min));
           //System.out.println(total+"2");
                }
                  min = Math.min(diff,min);
            }
          else{
            i = j-1;
            min = 0;
            break;
          }
         }
        }
    System.out.println(total);
}    
}


