import java.util.*;
public class grouping {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int a[] = new int[n];
        for(int i =0;i<n;i++){
            a[i] = sc.nextInt();
        }
        Arrays.sort(a);
        int currsum =0;
        int size =0;
        int group =0;
       int min = Integer.MAX_VALUE;
       int max = Integer.MIN_VALUE;
        for(int i =0;i<n;i++){
              if(a[i]<min) min = a[i];
              if(a[i]>max) max = a[i];
              currsum = max-min;
              size++;
              if(size>k||currsum>m){
                group++;
                currsum =0;
                size=0;
                i--;
                min = Integer.MAX_VALUE;
                max = Integer.MIN_VALUE;
              }
        }
        System.out.println(group+1);
    }
}