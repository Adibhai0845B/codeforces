import java.util.*;
public class Dreamin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0){
            t--;
            int n = sc.nextInt();
            int m = sc.nextInt();
            if(m==n){
        System.out.println("NO");
            }
          else if(m>n){
            if(n==1){
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }
          }
          else{
            if(n==1||m==1){
                System.out.println("YES");
            }
            else{
                int c = n%m;
                if(c==0){
                    System.out.println("NO");
                }
                else if(c==1){
                     System.out.println("YES");
                }
                else{
                   if(gcd(n,m)==1){
                    System.out.println("YES");
                   }
                   else{
                    System.out.println("NO");
                   }
            }
            }
          }
        }         
    }
    static int gcd(int a, int b)
    {
        if (b == 0)
            return a;
        else
            return gcd(b, Math.abs(a - b));
    }
}