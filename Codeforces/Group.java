import java.util.*;
public class Group {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int a[][] = new int[m][2];
        int sum =0;
        for(int i =0;i<m;i++){
            a[i][0] = sc.nextInt();
            sum+=a[i][0];
            a[i][1] = sum;
        }
        int x = sc.nextInt();
        int y = sc.nextInt();
        int count =0;
   for(int i =0;i<m;i++){
           if(a[i][1]>=x&&a[i][1]<=y&&(sum-a[i][1])<=y&&(sum-a[i][1])>=x){
             count++;
            System.out.print(i+2);
            break;
           }
   }
   if(count==0){
    System.out.println("0");
   }
    }
}
