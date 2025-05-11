import java.util.*;
public class RObinHood {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
         int n = sc.nextInt();
         String s = sc.next();
         HashSet<Character> h1 = new HashSet<>();
          long fina =0;
         for(int i =0;i<n;i++){
           h1.add(s.charAt(i));
           fina+=h1.size();
        }
            System.out.println(fina);
        }
    }
}
