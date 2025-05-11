import java.util.*;
public class Shell {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i =0;i<3;i++){
            int a= sc.nextInt();
            int b = sc.nextInt();
            if(n==a){
               n = b;
            }
            else if(n==b){
                n = a;
            }
        }
        System.out.println(n);
    }
}