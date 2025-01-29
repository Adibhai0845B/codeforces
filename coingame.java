import java.util.*;
public class coingame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0){
            t--;
            int n = sc.nextInt();
            String  s = sc.next();
            int count =0;
          for(int i =0;i<n;i++){
            if(s.charAt(i)=='U'){
                count++;
            }
          }
         if(count%2!=0){
            System.out.println("YES");
         }
         else{
            System.out.println("NO");
         }
        }
    }
}