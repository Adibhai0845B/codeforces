import java.util.*;
public class Lucky {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        int n = sc.nextInt();
         int count =0;
         int h=l/2;
         boolean ans = true;
           int count1 =0;
        while(n!=0){
            if(count==l){
                count1=count;
                count=0;
            }
            int c = n%10;
            if(c !=4&&c!=7){
                ans =false;
            }
            count++;
            n/=10;
        }
        if(count1!=count){
            ans = false;
        }
        if(!ans){
            System.out.println("NO");
        }
        else{
            System.out.println("YES");
        }
    }
}
