import java.util.*;
public class Chess{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0){
            t--;
            int p1 = sc.nextInt();
            int p2 = sc.nextInt();
            int p3 = sc.nextInt();
             int count =0;
            if(p1%2!=0){
                count++;
            }
            if(p2%2!=0){
                count++;
            }
            if(p3%2!=0){
                count++;
            }
            if(count==3||count==1){
                System.out.println("-1");
            }
            else{
                int sum =0;
                if(p1+p2>p3){
                    int c = (p1+p2-p3)/2;
                    System.out.println(p3+(c));    
                }
                else if(p1+p2==p3){
                System.out.println(p3);
            }
            else{
                System.out.println(p1+p2);
            }
        }
        }
    }
}