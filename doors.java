import java.util.*;
public class doors{
public static void main(String[] args) {
    Scanner  sc = new Scanner(System.in);
    int t = sc.nextInt();
    while(t-->0){
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d =sc.nextInt();
        int f =0;
        int s= 0;
        int f2 =0;
        int s2= 0;
      if(c<a){
       f2 =a;
       s2 = b;
       f = c;
       s = d;
      }
      else{
          f = a;
          s = b;
          f2 =c;
          s2 = d;
      }
      if(f==f2){
        if(s==s2){
            System.out.println(s2-f2);
        }
        else{
            int min =Math.min(s,s2);
            System.out.println(Math.abs(f-min+1));
        }
      }
      else{
        if(s<=f2){
            System.out.println("1");
        }
        else{
          if(s==s2){
              System.out.println(s2-f2+1);
          }
          else if(s2>s){
            int min = Math.min(s,s2);
            System.out.println(Math.abs(f2-min-1));
          }
          else{
            System.out.println(s2-f2+2);
          }
        }
      }
    }
}
}