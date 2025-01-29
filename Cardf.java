import java.util.*;
public class Cardf {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0){
            t--;
      int n = sc.nextInt();
      int k = sc.nextInt();
      int c = k;
      Integer a[] = new Integer[n];
      HashMap<Integer,Integer> h1 = new HashMap<>();
      for(int i =0;i<n;i++){
        a[i] = sc.nextInt();
        h1.put(a[i],h1.getOrDefault(a[i],0)+1);
      }
               Integer b[] = new Integer[h1.size()];
                int i =0;
               for(int num:h1.values()){
                    b[i] = num;
               i++;
                }
               Arrays.sort(b,Comparator.reverseOrder());
            if(b[0]<k){
                System.out.println("1");
            }
            else{
                int count =0;
                for(int k =0;k<h1.size();k++){
                       
                }
            }
        }
    }
}
