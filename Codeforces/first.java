import java.util.Scanner;

public class first {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume the newline after the integer input

        while(t-- > 0) {
            int n = sc.nextInt();
            sc.nextLine(); // Consume the newline after the integer input
            String s = sc.nextLine();

            boolean isValid = true;
            for(int i = 0; i < n - 1; i++) {
                char current = s.charAt(i);
                char next = s.charAt(i + 1);

                if (Character.isLowerCase(current) && Character.isDigit(next)) {
                    System.out.println("No");
                    isValid = false;
                    break;
                } else if (Character.isDigit(current) && Character.isDigit(next)) {
                    if (next < current) {
                        System.out.println("No");
                        isValid = false;
                        break;
                    }
                } else if (Character.isLowerCase(current) && Character.isLowerCase(next)) {
                    if (next < current) {
                        System.out.println("No");
                        isValid = false;
                        break;
                    }
                }
            }

            if(isValid) {
                System.out.println("Yes");
            }
        }

        sc.close(); // Close the scanner to prevent resource leaks
    }
}
