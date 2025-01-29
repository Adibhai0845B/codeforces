import java.util.*;
public class Equalize {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0){
            t--;
            int n = sc.nextInt();
            Integer a[] = new Integer[n];
            for(int i =0;i<n;i++){
                a[i] = sc.nextInt();
            }
            int b[] = new int[n-1];
        Arrays.sort(a, Collections.reverseOrder());
       for(int i =0;i<n-1;i++){
                b[i] = a[i]-a[i+1];
       }
       int count =1;
       for(int i =1;i<n-1;i++){
           if(b[i]%i==0){
            count++;
           }
       }
       System.out.println(count);
        }
    }
}
