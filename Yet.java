import java.util.*;

public class Yet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while (t-- > 0) {
            int n = sc.nextInt();
            HashSet<Integer> h1 = new HashSet<>();
            
            if (n == 1) {
                System.out.println("1");
            } else {
                System.out.print("1"+" "+"2"+" ");
                h1.add(1);
                h1.add(2);
                int prev = 2;
                int next = 3;
                while (h1.size() < n) {
                    while (n >= 2 * prev) {
                        h1.add(2 * prev);
                       System.out.print(2*prev+" ");  
                     prev = 2*prev;
                    }
                        while (h1.contains(next)) {
                            next++;
                        }
                        h1.add(next);
                          System.out.print(next+" ");
                      prev = next;
                }
            }
          System.out.println();
        }
        sc.close();
    }
}
