// AbdiBhai0845R
// AbdiBhai0845R
// AbdiBhai0845R
// AbdiBhai0845R
// AbdiBhai0845R
import java.util.*;
import java.io.*;
public class op {
    //static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0) {
            int n = sc.nextInt();
            int[] nums = new int[n];
            for(int j = 0;j < n;j++) {
                nums[j] = sc.nextInt();
            }
            int[] cnt = new int[n+1];
            for(int num : nums) {
                cnt[num]++;
                if(cnt[num] > 2) {
                    System.out.println("NO");
                    return;
                }
            }
            List<Integer> zero = new ArrayList<>();
            List<Integer> two = new ArrayList<>();
            for(int num = 1;num <= n;num++) {
                if(cnt[num] == 0) {
                    zero.add(num);
                }else if(cnt[num] == 2) {
                    two.add(num);
                }
            }
            Map<Integer,Integer> map = new HashMap<>();
            for(int i = 0;i < two.size();i++) {
                if(zero.get(i) > two.get(i)) {
                    System.out.println("NO");
                    return;
                }else {
                    map.put(two.get(i), zero.get(i));
                }
            }
            int[] p = new int[n];
            int[] q = new int[n];
            for(int i = 0;i < n;i++) {
                int num = nums[i];
                if(cnt[num] == 1) {
                    p[i] = num;
                    q[i] = num;
                }else if(cnt[num] == 2){
                    p[i] = num;
                    q[i] = map.get(num);
                    cnt[num]++;
                }else {
                    q[i] = num;
                    p[i] = map.get(num);
                }
            }
            System.out.println("YES");
            for(int num : p) {
               System.out.print(num + " ");
            }
           System.out.println();
            for(int num : q) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
