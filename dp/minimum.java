import java.util.*;
public class minimum {
    public static void main(String[] args) {
        Scanner  sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        a[0] = sc.nextInt();
        int max =0;
        ArrayList<Integer>a1 = new ArrayList<>();
        for(int i = 1;i<n;i++){
            a[i] = sc.nextInt();
          max = Math.max(a[i]-a[i-1],max);
        }
        
    }
}
