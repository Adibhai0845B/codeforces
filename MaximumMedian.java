import java.util.*;

public class MaximumMedian {

    static final int MAXN = 400005;
    static final long INF = (long) 1e18;
    static final int MOD = 1000000007;

    static void push(Scanner sc) {
        int n = sc.nextInt();
        int m = sc.nextInt();
        long k = 0, kp = 0, res = 0;
        Set<Integer>[] s1 = new HashSet[n];
        List<Integer>[] v1 = new ArrayList[n];

        for (int i = 0; i < n; ++i) {
            int q = sc.nextInt();
            k += q;
            s1[i] = new HashSet<>();
            for (int j = 0; j < q; ++j) {
                int z = sc.nextInt();
                s1[i].add(z);
            }
        }

        for (int i = 0; i < n; ++i) {
            v1[i] = new ArrayList<>();
            for (int j : s1[i]) {
                if (j <= k) {
                    v1[i].add(j);
                }
            }
        }

        for (int i = 0; i < n; ++i) {
            List<Integer> iList = v1[i];
            int m1 = -1, m2 = -1, pp = 0;
            int sz = iList.size();
            for (int j = 0; j < sz && m2 == -1; j++) {
                if (iList.get(j) != pp) {
                    if (m1 == -1) m1 = pp;
                    else m2 = pp;
                    pp++;
                    j--;
                } else pp++;
            }
            if (m1 == -1) m1 = sz;
            if (m2 == -1) m2 = sz + 1;
            kp = Math.max(kp, Math.max(m1, m2));
        }

        if (kp > m) {
            res = kp * m + kp;
        } else {
            res = m;
            res = (res * (res + 1)) / 2;
            res += (kp * (kp + 1)) / 2;
        }
        System.out.println(res);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for (int t = 1; t <= tc; t++) {
            push(sc);
        }
        sc.close();
    }
}
