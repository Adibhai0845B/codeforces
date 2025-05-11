import java.util.*;

public class Luo{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int T = scanner.nextInt();
            while(T-- > 0){
                int n = scanner.nextInt();
                int m = scanner.nextInt();
                Set<Integer> set = new TreeSet<>();
                int cnt1 = 0, cnt2 = 0;
                for(int i = 0; i < n; i++){
                    int x = scanner.nextInt();
                    if(x == -1) cnt1++;
                    else if(x == -2) cnt2++;
                    else set.add(x);
                }
                int res = Math.min(m, Math.max(cnt1, cnt2) + set.size());
                int i = 0;
                for(int x : set){
                    int l = Math.min(x - 1, i + cnt1);
                    int r = Math.min(m - x, set.size() - 1 - i + cnt2);
                    res = Math.max(res, l + r + 1);
                    i++;
                }
                System.out.println(res);
            }
        }
    }
}