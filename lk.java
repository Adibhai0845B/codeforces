import java.util.*;
/*
 AdiBhai0845R
  AdiBhai0845R
   AdiBhai0845R
    AdiBhai0845R
     AdiBhai0845R
      AdiBhai0845R
 */
public class lk {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int k = 3; // Change this value as per your requirement

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int sum = 0;
        int count = 0;
        HashMap<Integer, Integer> h1 = new HashMap<>();
        h1.put(0, 1); // Initialize with sum 0 having one count

        for (int i = 0; i < n; i++) {
            sum += a[i];
            if (h1.containsKey(sum - k)) {
                count += h1.get(sum - k);
            }
            h1.put(sum, h1.getOrDefault(sum, 0) + 1);
        }

        System.out.println(count);
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
}