import java.util.*;
/*
 AdiBhai0845R
  AdiBhai0845R
   AdiBhai0845R
    AdiBhai0845R
     AdiBhai0845R
      AdiBhai0845R
 */
public class  {
    private int V;
    private LinkedList<Integer>[] adj; 
    static final int top= 400005;
    static final long INF = (long) 1e18;
    static final int MOD = 1000000007;
    public tempelates(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList<>();
    }
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int t = sc.nextInt();
      while(t-->0){
          functi1(sc);
      }
      sc.close();
  }
    static void functi1(Scanner sc) {
        int dc = sc.nextInt();
        int gf = sc.nextInt();
        long k = 0;
        long vfr = 0;
        long ans = 0;
        List<Integer>[] fge = new ArrayList[dc];
        Set<Integer>[] hjh = new HashSet[dc];
        for (int i = 0; i < dc; ++i) {
            int q = sc.nextInt();
            k += q;
            hjh[i] = new HashSet<>();
            for (int j = 0; j < q; ++j) {
                int z = sc.nextInt();
                hjh[i].add(z);
            }
        }
        for (int i = 0; i < dc; ++i) {
            fge[i] = new ArrayList<>();
            for (int j : hjh[i]) {
                if (j <= k) {
                    fge[i].add(j);
                }
            }
        }

        for (int i = 0; i < dc; ++i) {
            List<Integer> jht = fge[i];
            int anser = -1;
            int bg = -1;
            int pp = 0;
            int  dr= jht.size();
            for (int j = 0; j < dr && bg == -1; j++) {
                if (jht.get(j) != pp) {
                    if (anser == -1) anser = pp;
                    else bg = pp;
                    pp++;
                    j--;
                } else pp++;
            }
            if (anser == -1)anser = dr;
            if (bg == -1) bg = dr + 1;
            vfr = Math.max(vfr, Math.max(anser, bg));
        }

        if (vfr > gf) {
            ans = vfr * gf + vfr;
        } else {
            ans = gf;
            ans = (ans * (ans + 1)) / 2;
            ans += (vfr * (vfr + 1)) / 2;
        }
        System.out.println(ans);
    }
  public static int gcd(int a, int b){
        if (b == 0)  return a;
        else return gcd(b, Math.abs(a - b));
    }
   public  static int lcm(int x, int y)  {  
return (x / gcd(x, y)) * y;  
  }
  public static void sort(int a[]){
    Arrays.sort(a);
  }  
  public static int completebinarySearch(int[] array, int target) {
    int left = 0;
    int right = array.length - 1;

    while (left <= right) {
        int mid = left + (right - left) / 2;
        if (array[mid] == target) {
            return mid;
        }
        if (array[mid] < target) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }
    return -1;
}
public static HashMap hashmap(int a[]){
    HashMap<Integer,Integer> h1 = new HashMap<Integer,Integer>();
   for(int i :a){
     h1.put(i,h1.getOrDefault(i,0)+1);
   }
   return h1;
}
void addEdge(int v, int w) {
    adj[v].add(w); // Add w to v's list.
}

// DFS utility function for recursion
private void DFSUtil(int v, boolean[] visited) {
    // Mark the current node as visited and print it
    visited[v] = true;
    System.out.print(v + " ");

    // Recur for all the vertices adjacent to this vertex
    for (int n : adj[v]) {
        if (!visited[n])
            DFSUtil(n, visited);
    }
}

// Function to perform DFS
public void DFS(int startVertex) {
    boolean[] visited = new boolean[V];
    DFSUtil(startVertex, visited);
}

// Function to perform BFS
public void BFS(int startVertex) {
    boolean[] visited = new boolean[V];
    LinkedList<Integer> queue = new LinkedList<>();

    // Mark the current node as visited and enqueue it
    visited[startVertex] = true;
    queue.add(startVertex);

    while (queue.size() != 0) {
        // Dequeue a vertex from queue and print it
        startVertex = queue.poll();
        System.out.print(startVertex + " ");
        for (int n : adj[startVertex]) {
            if (!visited[n]) {
                visited[n] = true;
                queue.add(n);
            }
        }
    }
}
public static int binarySearch(int[] arr, int start, int end, int target) {
    while (start <= end) {
        int mid = start + (end - start) / 2;
        if (arr[mid] == target) {
            return mid;
        }
        if (arr[mid] < target) {
            start = mid + 1;
        }
        else {
            end = mid - 1;
        }
    }
    return -1;
}
}