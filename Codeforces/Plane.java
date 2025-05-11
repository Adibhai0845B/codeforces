import java.util.*;

public class Plane {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashMap<Integer, ArrayList<String>> scoreMap = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            int x = sc.nextInt();
            
            if (!scoreMap.containsKey(x)) {
                scoreMap.put(x, new ArrayList<>(Collections.singletonList(s)));
            } else {
                ArrayList<String> names = scoreMap.get(x);
                if (!names.contains(s)) {
                    names.add(s);
                }
            }
        }
        
        // Convert HashMap to a list of entries and sort by scores
        ArrayList<Map.Entry<Integer, ArrayList<String>>> entryList = new ArrayList<>(scoreMap.entrySet());
        entryList.sort(Map.Entry.comparingByKey());

        // Calculate percentiles and categorize
        int totalScores = entryList.size();
        for (int i = 0; i < totalScores; i++) {
            Map.Entry<Integer, ArrayList<String>> entry = entryList.get(i);
            int score = entry.getKey();
            ArrayList<String> names = entry.getValue();
            int percentile = ((i + 1) * 100) / totalScores;
            
            // Print combined names and score
            System.out.print("Score: " + score + " Names: ");
            for (String name : names) {
                System.out.print(name + " ");
            }
            System.out.println(percentile + "%");
            
            // Categorize based on percentile
            calculate(percentile);
        }
    }

    public static void calculate(int y) {
        if (y < 50) {
            System.out.println("Noob");
        } else if (y >= 50 && y < 80) {
            System.out.println("Random");
        } else if (y >= 80 && y < 90) {
            System.out.println("Average");
        } else if (y >= 90 && y < 99) {
            System.out.println("Hardcore");
        } else {
            System.out.println("Pro");
        }
    }
}
