import java.util.*;
public class B{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
           ArrayList<Integer> a1= new ArrayList<>();
            long min = Integer.MAX_VALUE;
            int n = sc.nextInt();
            while(n-->0){
            int  m= sc.nextInt();
            int a[] = new int[m];
            for(int i =0;i<m;i++){
                a[i] = sc.nextInt();
                min = Math.min(min,a[i]);
            }
            Arrays.sort(a);
             a1.add(a[1]);
        }
        Collections.sort(a1);
        long sum =0;
        for(int i =1;i<a1.size();i++){
               sum+=a1.get(i);
        }
        sum+=min;
        System.out.println(sum);
        }
    }
}