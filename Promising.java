import java.util.*;
public class Promising {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
     int t = sc.nextInt();
    while(t-->0){
        int n = sc.nextInt();
        long k = sc.nextLong();
      long ans =0;
      long a[] =new long[n+1];
      a[0] = 0;
      for(int i =1;i<=n;i++){
        a[i] = sc.nextLong();
 a[i]+=a[i-1];
      }
      if(k>n){
        ans = a[n]+n*k-n*(n+1)/2;
      }
      else{
        for(int i =(int)k;i<=n;i++){
            ans=Math.max(ans,a[i]-a[i-(int)k]);
        }
        ans+=k*(k-1)/2;
      }
      System.out.println(ans);
    }
    }
}
