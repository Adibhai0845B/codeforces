import java.util.*;
public class LittleNikita {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            if(Math.pow(2,n-1)>n){

            }
        }
    }
            public static int nextPowerOf2(int n) {
                if (n <= 0) {
                    return 1;
                }
                n--;
                n |= n >> 1;
                n |= n >> 2;
                n |= n >> 4;
                n |= n >> 8;
                n |= n >> 16;
                n++;
                return n;
            }
        
            // Method to find the nearest power of 2 less than or equal to n
            public static int previousPowerOf2(int n) {
                if (n < 1) {
                    return 0;
                }
                return Integer.highestOneBit(n);
            }
        
            // Method to find the nearest power of 2 (either lower or higher)
            public static int nearestPowerOf2(int n) {
                if (n < 1) {
                    return 1;
                }
                int nextPow = nextPowerOf2(n);
                int prevPow = previousPowerOf2(n);
                if (nextPow - n < n - prevPow) {
                    return nextPow;
                } else {
                    return prevPow;
                }
            }
    }
