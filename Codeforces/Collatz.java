import java.util.*;
public class Collatz {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int x = sc.nextInt();
            int y = sc.nextInt();
            int k =sc.nextInt();
            if(x%y==0){
                x++;
                k--;
            }
            while(k>0){
                int c = (int)Math.ceil((double)x/(double)y);
                c*=y;
                int d = c-x;
                k-=d;
                if(d==0){
                    x++;
                    k--;
                }
                if(k<0){
                 x+=k;
                    break;
                }
              while(x%y==0){
                x/=y;
              }
            }
            System.out.println(x);
        }
    }
}
