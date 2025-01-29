/*import java.util.*;
public class LexographicallyaMaximum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int n = s.length();
           StringBuilder sb = new StringBuilder();
         sb.append(s.charAt(0));
           for(int i =1;i<n-1;i++){
           if(sb.get(sb.length()-1)==s.charAt(i)) sb.append(s.charAt(i));
           else{
           while(sb.get(sb.length()-1)>s.charAt(i)) continue; 
            while(sb.get(sb.length()-1)<s.charAt(i)){
            sb.deleteCharAt(sb.length()-1);
           }
           sb.append(s.charAt(i));
        }
        }
        System.out.println(sb.toString());
    }
}
*/
import java.util.*;
public class LexicographicallyMaximum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         int t = sc.nextInt();
         while(t-->0){
            int n = sc.nextInt();
            int p[] = new int[n+1];
            for(int i =1;i<=n;i++){
                p[i] = sc.nextInt();
            }
         long count =0;
            boolean vis[] = new boolean[n+1];
            for(int i =1;i<=n;i++){
            if(!vis[i]){
             int j = i;
             int cont =0;
             while(!vis[j]){
                   vis[j] = true;
                j = p[j];
                cont++;;
             }
             if(cont>=3){
                count+=(cont-1)/2;
             }
            }
            }
            System.out.println(count);
        }
    }
}
