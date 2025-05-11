import java.util.*;

public class WebofLines {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int m = input.nextInt();
		int[] ar = new int[n];
		int count = 0;
		for(int i = 0; i < m; i++) {
			int a = input.nextInt();
			int b = input.nextInt();
			int min = Math.min(a, b);
			if(ar[min] == 0) {
				count++;
			}
			ar[min]++;
		}
		int q = input.nextInt();
		for(int i = 0; i < q; i++) {
			int c = input.nextInt();
			if(c == 3) {
				System.out.println(n - count);
			}else {
				int a = input.nextInt();
				int b = input.nextInt();
				int min = Math.min(a, b);
				if(c == 1) {
					if(ar[min] == 0) {
						count++;
					}
					ar[min]++;
				}else {
					ar[min]--;
					if(ar[min] == 0) {
						count--;
					}
				}
			}
		}
	}

}
