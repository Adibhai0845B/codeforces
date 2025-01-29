import java.util.Scanner;

public class answer {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        
        // Call the sb method and print the result
        System.out.println(sb(n, k));
    }
    
    public static String sb(int n, int k) {
        // Initialize a StringBuilder to build the output string
        StringBuilder a = new StringBuilder();
        if (k > n ||k==1&&n!=1){
            return "-1";
        } 
        else if(n==1){
                return "a";
        }
            else {
            //System.out.println(n-k+2);
            for (int i = 0; i <n - k+2&&i<n;) {
                    a.append('a');
                    i++;
                if (i<n-k+2) {
                    a.append('b');
                    i++;
                }
            }
            int cha = 0;
            for (int i = n - k+2; i < n; i++) {
                a.append((char)('c' + cha));
                cha++;
            }
            return a.toString();
        }
    }
}
