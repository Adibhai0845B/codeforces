import java.io.*; 
import java.util.*; 

public class DisjointSet{
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String s = sc.next();
    int n = s.length();
    int a[] = new int[n];
    for(int i =0;i<n;i++){
        a[i] = sc.nextInt();
    }
    Stack<Character> s1 = new Stack<>();
     s1.push(s.charAt(0));
    int ans =0;
    int index = -1;
     for(int i =1;i<n;i++){
         char ch  = s.charAt(i);
         char prev = s1.peek();
         if(prev==ch){
            if(a[i]>=a[index]){
                ans+=a[index];
              index = i;
            }
            else{
                ans+=a[i];
            }
         }
         else{
     index = i;
     s1.push(s.charAt(i));
         }
     //    System.out.println(ans);
    }
    System.out.println(ans);
  }
}