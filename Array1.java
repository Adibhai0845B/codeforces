import java.util.*;
public class Array1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0){
            t--;
            int n = sc.nextInt();
            long a[] = new long[n];
            ArrayList<Long> a1 = new ArrayList<>();
            for(int i =0;i<n;i++){
                a[i] = sc.nextLong();
             a1.add(a[i]);
            }
            Collections.sort(a1, Collections.reverseOrder());
            if(a1.contains(1)){
                System.out.println("Yws");
            }
            else{
            for(int i =n-1;i>=0;i++){
                             
            }
        }
    }
    }
}
