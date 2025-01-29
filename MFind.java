import java.util.*;

public class MFind{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int  t = sc.nextInt();
        while(t-->0){
        int n = sc.nextInt();
        int x = sc.nextInt();
        int max_value = 0;
        PriorityQueue<Integer> q1 = new PriorityQueue<>();
        Map<Integer, Integer> ty = new HashMap<>();
        Map<Integer, Boolean> q1r = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int k = sc.nextInt();
            ty.put(k, ty.getOrDefault(k, 0) + 1);
            if (ty.get(k) == 1) { 
                q1.add(k); 
               q1r.put(k, true);
            }
        }
        while (!q1.isEmpty()) {
            int isy = q1.poll();
           q1r.put(isy, false);
            if (isy > max_value) break;
            if (isy == max_value) {
                max_value++;
                ty.put(isy,ty.get(isy) - 1);
                int gy =isy+ x;
               ty.put(gy, ty.getOrDefault(gy, 0) + ty.get(isy));
                if (ty.get(gy) > 0 && !q1r.getOrDefault(gy, false)) {
                    q1.add(gy);
                    q1r.put(gy, true);
                }
                continue;
            }
            int s = (max_value - isy + (x - 1)) / x;
            int gen =isy + x * s;
          ty.put(gen, ty.getOrDefault(gen, 0) + ty.get(isy));
            ty.put(isy, 0);

            if (!q1r.getOrDefault(gen, false)) {
                q1.add(gen);
               q1r.put(gen, true);
            }
        }
        System.out.println(max_value);
    }
}
}
