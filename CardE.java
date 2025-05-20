import java.util.*;

public class CardE {
    static final int MOD = 998244353;
    public static void main(String[] args) {
  Scanner sc = new Scanner(System.in);
     int t = sc.nextInt();
        while(t-->0){
        int n = sc.nextInt();
          int fi = 0;
    int se = n - 1;
   int a[][] = new int[n][n];
      int curr = 0;
    int a1 = 0;
        int a2 = n - 1;  
        while (curr<n*n) {
      for (int i=a1;i<= a2;i++) {
          a[fi][i]=curr++;
            }
            fi++;
      for (int i=fi;i<=se;i++) {
    a[i][a2]=curr++;
            }
            a2--;
 if(fi<=se) {
      for(int i=a2;i>=a1;i--) {
       a[se][i] = curr++;
          }
         se--;
            }
            if (a1<=a2){
         for(int i = se; i >= fi;i--) {
          a[i][a1] = curr++;}
            a1++; }
        }
        for(int i =0;i<n;i++){
            for(int j =0;j<n;j++){
        a[i][j]=((n*(n))-1)-a[i][j];
            }
        }
        for (int[] yt:a) {
            for (int it : yt) {
                System.out.print(it+" ");
            }
            System.out.println();

    }
        }
    }}