import java.util.*;
public class Mocha {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0){
            t--;
            int n = sc.nextInt();
            long a[] = new long[n];
            int count =0;
            for(int i =0;i<n;i++){
                a[i] = sc.nextLong();
              if(a[i]==1){
                count++;
              }
            }
            if(count>=1){
                System.out.println("Yes");
            }
            else{
            Arrays.sort(a);
            int j = 0;
            int k = 1;  
            int count1 =0;
            for(int i =0;i<n;i++){
                if(a[j]>a[0]&&a[k]>a[0]){
                    count1++;
                    break;
                }
                if(a[i]%a[j]!=0&&a[i]%a[k]!=0){
                       k++;
                       i = 0;    
                }
                if(k==n-1){
              j++;
                }
            }
            if(count1>0){
                System.out.println("No");
            }
            else{
                System.out.println("Yes");
            }
            }
        }
    }
}
