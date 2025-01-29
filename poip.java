import java.util.*;
public class poip {
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int ans1 =0;
        int max1 =0;
        int ans2 = 0;
        int max2 =0;
        for(int i =0;i<s.length();i++){
            if(s.charAt(i)=='+'){
                ans2 =0;
                ans1++;
                if(ans1>max1){
                    max1 = ans1;
                }
            }
            else{
                ans1 =0;
                ans2++;
                if(ans2>max2){
                    max2 = ans2;
                }
            }
        }   
        int ans =0;
        int max =0; 
        for(int i =0;i<s.length();i++){
            
        }
        System.out.println(Math.max(max1,max2));
}    
}
