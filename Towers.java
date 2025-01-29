import java.util.*;
/*
 AdiBhai0845R
  AdiBhai0845R
   AdiBhai0845R
    AdiBhai0845R
     AdiBhai0845R
      AdiBhai0845R
 */
public class Towers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        HashSet<Integer> h1 = new HashSet<>();
        HashMap <Integer,Integer> h2 =new HashMap<>();
        int count =0;
        for(int i=0;i<n;i++){
            a[i] = sc.nextInt();
            h2.put(a[i], h2.getOrDefault(a[i], 0) + 1);
            h1.add(a[i]);
        }
        for(int i:h2.values()){
            if(i>count){
                count = i;
            }
        }
  System.out.println(count+" "+h1.size());
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