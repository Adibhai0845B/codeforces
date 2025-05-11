import java.util.*;
public class Strongvertices {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            long a[] = new long[n];
            long b[] = new long[n];
            for(int i =0;i<n;i++){
                a[i] = sc.nextLong();
            }
            for(int i =0;i<n;i++){
                b[i] = sc.nextLong();
            }
            ArrayList<ArrayList<Integer>> a1 = new ArrayList<>();
             for(int i =0;i<n;i++){
                a1.add(new ArrayList<>());
             }
            for(int i =0;i<n;i++){
                for(int j =0;j<n;j++){
                    if(i!=j){
                      if(a[i]-a[j]>=b[i]-b[j]){
                        a1.get(i).add(j);
                      }
                    }
                }
            }
              int count =0;   
           ArrayList<Integer> ans =new ArrayList<>();
              for(int i =0;i<a1.size();i++){
                if(a1.get(i).size()==n-1){
                 count++;
                  ans.add(i);
                }
            }
            System.out.println(count);
            for(int i =0;i<ans.size();i++){
         System.out.print(ans.get(i)+1+" ");
            }
            System.out.println();
        }
    }
}