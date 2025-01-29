import java.util.*;
public class Min {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        boolean ans = true;
     String s = sc.next();
     int count   = 0;
     int count1 =0;
     int steps =0;
     for(int i =0;i<l;i++){
        if(steps==l/2){
            count1=count;
            count =0;
        }
        if(s.charAt(i)!='4'&&s.charAt(i)!='7'){
            ans = false;
            break;
        }
        char c = s.charAt(i); 
        int digit = Character.getNumericValue(c);
        count+=(digit);
        steps++;
     }
     if(count!=count1){
        ans= false;
     }
     if(!ans){
        System.out.println("NO");
     }
     else{
        System.out.println("YES");
     }
    }
}
