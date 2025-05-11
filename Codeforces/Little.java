import java.util.*;
public class Little {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int n = s.length();
          HashMap<Character,Integer> h1 = new HashMap<>();
        for(int i =0;i<n;i++){
      char ch = s.charAt(i);
            h1.put(ch,h1.getOrDefault(ch, 0)+1);
        }
        int count =0;
        for(int i:h1.values()){
           if(i%2!=0){
            count++;
           }
        }
        if(count==0||count==1){
       System.out.println("First");
        }
        else{
            if(count%2==0){
                System.out.println("Second");
            }
            else{
                System.out.println("First");
            }
        }
    }
}
