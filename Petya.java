import java.util.*;

public class Petya {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();
        while(t-->0){ 
        int m = sc.nextInt();
        long[] a = new long[m];
        
        for (int i = 0; i < m; i++) {
            a[i] = sc.nextLong();
        }
        if(m==1){
            System.out.println(Math.max(0,a[0]));
        }
        else{
            long s = Math.max(0,a[0]+Math.max(0,a[1]));
            for(int i =2;i<m;i++){
                s+=Math.max(0,a[i]);
            }
            System.out.println(s);
        }
}
    }
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

    public static int lcm(int x, int y) {
        return (x / gcd(x, y)) * y;
    }

    public static void sort(int[] a) {
        Arrays.sort(a);
    }

    public static int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (array[mid] == target) {
                return mid;
            }

            if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }
}
