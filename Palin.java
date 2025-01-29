import java.util.*;

public class Main {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), arr[] = new int[n];
		
		for(int i=0; i<n; i++)
			arr[i] = sc.nextInt();
		
		long ans = Long.MAX_VALUE;
		for(int i=0; i<n; i++) {
			long cnt = 0;
			if(i<n-1) {
				long pre = 0;
				for(int j=i+1; j<n; j++) {
					long p = pre == 0 ? 1 : pre/arr[j]+1;
					cnt += p;
					pre = arr[j]*p;
				}
			}
			if(i>0) {
				long pre = 0;
				for(int j=i-1; j>=0; j--) {
					long p = pre == 0 ? 1 : pre/arr[j]+1;
					cnt += p;
					pre = arr[j]*p;
				}
			}
			if(cnt < 0) continue;
			ans = Math.min(ans, cnt);
		}
		System.out.println(ans);
	}
}