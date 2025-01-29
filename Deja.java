import java.util.*;
public class Deja {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0){
            t--;
            int n = sc.nextInt();
            int q = sc.nextInt();
            long a[][] = new long[n][2];
            for(int i =0;i<n;i++){
                a[i][0]  = sc.nextLong();
        a[i][1] = i;
            }
            int x[] = new int[q];
            for(int i =0;i<q;i++){
              x[i] = sc.nextInt();
            }
            Arrays.sort(a, Comparator.comparingLong(o -> o[0]));
            Arrays.sort(x);
            for(int i =0;i<n;i++){
          for(int j =0;j<q;j++){
            if(a[i][0]%Math.pow(2,x[j])==0){
                a[i][0]+=Math.pow(2,x[j]-1);
            }
            else if(Math.pow(2,x[j])>a[i][0]){
                break;
            }
          }
            }
       Arrays.sort(a,Comparator.comparingLong(o->o[1]));
       for(int i =0;i<n;i++){
      System.out.print(a[i][0]+" ");   
    }
    System.out.println();
        }
    }
}