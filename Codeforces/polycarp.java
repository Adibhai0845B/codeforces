import java.util.*;
public class polycarp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
            Integer a[] = new Integer[n];
            for(int i =0;i<n;i++){
                a[i] = sc.nextInt();
                }
            Arrays.sort(a);
  int j =1;
           for(int i =0;i<n;i++){
            if(a[i]<j) continue;
             else j++;
           }
            System.out.println(j-1);
        }
    }