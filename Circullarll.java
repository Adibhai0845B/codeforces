import java.util.*;

public class Circullarll {
    static final int MOD = 1_000_000_007;
    static final int MAX = 200005;
    static long[] fact = new long[MAX];
    static long[] invFact = new long[MAX];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        List<Event> events = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            events.add(new Event(l, +1));
            events.add(new Event(r + 1, -1)); 
        }        precompute();
        events.sort((a, b) -> {
            if (a.x != b.x) return Integer.compare(a.x, b.x);
            return Integer.compare(b.type, a.type);
        });

        long res = 0;
        int active = 0;

        for (int i = 0; i < events.size(); i++) {
            int currX = events.get(i).x;
            int j = i;
            while (j < events.size() && events.get(j).x == currX) {
                active += events.get(j).type;
                j++;
            }

            if (j < events.size()) {
                int nextX = events.get(j).x;
                long len = nextX - currX; // number of integer points

                if (active >= k) {
                    res += (len * nCr(active, k)) % MOD;
                    res %= MOD;
                }
            }

            i = j - 1;
        }

        System.out.println(res);
    }

    static void precompute() {
        fact[0] = invFact[0] = 1;
        for (int i = 1; i < MAX; i++) {
            fact[i] = fact[i - 1] * i % MOD;
        }
        invFact[MAX - 1] = modInverse(fact[MAX - 1]);
        for (int i = MAX - 2; i >= 1; i--) {
            invFact[i] = invFact[i + 1] * (i + 1) % MOD;
        }
    }

    static long nCr(int n, int r) {
        if (r < 0 || r > n) return 0;
        return fact[n] * invFact[r] % MOD * invFact[n - r] % MOD;
    }

    static long modInverse(long a) {
        return pow(a, MOD - 2);
    }

    static long pow(long a, long b) {
        long res = 1;
        while (b > 0) {
            if ((b & 1) == 1) res = res * a % MOD;
            a = a * a % MOD;
            b >>= 1;
        }
        return res;
    }

    static class Event {
        int x, type;
        Event(int x, int type) {
            this.x = x;
            this.type = type;
        }
    }
}
