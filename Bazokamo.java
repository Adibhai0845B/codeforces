import java.util.*;
public class Bazokamo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0){
            t--;
            int n = sc.nextInt();
            int a[]= new int[n];
            int count =0;
           for(int i =0;i<n;i++){
          a[i] = sc.nextInt();
           }
           for(int i =1;i<n;i++){
                   if(a[i]<=a[0]){
                count = i;
                break;
                   }
           }
        //   System.out.println(count);
           int count1 =0;
           if(count==0){
            System.out.println("Yes");
           }
           else{
           for(int i = count+1;i<n;i++){
         if(a[i]>a[0]||a[i]<a[i-1]){
                 count1++;
           break;
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
