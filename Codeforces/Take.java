import java.util.*;

public class Take {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                long[] a = new long[n];
                int evenCount = 0;
                int oddCount = 0;
                for (int i = 0; i < n; i++) {
                    a[i] = sc.nextLong();
                    if (a[i] % 2 == 0) {
                        evenCount++;
                    } else {
                        oddCount++;
                    }
                }

                if ((n % 2 == 0 && evenCount != oddCount) || (n % 2 != 0 && Math.abs(evenCount - oddCount) != 1)) {
                    System.out.println("-1");
                } else {
                    int swapCount = 0;
                    Stack<Long> stack = new Stack<>();
                    List<Long> list = new ArrayList<>();
                    stack.push(a[0]);
                    int i = 1;
                    while (stack.size() != n && i < n) {
                        if (!list.isEmpty() && stack.peek() % 2 != list.get(0) % 2) {
                            stack.push(list.get(0));
                            list.remove(0);
                        } else if (stack.peek() % 2 != a[i] % 2) {
                            stack.push(a[i]);
                        } else {
                            list.add(a[i]);
                           // System.out.println(stack);
                            //System.out.println(a[i]);
                            swapCount++;
                            if(list.size()>=2){
                                swapCount+=(list.size()-1);
                            }
                            i++;
                        }
                    }
                    System.out.println(swapCount);
                }
            }
        }
    }
}
