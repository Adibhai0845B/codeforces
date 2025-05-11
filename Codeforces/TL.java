import java.util.*;
public class TL {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int a[] = new int[n];
        int b[]= new int[m];
        for(int i =0;i<n;i++){
            a[i] =sc.nextInt();
        }
        for(int i =0;i<m;i++){
            b[i] = sc.nextInt();
        }
        Arrays.sort(a);
        Arrays.sort(b);
        if(a[n-1]<=b[0]){
            System.out.println("-1");
        }
        else{

        }
    }
}
