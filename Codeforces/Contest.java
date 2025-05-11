import java.util.*;
public class Contest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();   
        int e = expr(a, c);
        int f = expr(b, d);
        if(e==f){
            System.out.println("Tie");
        }
        else if(e>f){
            System.out.println("Misha");
        }
        else{
            System.out.println("Vasya");
        }
    }
    static int expr(int a,int b){
        int c =Math.max((3*a)/10,(a-((a/250)*b)));
      return c;
    }
}
