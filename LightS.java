/*
 * Adibhai0845R
 * AdiBhai0845R
 * * AdiBhai0845R
 * * AdiBhai0845R
 */
import java.util.*;

public class LightS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();
        while (t-- > 0) {
            int n = sc.nextInt();
            long k = sc.nextLong();
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextLong();
            } Arrays.sort(arr); long ok = 2 * k;long[] todo = new long[(int) ok];Arrays.fill(todo, 0);  for (int i = 0; i < n; i++) {     todo[(int) (arr[i] % ok)] = arr[i];
            } List<Long> jh = new ArrayList<>();
            long yt = -1;
            long ad = 0;
            for (int i = 0; i < ok; i++) {
                if (todo[i] != 0) {          if (yt != -1) {             jh.add((long) i - yt);
                    } else {            ad = i;}
                  yt = i;
                }
            }
            jh.add(ad + ok - yt);

            long how = Collections.max(jh);
             long mo= 0;
            boolean get = false;

            for (int i = 0; i < jh.size(); i++) {
                if (jh.get(i) == how && !get) {
                    jh.set(i, 1L);           get  = true; }
                mo += jh.get(i);
            }

            if (mo > k) {
                System.out.println("-1");
                continue;
            }    long se = Arrays.stream(todo).max().getAsLong();
            for (int o = 0; o < ok; o++) {
                if (todo[o] != 0 && todo[o] < se) {
                    long uytr = (se - todo[o]) % ok;        long bhdj = (se - todo[o]) / ok;
                    if (uytr> k)bhdj++;

                    todo[o] += (ok * bhdj);
                }
            }
  System.out.println(Arrays.stream(todo).max().getAsLong());
        }
        sc.close();
    }
}
