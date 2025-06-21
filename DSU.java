import java.util.*;
public  class DSU{
    private int[] parent, rank, size;
    private int n, components;
    private int maxSize;
    private Map<Integer, Set<Integer>> componentMap;

    public DSU(int n) {
        this.n = n;
        parent = new int[n];
        rank = new int[n];
        size = new int[n];
        componentMap = new HashMap<>();
        components = n;
        maxSize = 1;
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
            componentMap.put(i, new HashSet<>());
            componentMap.get(i).add(i);
        }
    }

    public int find(int x) {
        if (parent[x] != x)
            parent[x] = find(parent[x]);
        return parent[x];
    }

    public boolean union(int x, int y) {
        int px = find(x), py = find(y);
        if (px == py) return false;

        if (rank[px] < rank[py]) {
            parent[px] = py;
            size[py] += size[px];
            maxSize = Math.max(maxSize, size[py]);
            componentMap.get(py).addAll(componentMap.get(px));
            componentMap.remove(px);
        } else if (rank[px] > rank[py]) {
            parent[py] = px;
            size[px] += size[py];
            maxSize = Math.max(maxSize, size[px]);
            componentMap.get(px).addAll(componentMap.get(py));
            componentMap.remove(py);
        } else {
            parent[py] = px;
            rank[px]++;
            size[px] += size[py];
            maxSize = Math.max(maxSize, size[px]);
            componentMap.get(px).addAll(componentMap.get(py));
            componentMap.remove(py);
        }
        components--;
        return true;
    }

    public int getComponentCount() {
        return components;
    }

    public int getMaxComponentSize() {
        return maxSize;
    }
    public List<Integer> getComponent(int x) {
        int px = find(x);
        return new ArrayList<>(componentMap.get(px));
    }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    DSU d1 = new DSU(n+1);
    int q = sc.nextInt();
    int t = sc.nextInt();
    long ans=0;
    while(q-->0){
        int type =sc.nextInt();
        int i =sc.nextInt();
        int j =sc.nextInt();
        if(type==1){
            d1.union(i,j);
        }
        else{
        List<Integer> a1 = d1.getComponent(i);
          Collections.sort(a1);
       //   System.out.println(a1);
          int beauty=1;
          int in =1;
          int prev =a1.get(0);
          while(in<a1.size()){
            int u = a1.get(in++);
             if(u!=(prev+1)){
   beauty++;
             }prev = a1.get(in-1);
          }
          ans+=beauty;
        }
    }  
    System.out.println(ans);
} 
}

