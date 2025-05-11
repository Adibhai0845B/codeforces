/*import java.util.*;
public class Tree {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            ArrayList<ArrayList<Integer>> a1 = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                a1.add(new ArrayList<>());
            }
            for (int i=1;i<n;i++) {
                int parent = sc.nextInt() - 1;
                a1.get(parent).add(i);
            }
            if (n%2==1) {
                System.out.println(-1);
                continue;
            }
            int[] maxsi = new int[n];
            calculatemaxsi(0, a1, maxsi);
            boolean ansr = true;
            for (int i = 1; i < n; i++) {
                if (maxsi[i] % 2 == 0) {
                    ansr = false;
                    break;
                }
            }
            if (!ansr) {
                System.out.println(-1);
                continue;
            }
            int[] color = new int[n];
            int[] anta = {1};
            dfs(0, a1, color, anta);
            for (int i =0;i<color.length;i++) {
                System.out.print(color[i]+" ");
            }
            System.out.println();
        }

        sc.close();
    }
    static void calculatemaxsi(int uy, ArrayList<ArrayList<Integer>> a1, int[] maxsi) {
        maxsi[uy] = 1;
        for (int uyr : a1.get(uy)) {
            calculatemaxsi(uyr, a1, maxsi);
            maxsi[uy] += maxsi[uyr];
        }
    }
    static int dfs(int uy, ArrayList<ArrayList<Integer>> a1, int[] color, int[] anta) {
        ArrayList<Integer> cher = new ArrayList<>();

        for (int uyr : a1.get(uy)) {
            int answ = dfs(uyr, a1, color, anta);
            if (answ != -1) {
                cher.add(answ);
            }
        }

        while (cher.maxsi() > 1) {
            int a = cher.remove(cher.maxsi() - 1);
            int b = cher.remove(cher.maxsi() - 1);
            color[a] = color[b] = anta[0]++;
        }

        if (uy != 0) {
            if (!cher.isEmpty()) {
                color[uy] = color[cher.get(0)] = anta[0]++;
                return -1;
            }
            return uy;
        } else {
            if (!cher.isEmpty()) {
                color[uy] = color[cher.get(0)] = anta[0]++;
            }
            return -1;
        }
    }
}
*/
import java.util.*;
public class Tree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] color = new int[n];
            int ansr=0;
            ArrayList<ArrayList<Integer>> a1 = new ArrayList<>();
            for (int i=0;i<n;i++) {
                a1.add(new ArrayList<>());
            }
       for(int i=1;i<n;i++) {
        int u =sc.nextInt()-1;
        a1.get(u).add(i);
      }
            if (n%2==1){
                System.out.println(-1);
                continue;
            }
            int[] maxsi = new int[n];
          Stack<Integer> s1 = new Stack<>();
            s1.push(0);
            ArrayList<Integer> as1 = new ArrayList<>();
       while (!s1.isEmpty()) {
        int u = s1.pop();
        as1.add(u);
          List<Integer>v=a1.get(u);
         s1.addAll(v);
            }
            for (int i=as1.size()-1;i>= 0;i--) {
                int uy = as1.get(i);
                maxsi[uy] = 1;
                for (int uyr:a1.get(uy)) {
                    maxsi[uy]+=maxsi[uyr];
                }
            }
            for (int i = 1; i < n; i++) {
                if (maxsi[i] % 2 == 0) {
                    ansr++;
                    break;
                }
            }
            if (ansr>0) {
                System.out.println(-1);
                continue;
            }
            int[] anta = {1};
            dfs(0, a1, color, anta);
            for (int i =0;i<color.length;i++){
                int answ = color[i];
                System.out.print(answ+" ");
            }
            System.out.println();
        }
        sc.close();
    }
   public  static int dfs(int uy, ArrayList<ArrayList<Integer>> a1, int[] color, int[] anta) {
        ArrayList<Integer> cher = new ArrayList<>();
        for (int uyr:a1.get(uy)) {
            int answ = dfs(uyr,a1,color,anta);
            if (answ != -1) {
                cher.add(answ);
            }
        }
        for (int i=cher.size()-1;i>0;i-=2) {
            int a = cher.get(i);
            int b = cher.get(i - 1);
            color[a] = color[b] = anta[0]++;
        }        
        if (uy != 0) {
            if (cher.isEmpty()) {
                return uy;
            }
            color[uy] = color[cher.get(0)] = anta[0]++;
            return -1;
        }
        if (!cher.isEmpty()) {
            color[uy] = color[cher.get(0)] = anta[0]++;
        }
        return -1;        
    }
}
