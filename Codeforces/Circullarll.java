import java.util.*;

public class Circullarll{
  static final int MAX =(int)1e9;
  static final int LIMIT = (int) (1e9+100);
  static boolean[] fc;
  static List<Integer> a = new ArrayList<>();
  static boolean sieveComputed = false;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t  = sc.nextInt();
        preCompute();
        while(t-->0){
          long answ =0;
               int n = sc.nextInt();
             ArrayList<Integer> a1 = new ArrayList<>();
             for(int i =0;i<n;i++){
              a1.add(sc.nextInt());
             } 
             Collections.sort(a1,Collections.reverseOrder());
             for(int i =0;i<n;i++){
              answ+=(a1.get(i)-a.get(i));
              if(answ<0){
                System.out.println(n-i);
                break;
              }
            }
            System.out.println(0);
            }
        }
  public static void preCompute(){
    fc = new boolean[MAX+1];
    Arrays.fill(fc,true);
     fc[0] = false;
     fc[1] = false;
     for(int i =2;i*i<=MAX;i++){
      if(fc[i]){
        for(int k = i*i;k<=MAX;k+=i){
          fc[k] = false;
        }
      }
     }
     for(int i =2;a.size()<500000&&i<=LIMIT;i++){
      if(fc[i]){
        a.add(i);
      }
    }
  }
}