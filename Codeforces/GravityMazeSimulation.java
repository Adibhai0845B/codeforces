import java.util.Scanner;

public class GravityMazeSimulation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();sc.nextLine();
            char[][] a = new char[n][m];
            for (int i=0;i<n;i++) {
                a[i] = sc.nextLine().toCharArray();
            }
            funct2(a, n, m);
            for (char[] ch : a) {
                System.out.println(new String(ch));
            }
            if (t > 0) System.out.println();
        }
        sc.close();
    }
    private static void funct2(char[][] a, int n, int m) {
        for (int j =0;j<m;j++) {
            int seeg = n - 1;
   for (int ch = n - 1; ch >= 0; ch--) {
       if (a[ch][j]=='o') {  seeg = ch - 1;
           } else if(a[ch][j]=='*') {
            if (ch!=seeg) {
              a[seeg][j] = '*';
               a[ch][j] = '.';
                    }
              seeg--;
    }
         }
      }
    }
}
