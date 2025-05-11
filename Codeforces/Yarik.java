import java.util.*;
public class Yarik {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       int t = sc.nextInt();
       while(t>0){
        t--;
        int n = sc.nextInt();
     int a[] = new int[n];
     for(int i =0;i<n;i++){
        a[i] = sc.nextInt();
     }
     long sum =0;
     if(a[0]>=0){
      sum =a[0];
    }
     long count =0;
     for(int i =1;i<n;i++){
        if(a[i]<0){
       continue;
        }
       else if((a[i]%2==0&&a[i-1]%2!=0)||a[i]%2!=0&&a[i-1]%2==0){
            sum+=a[i];
         if(sum>count){
            count = sum;
         }
        }
        else{
              sum = a[i];
        }
     }
       }
    }
}
