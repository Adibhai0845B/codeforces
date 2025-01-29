import java.util.*;
public class DoubleSort {
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
   int t = sc.nextInt();
   while(t-->0){
    int n = sc.nextInt();
    long a[] = new long[n];
    for(int i =0;i<n;i++){
        a[i] = sc.nextLong();
    }
    if(!hash(a)){
      System.out.println("NO");
    }
    else{
        System.out.println("YES");
        Arrays.sort(a);
        int j = a.length-2;
        int i =0;
       while(j>=i){
       System.out.print(a[i]+" ");
       i++;
       if(j>i){
         System.out.print(a[j]+" ");
   j--;
       }
        }
        System.out.print(a[n-1]);
        System.out.println();
    }
   }
}
    public static boolean hash(long a[]){
        int n = a.length;
   HashMap<Long,Integer> h1 = new HashMap<>();
    for(int i =0;i<n;i++){
       h1.put(a[i],h1.getOrDefault(a[i], 0)+1);
}
for(int c:h1.values()){
    if(c>(n/2)){
     return false;
    }
}
return true;
    }
    }