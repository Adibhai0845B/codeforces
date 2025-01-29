import java.util.*;
public class aaaa {
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while(t-->0){
        int n = sc.nextInt();
        int min = n;
    long a[] = new long[n];
    for(int i =0;i<n;i++){
      a[i] = sc.nextLong();
    }  
   for(int i =0;i<n;i++){
    int in = i;
    for(int j = i+1;j<n;j++){
      if(a[j]>a[i]){
        in++;
      }
    }
   min = Math.min(min,in);
   }
   System.out.println(min);
  }
}    
}