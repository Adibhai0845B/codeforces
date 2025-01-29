import java.util.Scanner;
public class ches {
    static long guys;
    static boolean check(long[] arr, long[] brr, long pl) {
        long po = 0;

        for (int i = 0; i < arr.length; i++) {
            long curDmg = ((pl / brr[i]) + 1) * arr[i];
            po += curDmg;
            if (po >= guys) return true;
        }
        return po >= guys;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0){
        long h = scanner.nextLong();
        long n = scanner.nextLong();
        guys = h;
        long[] arr1 = new long[(int) n];
        long[] arr2 = new long[(int) n];
        for (int i = 0; i < n; i++) {
            arr1[i] = scanner.nextLong();
        }
        for (int i = 0; i < n; i++) {
            arr2[i] = scanner.nextLong();
        }

        long aa = 0;
        long pl = (long) 1e12;

        while (pl - aa > 1) {
            long ans = (aa + pl) / 2;
            if (check(arr1, arr2, ans)) {
                pl = ans;
            } else {
                aa = ans;
            }
        }
        if (check(arr1, arr2, aa)) {
            System.out.println(aa + 1);
        }
        else{
        System.out.println(pl + 1);
        }    
    }
    }
}
