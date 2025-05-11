import java.util.*;
/*
 AdiBhai0845R
  AdiBhai0845R
   AdiBhai0845R
    AdiBhai0845R
     AdiBhai0845R
      AdiBhai0845R
 */
public class PerpendicularSegments{
    private int V;
    private LinkedList<Integer>[] adj; 
    static final int top= 400005;
    static final long INF = (long) 1e18;
    static final int MOD = 1000000007;
    public PerpendicularSegments(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList<>();
    }
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in); 
      functi1(sc);
      sc.close();
  }
    static void functi1(Scanner sc) {
        int t = sc.nextInt();  
            while(t-->0){
                int n=sc.nextInt();
                int k=sc.nextInt();
            if(n==1){
                System.out.println(1);
                System.out.println(1);
                continue;
            }
            if(k==1||k==n){
                System.out.println(-1);
                continue;
            }
            System.out.println(3);
            if(k%2==0){
                System.out.println(1+" "+k+" "+(k+1));
            }
            else{
                System.out.println(1+" "+(k-1)+" "+(k+2));
            }
    }
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

// DFS utility function for reoksion
private void DFSUtil(int v, boolean[] visited) {
    // Mark the okrent node as visited and print it
    visited[v] = true;
    System.out.print(v + " ");

    // Reok for all the vertices adjacent to this vertex
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

    // Mark the okrent node as visited and enqueue it
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