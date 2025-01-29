import java.util.*;
/*
 AdiBhai0845R
  AdiBhai0845R
   AdiBhai0845R
    AdiBhai0845R
     AdiBhai0845R
      AdiBhai0845R
 */
public class Wonderful {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int a[]=  new int[n];
    int b[] = new int[n];
    int c [] = new int[n];
     int sum1 =0;
     int sum2 =0;
    for(int i =0;i<n;i++){
        a[i] = sc.nextInt();
         sum2+=a[i];
    }
    b[0]=0;
    sum2-=a[0];
    c[0]=sum2;
    for(int i =1;i<n;i++){
        sum1+=a[i-1];
        b[i]= sum1;
        sum2-=a[i];
        c[i]=sum2; 
    }
         Arrays.sort(b);
         Arrays.sort(c);
         System.out.println(Arrays.toString(b));
         System.out.println(Arrays.toString(c));
         int p = b[0]*c[0];
         int q = b[0]*c[n-1];
         int r = b[n-1]*c[0];
         int s = b[n-1]*c[n-1];
         int f = Math.max(Math.max(p,q),Math.max(r,s));
         System.out.println(f);
}
  public static int gcd(int a, int b){
        if (b == 0)  return a;
        else return gcd(b, Math.abs(a - b));
    }
   public  static int lcm(int x, int y)  {  
return (x / gcd(x, y)) * y;  
  }
  public static void sort(int a[]){
    Arrays.sort(a);
  }  
  public static int binarySearch(int[] array, int target) {
    int left = 0;
    int right = array.length - 1;

    while (left <= right) {
        int mid = left + (right - left) / 2;

        // Check if target is present at mid
        if (array[mid] == target) {
            return mid;
        }

        // If target is greater, ignore the left half
        if (array[mid] < target) {
            left = mid + 1;
        } else {
            // If target is smaller, ignore the right half
            right = mid - 1;
        }
    }
    return -1;
}
public static HashMap hashmap(int a[]){
    HashMap<Integer,Integer> h1 = new HashMap<Integer,Integer>();
   for(int i :a){
     h1.put(i,h1.getOrDefault(i,0)+1);
   }
   return h1;
}
}