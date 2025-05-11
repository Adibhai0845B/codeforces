
/*import java.util.*;
public class ji {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int k = sc.nextInt()-1;
            int index =-1;
          boolean val =true;
            long a[] = new long[n];
            for(int i =0;i<n;i++){
                a[i] = sc.nextLong();
            if(a[i]>k&&val){
                index = i;
                val = false;
            }
            }
          if(index==-1){
          System.out.println(n-1);
          }
          else{
            if(index>k){
              System.out.println(index-1);
            }
            else{
                long swap = a[index];
                a[index] = a[k];
                a[k] = swap;
      int count =index;
      int ans =0;
      for(int i =index+1;i<n;i++){
          if(a[i]<a[index]){
            ans++;
          }
          else{
            break;
          }
      }
      System.out.println(Math.max(ans+1,index));
            }
          }
        }
    }
}
*/
import java.util.*;
public class ji {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt(); // Size of the array
            int k = sc.nextInt() - 1; // 0-based index
            int index = -1;
            boolean val = true;
            long a[] = new long[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
                if (a[i] > a[k] && val) {
                    index = i;
                    val = false;
                }
            }

            if (index == -1) {
                System.out.println(n - 1); // No element greater than a[k], so print n-1
            } else {
                if (index > k) {
                    System.out.println(index - 1); // The first element greater than a[k] is beyond k
                } else {
                    // Swap the element at index with the element at k
                    long swap = a[index];
                    a[index] = a[k];
                    a[k] = swap;

                    int ans = 0;
                    for (int i = index + 1; i < n; i++) {
                        if (a[i] < a[k]) {
                            ans++;
                        } else {
                            break;
                        }
                    }
                    if(a[k]==a[0]){
              System.out.println(Math.max(ans,index));
                    }
                    System.out.println(Math.max(ans + 1, index));
                }
            }
        }
        sc.close();
    }
}
