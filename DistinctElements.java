import java.util.HashMap;
import java.util.Scanner;
public class DistinctElements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
        int n = sc.nextInt();
        int[] a = new int[n];
        
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        // HashMap to count occurrences of elements
        HashMap<Integer, Integer> countMap = new HashMap<>();
        int distinctCount = 0; // Number of distinct elements
        int minDistinct = Integer.MAX_VALUE; // Minimum distinct elements in any subarray

        // Two pointers approach
        for (int left = 0; left < n; left++) {
            // Reset the count map and distinct count for each new left pointer
            countMap.clear();
            distinctCount = 0;

            for (int right = left; right < n; right++) {
                // Add the current element to the count map
                countMap.put(a[right], countMap.getOrDefault(a[right], 0) + 1);
                
                // If it's the first occurrence of the element, increase distinct count
                if (countMap.get(a[right]) == 1) {
                    distinctCount++;
                }

                // Update the minimum distinct count
                minDistinct = Math.min(minDistinct, distinctCount);
            }
        }

        System.out.println(minDistinct);
    }
}}