import java.util.*;
public class ArrayGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0){
            t--;
            int n = sc.nextInt();
            int k = sc.nextInt();
            long a[] = new long[n];
            Stack<Long> s1 = new Stack<>();
          for(int i =0;i<n-1;i++){
             a[i] = sc.nextLong();
            s1.push(a[i]);
          }
          Arrays.sort(a);
          long min = Long.MAX_VALUE;
          if(k==1){
         for(int i =0;i<n-1;i++){
            if(min>Math.abs(a[i]-a[i+1])){
          min = Math.abs(a[i]-a[i+1]);
            }
         }
         System.out.println(min);
          }
        else if(k==2){
          for(int i =0;i<n-1;i++){
            for(int j = i+1;j<n;j++){
                long d = Math.abs(a[i]-a[j]);
                s1.push(d);
            }
          }
        }
        else{

        }
        }
    }
}
