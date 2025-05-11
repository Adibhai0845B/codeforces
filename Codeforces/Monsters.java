import java.util.*;
public class Monsters {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            long k = sc.nextLong();
            long a[][] = new long[n][2];
            for(int i =0;i<n;i++){
             a[i][0] = sc.nextInt();
              a[i][1] = i+1;
              if(a[i][0]%k!=0){
                a[i][0]=a[i][0]%k; 
              }
            }
            Arrays.sort(a, Comparator.comparingLong(o -> o[0]));
                    for(int i =0;i<n;i++){
                        System.out.print(a[i][1]+" ");
                    }
                    System.out.println();
        }
    }
}
