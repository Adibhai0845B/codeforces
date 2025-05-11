import java.util.*;
public class SubString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t  = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int a[] = new int[n];
            int b[] = new int[n];
            int total1 =0;
            int total2 =0;
            int ans1 =0;
            int ans2 =0;
            for(int i =0;i<n;i++){
             a[i] =sc.nextInt();
             total1+=a[i];
            }
            for(int i =0;i<n;i++){
             b[i] = sc.nextInt();
              total2+=b[i];
            }          
            for(int i =0;i<n;i++){
            if(a[i]==-1&&b[i]==-1&&ans1==ans2){
                if(total1>total2){
                  ans1+=a[i];
                }
                else{
                    ans2+=a[i];
                }
            }      
            else if(a[i]==-1&&b[i]==-1&&ans1!=ans2){
               if(ans1>ans2){
                ans1+=a[i];
               }
               else{
                ans2+=a[i];
               }
            }
            else if(a[i]==1&&b[i]==1&&ans1==ans2){
                if(total1>total2){
                    ans2+=a[i];
                  }
                  else{
                      ans1+=a[i];
                  }
              }  
              else if(a[i]==1&&b[i]==1&&ans1!=ans2){
                if(ans1>ans2){
                 ans2+=a[i];
                }
                else{
                 ans1+=a[i];
                }
             }
             else{
      int c = Math.max(a[i],b[i]);
      if(ans1>ans2){
        ans2+=c;
      }
      else{
        ans1+=c;
      }
             }
            }
            System.out.println(Math.min(ans1,ans2));
        }
    }
}
