

import java.util.Scanner;

public class test7 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		while (n-- > 0) {
			int m = sc.nextInt();
			long[] arr = new long[m];
			long min = Long.MAX_VALUE;
			int index = 0;
			for (int i = 0; i < m; i++) {
				long cur = sc.nextLong();
				arr[i] = cur;

				if (cur < min) {
					min = cur;
					index = i;
				}

			}
			boolean flag = true;
			for (int i = index + 1; i < m; i++) {
				if (arr[i] < arr[i - 1]) {
					flag = false;
					break;
				}
			}
			if (flag) {
				System.out.println(index);
			} else {
				System.out.println(-1);
			}

		}

	}

}
