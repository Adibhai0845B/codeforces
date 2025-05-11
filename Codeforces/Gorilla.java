import java.util.*;
public class Gorilla {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();
            Deque<Long> q1 = new ArrayDeque<>();
         for(long i = n;i>=k;i--){
            q1.add(i);
         }
         for(long i = m+1;i<k;i++){
       q1.add(i);
         }        
         for(long i =1;i<=m;i++){
            q1.addLast(i);
         }
         for(long q:q1){
            System.out.print(q+" ");
         }
         System.out.println();
        }
    }
}
