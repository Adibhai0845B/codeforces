import java.util.*;
public class closest2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
        int n = sc.nextInt();
        int a[] = new int[n];
        int b[] = new int[n-1];
        a[0] = sc.nextInt();
        for(int i=1;i<n;i++){
           a[i] = sc.nextInt();
        b[i-1] = Math.abs(a[i]-a[i-1]);
        }
        int m = sc.nextInt();
        while(m-->0){
            int x = sc.nextInt();
            int y = sc.nextInt();
            int sum =0;
            if(x<=y){
              for(int i =x-1;i<y-1;i++){
                if(i==0){
               sum+=1;
                }
               else{
                if(b[i-1]<b[i]){
                   sum+=b[i]; 
                }
                else{   
                    sum+=1;
                }
               }
              }
            }
            else{
                 for(int i=x-1;i>y-1;i--){
                    if(i==n-1){
                        sum+=1;
                    }
                    else{
                        if(b[i-1]>b[i]){
                        sum+=b[i-1];
                        }
                        else{
                            sum+=1;
                        }
                    }
    
                 }
            }
        System.out.println(sum);
        }
    }
    }
}
