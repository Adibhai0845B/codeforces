import java.util.*;
public class fun {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
              String s = sc.next();
              StringBuilder sb = new StringBuilder(s);
     sb.setCharAt(0, '(');
     int count =0;
              for(int i =0;i<n;i++){
                  if(i%2!=0){
                    sb.setCharAt(i, s.charAt(i));
                  }
                  if(i%2==0){
                    if(count>0){
                        sb.setCharAt(i, ')');
                    }
                    else{
                        sb.setCharAt(i, '(');
                    }
                  }
                if(sb.charAt(i)=='('){
                    count++;
                }
                else if(sb.charAt(i)==')'){
                    count--;
                }
              }
              int ans =0;
              int in1 =0;
              int in2 =0;
               for(int i =0;i<n;i++){
                if(sb.charAt(i)=='('){
                    in1 = i;
                }
                else if(sb.charAt(i)==')'){
                    in2 = i;
                    ans+=(in2-in1);
                }
               }
               System.out.println(sb.toString());
               System.out.println(ans);
        }
    }
}*/
import java.util.ArrayList;
import java.util.Scanner;
 
public class fun {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();
            StringBuilder sb = new StringBuilder(s);
 
            // Ensuring the first character is '('
            sb.setCharAt(0, '(');
            int count = 1;  // Starting count at 1 since we set the first character to '('
 
            // Process the rest of the string
            for (int i = 1; i < n; i++) {
                if (i % 2 == 0) {
                    // For even indices, set character based on current count
                    if (count > 0) {
                        sb.setCharAt(i, ')');
                        count--;
                    } else {
                        sb.setCharAt(i, '(');
                        count++;
                    }
                } else {
                    // For odd indices, keep the character as it is
                    sb.setCharAt(i, s.charAt(i));
                    // Adjust count based on the current character
                    if (sb.charAt(i) == '(') {
                        count++;
                    } else if (sb.charAt(i) == ')') {
                        count--;
                    }
                }
            }
            int ans = 0;
            int in1 = 0;
            int in2 = 0;
            ArrayList<Integer> a1 =new ArrayList<>();
            ArrayList<Integer> a2 = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (sb.charAt(i) == '(') {
                a1.add(i);
                } else if (sb.charAt(i) == ')') {
                   a2.add(i);
                }
            }
        for(int i =0;i<a1.size();i++){
            ans+=(a2.get(i)-a1.get(i));
        }
            System.out.println(ans);
        }
        sc.close();
    }
}