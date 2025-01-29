import java.util.*;
public class hu {
 public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while(t-->0){
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        int res[]=new int[m];
    for(int i =0;i<n;i++){
        char ch[] =sc.nextLine().toCharArray();
        for(int j =0;j<m;j++){
            res[j]+=(ch[j]-0);
        }
    }
    for(int i =0;i<n-1;i++){
        char ch[] = sc.nextLine().toCharArray();
        for(int j =0;j<m;j++){
            res[j]-=(ch[j]-0);
        }
    }
    for(int i =0;i<m;i++){
        System.out.print((char)res[i]);
    }
    System.out.println();
    }
 }   
}
