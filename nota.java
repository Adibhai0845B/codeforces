import java.util.*;
/*
 AdiBhai0845R
  AdiBhai0845R
   AdiBhai0845R
    AdiBhai0845R
     AdiBhai0845R
      AdiBhai0845R
 */
public class nota {
    private int V;
    private LinkedList<Integer>[] adj; 
    static final int top= 400005;
    static final long INF = (long) 1e18;
    static final int MOD = 1000000007;
    public nota(int v) {
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
        StringBuilder s = new StringBuilder(sc.next());
        int q = sc.nextInt();
    
        // Initial count of "1100" patterns
        int patternCount = 0;
        for (int i = 0; i <= s.length() - 4; i++) {
            if (isPattern(s, i)) patternCount++;
        }
    
        for (int i = 0; i < q; i++) {
            int index = sc.nextInt() - 1;  // Zero-based index
            char newChar = sc.next().charAt(0);  // New character to replace at index
    
            // Only proceed if there's an actual change
            if (s.charAt(index) != newChar) {
                // Check affected positions before the change
                for (int j = index - 3; j <= index; j++) {
                    if (isPattern(s, j)) patternCount--;
                }
    
                // Make the character change
                s.setCharAt(index, newChar);
    
                // Check affected positions after the change
                for (int j = index - 3; j <= index; j++) {
                    if (isPattern(s, j)) patternCount++;
                }
            }
    
            // Output result for the current query
            System.out.println(patternCount > 0 ? "YES" : "NO");
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
   // return index where the index was there
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
    adj[v].add(w);
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
static String modifyStringAtIndex(String s, int index, char newChar) {
    // Convert to StringBuilder to modify the string
    StringBuilder sb = new StringBuilder(s);
    sb.setCharAt(index, newChar);
    return sb.toString(); // Convert back to String if needed
}
static boolean isPattern(StringBuilder s, int i) {
    // Helper method to check for "1100" at position i
    return i >= 0 && i <= s.length() - 4 &&
           s.charAt(i) == '1' && s.charAt(i + 1) == '1' &&
           s.charAt(i + 2) == '0' && s.charAt(i + 3) == '0';
}
}