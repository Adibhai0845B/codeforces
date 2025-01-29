import java.util.*;

public class TurtleMex {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int t = scanner.nextInt(); // number of test cases
        while (t-- > 0) {
            int n = scanner.nextInt(); // number of sequences
            int m = scanner.nextInt(); // the value of m

            Set<Integer> universalSet = new HashSet<>();
            boolean canReachAll = false;

            for (int i = 0; i < n; i++) {
                int li = scanner.nextInt(); // length of the sequence
                Set<Integer> currentSet = new HashSet<>();
                
                for (int j = 0; j < li; j++) {
                    int element = scanner.nextInt();
                    currentSet.add(element);
                }
                
                // Add current sequence elements to the universal set
                universalSet.addAll(currentSet);

                // Check if the current sequence contains all elements from 0 to m
                if (!canReachAll) {
                    boolean allPresent = true;
                    for (int x = 0; x <= m; x++) {
                        if (!currentSet.contains(x)) {
                            allPresent = false;
                            break;
                        }
                    }
                    if (allPresent) {
                        canReachAll = true;
                    }
                }
            }

            int sum = 0;
            if (canReachAll) {
                sum = (m + 1) * (m + 1); // Sum of f(i) from 0 to m when f(i) = m + 1 for all i
            } else {
                for (int i = 0; i <= m; i++) {
                    int mexValue = 0;
                    while (universalSet.contains(mexValue)) {
                        mexValue++;
                    }
                    sum += mexValue;
                    universalSet.add(mexValue); // mimic operation of setting x to mex
                }
            }

            System.out.println(sum);
        }

        scanner.close();
    }
}
