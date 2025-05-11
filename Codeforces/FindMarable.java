import java.util.*;
public class FindMarable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();
        int t = sc.nextInt();
          int a[] = new int[n+1];
          for(int i =1;i<=n;i++){
             a[i] = sc.nextInt();
          }
          int i = s;
          int count =0;
          int p[] = new int[n+1];
          int ne  =0;
          boolean ans =true;
          while(i!=t&&i<=n){
           ne = a[i];
           count++;
            p[i]++;
            if(p[i]>1){
                ans =false;
                break;
            }
            i = ne;
          }
          if(!ans){
            System.out.println("-1");
          }
          else{
            System.out.println(count);
          }
             }    
    }
