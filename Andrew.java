import java.util.*;
public class Andrew{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            long a[] = new long[n];
            int count =0;
            for(int i =0;i<n;i++){
                a[i] = sc.nextLong();
                if((i!=0&&i!=n-1)&&a[i]==1){
                count++;
                }
            }
            int ans = 0;
            int even =0;
            int odd =0;
            if(count>0){
                System.out.println("-1");
            }
            else{
                int ans2 =0;
                int odd2 =0;
                int even2 = 0;
                for(int i =1;i<n-1;i++){
                    ans+=(Math.ceil((double)a[i]/2.0));
                    if(a[i]%2!=0){
                    odd++;
                    }
                    else{
                        even+=(a[i]/2);
                       if(even>=odd){
                       odd=0;
                       }
                       else{
                   odd=odd-even;
                       }
                       even =0;
                    }
                }
             for(int i = n-2;i>=1;i--){
                if(a[i]%2!=0){
                    odd2++;
                    }
                    else{
                        even2+=(a[i]/2);
                       if(even2>=odd2){
                        odd2=0;
                       }
                       else{
                   odd2=odd2-even2;
                       }
                       even2 =0;
                    }
             } 
             if(odd2<=0||odd<=0){
            System.out.println(ans);
             }  
             else{
                System.out.println("-1");
             }
            }
        }
    }
}