import java.util.*;
public class Catch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int x = sc.nextInt();
           int y = sc.nextInt();
           if(y==0){
            System.out.println("YES");
           }
           else if(x==0&&y<0){
        System.out.println("NO");
           }
           else if(x==0&&y>0){
            System.out.println("YES");
           }
           else{
            
           }
        }
    }
}
