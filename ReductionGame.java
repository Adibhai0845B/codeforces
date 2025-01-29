import java.util.*;

public class ReductionGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int[] a = new int[n];
            HashMap<Integer,Integer> h1 = new HashMap<>();
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
                h1.put(a[i],h1.getOrDefault(h1, 0)+1);
            }
            for(int val:h1.values()){
                if(val>2&&val%2==0){
                    int c = val;
                    h1.removeKey();
                   sum+=h1.getKey()+val-1;
                } 
                else if(val>2&&val%2!=0){
                    h1.getKey() ==k;
                }
            }
            ArrayList<Integer> a1 = new ArrayList<>();
            for(int val:h1.values()){
                 a1.add(h1.key());
            }
            Arrays.sort(a);
            for (int i = 0; i < n / 2; i++) {
                int temp = a[i];
                a[i] = a[n - i - 1];
                a[n - i - 1] = temp;
            }
            for (int i = 0; i < n - 1; i++) {
                while (i < n - 1 && a[i] > k && a[i + 1] > k) {
                    a[i]--;
                    a[i + 1]--;
                }
            }
            int sum = 0;
            for (int num : a) {
                sum += num;
            }
            sb.append(sum).append("\n");
        }
        System.out.print(sb.toString());
        
        scanner.close();
    }
}   