import java.util.*;
public class RomanticGlasses {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt(); 
            long[] a = new long[n];
        long date = 0;
        long lulia =0;
        HashSet<Long> h1 = new HashSet<>();    
        for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
               if(i%2==0) lulia+=a[i];
               else lulia-=a[i];
                  if(h1.contains(lulia)||lulia==0)  date = 1;
               h1.add(lulia);
            }
          if(date==1){
            System.out.println("YES");
          }
          else{
            System.out.println("NO");
          }
        }
    }
}
