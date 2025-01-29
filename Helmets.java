import java.util.*;
public class Helmets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while (t > 0) {
            t--;
            int n= sc.nextInt();
            int p = sc.nextInt(); 

            int[][] a = new int[n][2];

            // Reading quantities
            for (int i = 0; i < n; i++) {
                a[i][0] = sc.nextInt();
            }
            for (int i = 0; i < n; i++) {
                a[i][1] = sc.nextInt();
            }
  int z = n;
            Arrays.sort(a, Comparator.comparingInt(o -> o[1]));
            int sum2 = p;
              n-=1;
            //  System.out.println(sum2+" "+n);
               for(int i =0;i<z;i++){
            if(p<a[i][1]){
                break;
            }
            else{
                if(n<a[i][0]){
                sum2+=(n*a[i][1]);
             //   System.out.println(n+"p");
                n =0;
             }
                else{
                    sum2+=(a[i][0]*a[i][1]);
                  //  System.out.println(n+"w");
                     n-=a[i][0];
                }
              //  System.out.println(n+" "+i);
                //System.out.println(sum2);
            }
        }
        int c =0;
        if(n>0){
            c =  n*p;
        }
            System.out.println(sum2+c);
        }
    }
}
