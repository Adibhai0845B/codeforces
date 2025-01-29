import java.util.*;
public class Removetwo {
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t  = sc.nextInt();
    while(t-->0){
        int n  = sc.nextInt();
        String s = sc.next();
       int count =0;
        for(int i =2;i<n;i++){
            if(s.charAt(i)==s.charAt(i-2)){
                count++;
            }
       /* for(int j = 0;j<i;j++){
            sb.append(s.charAt(j));
        }
        for(int j=i+2;j<n;j++){
            sb.append(s.charAt(j));
        }
           h1.add(sb.toString());
        */
    }
        //System.out.println(h1);
        System.out.println(n-1-count);
    }
}    
}
