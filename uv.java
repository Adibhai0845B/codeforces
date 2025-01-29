import java.util.*;
public class uv{
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
   int n = sc.nextInt();
   int k = sc.nextInt()-1;
      int a[] = new int[n];for(int i =0;i<n;i++){
        a[i] =sc.nextInt();
      }    
      int count1 =0;
       for(int i =k;i<n-1;i++){
        if(a[i]!=a[i+1]){
           count1++;
           break;
        }
      }
      if(count1>0){System.out.println("-1");}
      else{System.out.println(k);}
}
}