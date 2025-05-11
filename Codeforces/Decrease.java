import java.util.*;

public class Decrease {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t-->0){
            String s = sc.next();
            long pos = sc.nextLong();
            pos--;
            int n = s.length();
            List<Character> sb = new ArrayList<>();
            boolean remov = pos < n;
            s += ' ';
            for (char c : s.toCharArray()) {
                while (!remov && !sb.isEmpty() && sb.get(sb.size() - 1) > c) {
                    pos -= n;
                    n--;
                    sb.remove(sb.size() - 1);
                    if (pos < n)
                        remov = true;
                }
                sb.add(c);
            }
            System.out.print(sb.get((int) pos));
        }
    }
}

/*import java.util.*;
public class Decarese {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int pos = sc.nextInt();
            StringBuilder sb = new StringBuilder(s);
        StringBuilder k = new StringBuilder(s);
        int count =0;
           for(int i =0;i<s.length()-1;i++){
      if(s.charAt(i)>s.charAt(i+1)&&sb.length()<pos){
        k.deleteCharAt(i-count);
        count++;
      sb.append(k);
      }
        }
        while(sb.length()<pos){
            k.deleteCharAt(k.length()-1);
            sb.append(k);
        }
            System.out.print(sb.charAt(pos - 1));
        }
    }
}
*/