import java.util.*;
public class diversegame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t  = sc.nextInt();
         while(t-->0){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int a[][] = new int[n][m];
            int b[][] = new int[n][m];
            for(int i =0;i<n;i++){
                for(int j =0;j<m;j++){
                a[i][j] = sc.nextInt();
                }
            }
            if(n==1&&m==1){
                System.out.println("-1");
            }
            else{
                if(m==1){
                    for(int i =0;i<n-1;i++){
                        int c = a[i][0];
                        a[i][0] = a[i+1][0];
                        a[i+1][0]=c;
                    }
                }
                else{
                for(int i=0;i<n;i++){
                    for(int j =0;j<m-1;j++){
                     int c = a[i][j];
                     a[i][j] = a[i][j+1];
                     a[i][j+1] = c;
                    }
                }
                }
            for(int i =0;i<n;i++){
                for(int j  =0;j<m;j++){
                    System.out.print(a[i][j]+" ");
                }
                System.out.println();
            }
        }
         }
    }
}
