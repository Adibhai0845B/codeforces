import java.util.*;
public class NonCoprime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0){
            t--;
            int l = sc.nextInt();
            int r = sc.nextInt();
            if(r<4){
                System.out.println("-1");
            }
            else{
                int count =0;
            for(int i =2;i<l;i++){
                for(int j = l;j<=r;j++){
                    if(i+j>=l&&i+j<=r&&gcd(i,j)!=1){
                            System.out.println(i+" "+j);
                            count++;
                            break;
                    }
                }
                if(count>0){
                    break;
                }
            }
        }
    }}
    public static int gcd(int a,int b){
        if (b == 0) {
            return a;
        }
            return gcd(b, a % b);
    }
}
