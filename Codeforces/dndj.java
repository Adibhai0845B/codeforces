import java.util.*;

public class dndj {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt(); 
            int[] got = new int[n];
            for (int j = 0; j < n; j++) {
                got[j] = sc.nextInt();
            }
            Arrays.sort(got);
                List<Integer> gou = ok(got,n);
            if (gou.get(0) == -1) {
                System.out.println(-1);
            } else {
                System.out.println(gou.get(0));
                for (int p = 1; p < gou.size(); p++) {
                    System.out.print(gou.get(p) + " ");
                }
                System.out.println();
            }
        }
    }
    public static List<Integer> ok(int ku[],int n) {
        List<Integer> total = new ArrayList<>();
        while (ku[n-1] > 0) {
            List<Integer> lp = new ArrayList<>();
            for (int i : ku) {
                if (i != 0) {
                    lp.add(i);
                }
            }
            if (lp.size() > 1 && (lp.get(0) % 2) != (lp.get(1) % 2)) {
                return Arrays.asList(-1);
            }
            if (total.size() >= 40) {
                return Arrays.asList(-1);
            }
            int g = ku[0];
            int r = ku[n-1];
            int x = (g + r) / 2;
            total.add(x);
            List<Integer> mj = new ArrayList<>();
            for (int val : ku) {
                mj.add(Math.abs(val - x));
            }
            ku = mj.stream().mapToInt(Integer::intValue).toArray();
            Arrays.sort(ku);
        }
        List<Integer> lo = new ArrayList<>();
        lo.add(total.size());
        lo.addAll(total);
        return lo;
    }
}
