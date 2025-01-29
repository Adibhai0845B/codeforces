/*import java.util.*;
public class dubstep {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
            String s = sc.next();
           int n = s.length();
            int i =0;
            int count =0;
            int count1 =0;
            while(i<n){
                if(i+2<n&&s.charAt(i)=='W'&&s.charAt(i+1)=='U'&&s.charAt(i+2)=='B'){
                    i+=3;
                    count++;
                }
                else{
                    if(count1==count){
                System.out.print(s.charAt(i));
                    }
                    else{
                        System.out.print(" "+s.charAt(i));
                    }
                i++;
                count1=count;
            }
            }
            System.out.println();
    }
}
*/
import java.util.*;

public class dubstep {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int n = s.length();
        int i = 0;
        while (i < n) {
            if (i + 2 < n && s.charAt(i) == 'W' && s.charAt(i + 1) == 'U' && s.charAt(i + 2) == 'B') {
                i += 3;
                if (i < n) {
                    System.out.print(" ");
                }
            } else {
                System.out.print(s.charAt(i));
                i++;
                while (i < n && !(i + 2 < n && s.charAt(i) == 'W' && s.charAt(i + 1) == 'U' && s.charAt(i + 2) == 'B')) {
                    System.out.print(s.charAt(i));
                    i++;
                }
                if (i < n) {
                  //  System.out.print(" ");
                }
            }
        }
        System.out.println();
    }
}
