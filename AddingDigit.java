/*import java.util.*;
public class AddingDigit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int n =sc.nextInt();
        StringBuilder sb = new StringBuilder();
        String s = sc.next();
        StringBuilder sy = new StringBuilder();
        String sv  = sc.next();
        sb.append(a);
        sy.append(a);
        for(int i =0;i<n;i++){
            sb.append('0');
            sy.append('9');
        }
      s=  sy.toString();
       sv =   sb.toString();
        int min = Integer.parseInt(sv);
        int max = Integer.parseInt(s);
        int count =0;
        for(int i = min;i<=max;i++){
            if(i%b==0){
                System.out.println(i);
                count++;
                break;
            }
        }
        if(count==0){
            System.out.println("-1");
        }
    }
}
*/
/* 
import java.util.*;
public class AddingDigit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         int n = sc.nextInt();
           int a[][] = new int[n][2]; 
         for(int i =0;i<n;i++){
        a[i][0] = sc.nextInt();
        a[i][1] = sc.nextInt();
          }
Arrays.sort(a, Comparator.comparingInt(oPriorityQueue<Queue> q1 = new PriorityQueue<>((a,b),a-b); -> o[0]));

  int count =0;
  int r =0;
for(int i =1;i<n;i++){
    if(a[i][0]>a[r][0]&&a[i][1]<a[r][1]){
      count++;
    }
    else{
        for(int j = r+1;j<i;j++){
            if(a[i][0]>a[j][0]&&a[i][1]<a[j][1]){
                r = j;
                count++;
                break;
            }
        }
    }
}
System.out.println(count);
        }
    }
*/
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class AddingDigit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] a = new int[n][2];

        for (int i = 0; i < n; i++) {
            a[i][0] = sc.nextInt(); 
            a[i][1] = sc.nextInt(); 
        }
        Arrays.sort(a, Comparator.comparingInt((int[] o) -> o[0]).thenComparingInt(o -> o[1]));

        int count = 0;
        int r = 0;

        for (int i = 1; i < n; i++) {
            if (a[i][0] > a[r][0] && a[i][1] < a[r][1]) {
                count++;
            } else {
                r = i;
            }
        }

        System.out.println(count);
    }
}
