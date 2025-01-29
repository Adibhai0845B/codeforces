import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();  

        while (t-- > 0) {
            int n = sc.nextInt();  
            int o = n;
            int cv= 0;
            while (n > 0) {
                n /= 2;
                cv++;
            }
            System.out.println(cv);  int ko = 2; 
            int clp = 1;  
            for (int i = 1; i <= o; i++) {
                if (i == ko) {       ko *= 2; 
                   clp++;
                }
                System.out.print(clp + " ");
            }   System.out.println();
        }

        sc.close();
    }
}
