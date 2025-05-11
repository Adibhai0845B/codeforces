import java.util.*;
public class Matching {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0){
            t--;
            String s = sc.next();
            int count =0;
           int count0 =0;
           int count1 =0;
           if(s.charAt(0)=='?'){
            count1++;
           } 
           for(int i =0;i<s.length();i++){
                if(s.charAt(i)=='?'){
                    count++;
                }
               
            }  
            int sum =1;
            if(s.charAt(0)=='0'){
                System.out.println("0");
            }
            else{
              if(count>0){
                if(count1>0){
                   sum =9;
             for(int i =0;i<(count-1);i++){
             sum*=10;
             }
                }
                else{
                 for(int i =0;i<count;i++){
                sum*=10;
                 }
                }
                System.out.println(sum);
              }
              else{
                if(s.charAt(0)=='0'){
            System.out.println("0");
                }
                else{
                System.out.println("1");
              }
            }
        }
        } 
    }
}
