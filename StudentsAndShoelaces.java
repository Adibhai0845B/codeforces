import java.util.*;

public class StudentsAndShoelaces {
  public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        List<Set<Integer>> ties = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            ties.add(new HashSet<>());
        }
        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            ties.get(a).add(b);
            ties.get(b).add(a);
        }
        int groups = 0;
        while (true) {
            List<Integer> toRemove = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                if (ties.get(i).size() == 1) {
                    toRemove.add(i);
                }
            }
            if (toRemove.isEmpty()) {
                break;
            }
            for (int student : toRemove) {
                for (int tiedStudent : ties.get(student)) {
                    ties.get(tiedStudent).remove(student);
                }
                ties.get(student).clear();
            }
            groups++;
        } 
        System.out.println(groups);
        scanner.close();
    }
}
