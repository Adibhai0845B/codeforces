import java.util.*;
public class diverse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while(t-->0){
        int n = sc.nextInt();
        int m = sc.nextInt();
        int totalscore =0;
        for(int i =0;i<n;i++){
            String s = sc.next();
           String find = "narek";
             int k = 0;
           for(int j =0;j<m;j++){
           if(s.charAt(i)==find.charAt(k)){
            k++;
            k=k%5;
           }
           else{
            score--;
           }
            }
        }
    }
}
}