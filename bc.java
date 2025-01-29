import java.io.*;
import java.util.Arrays;

public class bc {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        // Reading number of test cases
        int t = Integer.parseInt(br.readLine().trim());
        
        while (t-- > 0) {
            // Reading n, m, q
            String[] line = br.readLine().trim().split(" ");
            int n = Integer.parseInt(line[0]);
            int m = Integer.parseInt(line[1]);
            int q = Integer.parseInt(line[2]);
            
            int[] aq = new int[m + 1];
            
            // Reading array elements
            line = br.readLine().trim().split(" ");
            for (int i = 1; i <= m; i++) {
                aq[i] = Integer.parseInt(line[i - 1]);
           System.out.println(aq.toString());
            }
            
            // Sorting the array
            Arrays.sort(aq, 1, m + 1);
            
            // Processing each query
            for (int i = 1; i <= q; i++) {
                int index = Integer.parseInt(br.readLine().trim());
                System.out.println(index);
                if (index < aq[1]) {
                    bw.write((aq[1] - 1) + "\n");
                } else if (index > aq[m]) {
                    bw.write((n - aq[m]) + "\n");
                } else {
                    // Binary search
                    int low = 1;
                    int high = m;
                    while (high > low) {
                        int mid = (low + high) / 2;
                        if (aq[mid] > index) {
                            high = mid;
                        } else {
                            low = mid;
                        }
                        if (low + 1 == high) break;
                    }
                    
                    // Output result
                    bw.write((aq[high] - aq[low]) / 2 + "\n");
                }
            }
        }
        
        // Closing BufferedWriter and BufferedReader
        bw.flush();
        bw.close();
        br.close();
    }
}
