import java.util.*;
public class DA{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int n  =sc.nextInt();
            int a[] = new int[n];
            HashSet<Integer> h1 = new HashSet<>();
            for(int i =0;i<n;i++){
             h1.add(sc.nextInt());
            }
            if(h1.size()==n){
                System.out.println("2");
            }
            else if(h1.size()==n-1){
             System.out.println(n);
            }
            else{
            System.out.println(n-h1.size()+2);
            }
        }
    }
}
