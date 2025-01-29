import java.util.*;

public class Buyinggifts {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        while (t-- > 0) {
           ans(sc);
        }
    }
    private static void ans(Scanner sc) {
        int n = sc.nextInt();
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
 
        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));
        int[] suf = new int[n + 1];
        Arrays.fill(suf, -1);
        suf[n - 1] = arr[n - 1][1];
        for (int i = n - 2; i >= 0; i--)
            suf[i] = Math.max(suf[i + 1], arr[i][1]);
 
        TreeSet<Integer> st = new TreeSet<>();
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int mx = suf[i + 1];
            if (i != n - 1)
                ans = Math.min(ans, Math.abs(mx - arr[i][0]));
 
            if (mx < arr[i][0] && !st.isEmpty()) {
                Integer curr = st.higher(arr[i][0]);
                if (curr == null) {
                    curr = st.last();
                    ans = Math.min(ans, Math.abs(curr - arr[i][0]));
                } else {
                    ans = Math.min(ans, Math.abs(curr - arr[i][0]));
                    if (st.lower(curr) != null) {
                        curr = st.lower(curr);
                        ans = Math.min(ans, Math.abs(curr - arr[i][0]));
                    }
                }
            }
            st.add(arr[i][1]);
        }
        System.out.println(ans);
    }
}
