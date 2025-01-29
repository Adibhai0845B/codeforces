import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Building {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[] a = new int[n];
            
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }
            
            Arrays.sort(a);
            long ans = 0;
            for (int i = 0; i < n; i++) {
                ans += Math.abs(a[i] - (i + 1));
            }
            System.out.println(ans);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
