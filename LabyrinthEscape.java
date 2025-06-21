import java.util.*;

public class LabyrinthEscape {

    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
 int n = a.length();
        int m = b.length();

        int[][] a1 = new int[n + 1][m + 1];
    
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    a1[i][j] =(a1[i - 1][j - 1] + 1);
                } else {
                        a1[i][j] = Math.max(a1[i - 1][j],a1[i][j-1]);
                }
            }
        }

        String s ="";
        StringBuilder sbb =new StringBuilder(); 
        int i =n;
        int j =m;
        while(i>0&&j>0){
           if(a.charAt(i-1)==b.charAt(j-1)){
            sbb.append(a.charAt(i-1));
           i--;
           j--;
        }
           else if (a1[i-1][j]>=a1[i][j-1]){
                i--;
            }else{
         j--;
            }
        }
        s=sbb.reverse().toString();
       // System.out.println(s);
        StringBuilder sb = new StringBuilder();
         i = 0;
         j = 0;
        for (char c : s.toCharArray()) {
            while (i < a.length() && a.charAt(i) != c) {
                sb.append(a.charAt(i++));
            }
            while (j < b.length() && b.charAt(j) != c) {
                sb.append(b.charAt(j++));
            }
            sb.append(c);
            i++;
            j++;
        }
        sb.append(a.substring(i)).append(b.substring(j));
        System.out.println(sb.toString());
    }
}
