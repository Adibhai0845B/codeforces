import java.util.*;
public class ValidParenthesis {
    public static void main(String[] args) {
        Scanner sc =new  Scanner(System.in);
        String s  = sc.next();
    int n = s.length();
    int mn =0;int max =0;
        for(int i =0;i<n;i++){
 if(s.charAt(i)=='('){
    mn=mn+1;
    max+=1;
 }
 else if(s.charAt(i)==')'){
    mn-=mn-1;
    max-=1;
 }
 else{
    mn-=1;
    max+=1;
 }
 if(mn<0){
    mn=0;
 }
 if(max<0){
    System.out.println("No");
    break;
 }
        }
    }
}
