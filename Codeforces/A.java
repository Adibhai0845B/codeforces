import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine(); 
        while (t-- > 0) {
            String s = scanner.nextLine().trim();
            String convertedTime = funct(s);
            System.out.println(convertedTime);
        }
        scanner.close();
    }
    private static String funct(String time) {
        int ho = Integer.parseInt(time.substring(0, 2));
 String mi = time.substring(3, 5);
  String sub = (ho < 12) ? "AM" : "PM";
  int stan = (ho % 12 == 0) ? 12 : ho % 12;
   return String.format("%02d:%s %s", stan, mi, sub);
    }
}
