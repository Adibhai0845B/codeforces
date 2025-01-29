import java.util.*;

public class Gamewith {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // Read number of test cases
        while (t-- > 0) {
            int n = sc.nextInt(); // Read number of elements in this test case
            long[][] a = new long[n][3]; // Array to hold the data
            long sum = 0;
            for (int i = 0; i < n; i++) {
                a[i][0] = sc.nextLong();
                sum += (a[i][0]-1);
             } 
             for(int i =0;i<n;i++){
                a[i][1] = sc.nextLong(); // Read the second value
                a[i][2] = a[i][0] + a[i][1] - 2; 
             }
             Arrays.sort(a, Comparator.comparingLong(o -> o[2])); // Sort based on the third value
            for (int i = n - 2; i >= 0; i -= 2) {
                sum -= a[i][2]; // Adjust the sum based on sorted third values
            }
            System.out.println(sum); // Print the result for this test case
        }
        sc.close(); // Close the scanner
    }
}
