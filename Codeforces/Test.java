import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.*;
public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int times = sc.nextInt();
        for (int i = 0; i < times; i++) {
            int n = sc.nextInt();
         long findg = sc.nextLong();
          List<Long> a = new ArrayList<>();
          for (int j = 0; j < n; j++) {a.add(sc.nextLong());}
      long left = 1L;
      long right = 1000000000000L;
            while (left <= right) {
                long mid = (left + right) / 2;  long k = findg;int count = 0;
                long answ = 0;
                int j;
                for (j = 0; j < a.size(); j++) {
                    if (a.get(j) > mid) {
                        count++;
                    } else if (a.get(j) < mid) {
                        if (k >= mid - a.get(j)) {
                      k -= mid - a.get(j);
                } else {  answ = -1;
                       break;
                        }
                    }
                }
                if (j == a.size()) {
                    answ = (a.size() * (mid - 1)) + 1 + count + k;
                }
                if (answ == -1) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
          int count = 0;
  long answ = 0;
      for (int j = 0; j < a.size(); j++) {        if (a.get(j) > right) {
                    count++;
                } else if (a.get(j) < right) {
                    if (findg >= right - a.get(j)) {
                        findg -= right - a.get(j);
                    } else {
                        answ = -1;
                        break;
                    }
                }
            }
            if (answ != -1) {
                answ = (a.size() * (right - 1)) + 1 + count + findg;
            }
            System.out.println(answ);
        }
    }
}
