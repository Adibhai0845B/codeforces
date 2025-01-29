import java.util.*;

public class SortZero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            
            // Find the position where the array stops being sorted from the end
            int index = n - 1;
            while (index > 0 && a[index - 1] <= a[index]) {
                index--;
            }
            
            // Now index is the point from where we need to consider sorting
            int ans = n - index; // initial length of the subarray to be sorted
            HashSet<Integer> seen = new HashSet<>();
            for (int i = 0; i < index; i++) {
                seen.add(a[i]);
            }
            for (int i = index; i < n; i++) {
                if (seen.contains(a[i])) {
                    ans = n - i;
                    break;
                }
            }
            
            System.out.println(ans);
        }
    }
}
