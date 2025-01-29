import java.util.*;
public class Maxim1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int  m = sc.nextInt();
        int q[] = new int[m];
        int odd =0;
        boolean oi= true;
        for(int i =0;i<m;i++){
          q[i] = sc.nextInt();
          if(q[i]%2!=0&&oi){
            odd = i;
            oi = false;
          }
        }
        int n  = sc.nextInt();
        int a[] = new int[n];
        for(int i =0;i<n;i++){
            a[i] = sc.nextInt();
        }
        Arrays.sort(q);
        Arrays.sort(a);
        if(q[0]%2==0){
            if(n%2==0){
                   int i=n-1;
                   while(i>=0){
                     
                   }
            }
        }
    }
}
