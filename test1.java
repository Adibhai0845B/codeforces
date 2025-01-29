/*import java.util.*;
public class ns {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
           // int c[] = new int[n];
            ArrayList<Integer> c = new ArrayList<>();
            for(int i =0;i<n;i++){
                c.add(sc.nextInt());
            }
    Collections.sort(c);
  HashSet<Integer> h1 = new HashSet<>(c);
  ArrayList<Integer> we = new ArrayList<>();
       int min = Integer.MAX_VALUE;
       int secondans =0;
       for(int i =0;i<n-1;i++){
            secondans+=c.get(n-1)-c.get(i);
       }
       for(int i =0;i<n-1;i++){
        int uy = Math.abs(c.get(i)-c.get(i+1));
         c.add(uy);  
    }
    for (int i = 0; i < we.size() - 1; i++) {
        int y = gcd(we.get(i), we.get(i + 1));
        we.set(i + 1, y); // Use set() to update the element
        min = y;  // Keep track of the minimum GCD
    }
       int get  = c.get(n-1);
     int count =0;
       while(get>c.get(0)){
        if(h1.contains(get)){
           get-=min;
        }
        else{
            count++;
            break;
        }
     }
     System.out.println(get+"get");
     if(count==0)  System.out.println(secondans+n);
     else{
     c.add(get);
     int another = c.get(n-1)+min; 
           Collections.sort(c);
           int max = c.get(n);
           int ans =0;
           for(int i =0;i<n;i++){
            ans+=((max-c.get(i))/min);
           }
           System.out.println(Math.min(ans,secondans+n));
         }
        }
    }
    public static int gcd(int a, int b) {
     a = Math.abs(a);
     b  = Math.abs(b);
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}*/


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class test1 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		while (m-- > 0) {

			int n = sc.nextInt();
			if (n == 1) {
				System.out.println(1);
				sc.nextInt();
				continue;
			}
			List<Integer> c = new ArrayList();
			for (int i = 0; i < n; i++) {

				c.add(sc.nextInt());

			}
			Collections.sort(c);
			long max = c.get(n - 1);
			long x = 0L;
			for (int get : c) {
				if (get == max)
					break;
				x = abs(x, max - get);
			}

			long ans = 0;
			for (int cur : c) {
				ans += (max - cur) / x;
			}

			ans++;
			long uy = max - x;
			for (int i = n - 2; i >= 0; i--) {
				if (uy != c.get(i))
					break;
				ans++;
				uy -= x;

			}
			System.out.println(ans);
		}

	}

	public static long abs(long a, long b) {
		return b == 0 ? a : abs(b, a % b);
	}

}
