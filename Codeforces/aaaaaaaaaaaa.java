import java.util.*;

public class aaaaaaaaaaaa {
       public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
          int x = sc.nextInt();
        int n = sc.nextInt();
        TreeSet<Integer> cuts = new TreeSet<>();
        cuts.add(0);
        cuts.add(x);

        TreeMap<Integer, Integer> lengths = new TreeMap<>();
        lengths.put(x, 1);

        for (int i = 0; i < n; i++) {
            int cut = sc.nextInt();
            Integer high = cuts.higher(cut);
            Integer low = cuts.lower(cut);

            cuts.add(cut);
            int len = high - low;
            lengths.put(len, lengths.get(len) - 1);
            if (lengths.get(len) == 0) lengths.remove(len);

            int left = cut - low;
            int right = high - cut;
            lengths.put(left, lengths.getOrDefault(left, 0) + 1);
            lengths.put(right, lengths.getOrDefault(right, 0) + 1);

            System.out.print(lengths.lastKey() + " ");
        }
}
   
}
