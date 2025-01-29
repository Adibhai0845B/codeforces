import java.util.*;
public class Sort2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
        int n = sc.nextInt();
        int a[] = new int[n+1];
        for(int i  = 1;i<n;i++){
            int c = sc.nextInt();
            int b = sc.nextInt();
             a[c]++;
             a[b]++;
        }
        int k =1;
        for(int i =1;i<=n;i++){
            if(a[i]==1)k++;
        }
        System.out.println(k/2);
        }
    }           
    }