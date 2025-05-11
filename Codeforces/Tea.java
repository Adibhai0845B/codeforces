import java.util.*;
public class Tea {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
       int n = sc.nextInt();
        if(n%2==0) System.out.println("NO");
        else{
           System.out.println("YES");
           int c = n/2;
           int truen = 2*n;
           int j = (2*n)-c;
            int i =1;
            int count =0;
           while(j<=truen){
              System.out.print(i+" ");
              i++;
              count++;
              System.out.print(j);
              j++;
              System.out.println();
           }
           i = c+2;
           j = (truen/2)+1;
           int count1 =0;
           while(count1!=count-1){
            System.out.print(i+" ");
            i++;
            count1++;
            System.out.print(j);
            j++;
            System.out.println();
           }
        }  
      }
 }
}
