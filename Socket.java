import java.util.*;
public class Socket {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       int n = sc.nextInt();
       int m = sc.nextInt();
       int k = sc.nextInt();
       int a[] = new int[n];
       for(int i =0;i<n;i++){
        a[i] = sc.nextInt();
       }
       Arrays.sort(a);
       int sum =0;
       int count =0;
       for(int i = n-1;i>=0;i--){
         sum+=a[i];
         count++;
         if(sum>=m){
            break;
         }
       }
       if(sum<m||count>k){
      System.out.println("-1");
       }
       else{
        System.out.println(count);
       }
      }
    }
