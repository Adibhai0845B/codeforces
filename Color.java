import java.util.*;

public class Color {
    public static void main(String args[]){
    Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
     while (t-->0) {
        int n = sc.nextInt();
        int a[][] = new int[n][2];
        for(int i =0;i<n;i++){
            a[i][0] = sc.nextInt();
          a[i][1] = a[i][0]+i+1;   
        }
           Arrays.sort(a,Comparator.comparingInt(o->o[1]));
           
       }
    }
}
