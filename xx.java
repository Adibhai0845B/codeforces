import java.util.*;

public class xx {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            int L = sc.nextInt();
            int R = sc.nextInt();
            boolean left = false;
            boolean right = false;
            if(r-l<=R-L){
          if(l-1>=L&&l-1<=R){
            left = true;
          }
          if(r+1>=L&&r+1<=R){
            right = true;
          }
            }
            else{
              if(L-1>=l&&L-1<=r){
                left = true;
              }
              if(R+1>=l&&R+1<=r){
                right = true;
              }
            }
            int overlapStart = Math.max(l, L);
            int overlapEnd = Math.min(r, R);
            int count = Math.max(0, overlapEnd - overlapStart + 1);
        if(count>1){
            count--;
        }
        if(left){
            count++;
        }
        if(right){
            count++;
        }
        System.out.println(count);
        }
    }
}
