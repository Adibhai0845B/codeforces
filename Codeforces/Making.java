import java.util.*;

public class Making {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            String s=sc.next();
            if(s.length()%2!=0)
                System.out.println("-1");
            else
                System.out.println(solve(s));
        }

    }
    public static int solve(String s){
        int i=0,e=s.length()-1;
        int res=-1;
        int c=0;
        HashMap<Character,Integer> h=new HashMap<>();
        HashMap<Character,Integer> h1=new HashMap<>();
        while(i<e){
            if(s.charAt(i)==s.charAt(e)) {
                h.put(s.charAt(i), h.getOrDefault(s.charAt(i), 0) + 1);
                c++;
            }
            h1.put(s.charAt(i), h1.getOrDefault(s.charAt(i), 0) + 1);
            h1.put(s.charAt(e), h1.getOrDefault(s.charAt(e), 0) + 1);
            i++;
            e--;
        }
        for(int j:h1.values())
            if(j>(s.length()/2))
                return -1;
//        System.out.println(s+" "+h+" "+c);
        for(int j:h.values())
            if(j>(c/2))
                return j;
        return (int)Math.ceil(c/2.0);
    }
}