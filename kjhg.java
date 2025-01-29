import java.util.*;

public class kjhg {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            String s = sc.nextLine();
            String t5 = sc.nextLine();
            Queue<Character> s1 = new LinkedList<>();
            for (char c : t5.toCharArray()) {
                s1.add(c);
            }
      StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (!s1.isEmpty() && (s.charAt(i) == s1.peek() || s.charAt(i) == '?')) {
                    sb.append( s1.poll());
                }
                else if(s.charAt(i)=='?'){
                    sb.append('a');
                }
                else{
                    sb.append(s.charAt(i));
                }
            }

            if (s1.isEmpty()) {
                System.out.println("YES");
                System.out.println(sb);
            } else {
                System.out.println("NO");
            }
        }
    }
}
