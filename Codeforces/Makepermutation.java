import java.util.*;
public class Makepermutation {
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
          int t = sc.nextInt();
          HashMap<Integer,Integer> h1 = new HashMap<>();
          HashSet<Integer> h2 = new HashSet<>();
          while(t>0){
        t--;
        int n =  sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
int a[] = new int[n];
for(int i =0;i<n;i++){
    a[i] = sc.nextInt();
    h1.put(a[i],h1.getOrDefault(a[i],0)+1);
  h2.add(a[i]);
}
    //  Arrays.sort(a);
      int ans =0;
      //int see =1;
      ArrayList<Integer>a1 = new ArrayList<>();
      for(int i:h1.values()){
          ans+=(c*(i-1));
          a1.add(i.key());
        }
        int k = 1;
        for(int i:h2){
            if(!h2.contains(k)){
              ans+=d;
            }
            else{
                  
            }
            k++;
        }
      }
     }
    }