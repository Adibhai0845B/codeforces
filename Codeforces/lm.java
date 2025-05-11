/*import java.util.*;

public class lm {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			int pos = 0, neg = 0, x;
			boolean f = true;
			ArrayList<Integer> list = new ArrayList<>();
			HashSet<Integer> set = new HashSet<>();
			for (int i = 0; i < n; ++i) {
				x = sc.nextInt();
				set.add(x);
				if (x < 0) {
					++neg;
					list.add(x);
				} else if (x > 0) {
					++pos;
					list.add(x);
				} else {
					if (f) {
						list.add(x);
						f = false;
					}
				}
			}
			f = true;
			if (pos > 2 || neg > 2) {
				f = false;
			} else {
				n = list.size();
				for (int i = 0; i < n; ++i) {
					for (int j = i+1; j < n; ++j) {
						for (int k = j+1; k < n; ++k) {
							if (!set.contains(list.get(i) + list.get(j) + list.get(k))) {
								f = false;
							}
						}
					}
				}
			}
			System.out.println(f ? "YES" : "NO" );
		}

	}

}
*/
import java.util.*;

public class lm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            long a[] = new long[n];
            HashSet<Long> h1 = new HashSet<>();
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
                h1.add(a[i]);
            }
            boolean found = false;
            for (int i = 0; i < n - 2; i++) {
                for (int j = i + 1; j < n - 1; j++) {
                    for (int k = j + 1; k < n; k++) {
                        long sum = a[i] + a[j] + a[k];
                        if (h1.contains(sum)) {
                            found = true;
                            break;
                        }
                        else{
                            found = false;
                          break;
                        }
                    }
                    if (!found) break;
                }
                if (!found) break;
            }
            if (found) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        sc.close();
    }
}
