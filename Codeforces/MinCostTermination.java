import java.io.*;
import java.util.*;

public class MinCostTermination {
    static int MAX_N = (int) 1e9;
    
    static class DSU {
        int[] parent, size;

        DSU(int n) {
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        int find(int x) {
            if (parent[x] != x) parent[x] = find(parent[x]);
            return parent[x];
        }

        void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                if (size[rootX] < size[rootY]) {
                    int temp = rootX;
                    rootX = rootY;
                    rootY = temp;
                }
                parent[rootY] = rootX;
                size[rootX] += size[rootY];
            }
        }
    }

    static Map<Integer, Integer> terminateAtZero(int num) {
        Map<Integer, Integer> steps = new HashMap<>();
        int stepsCount = 0;
        while (num > 0) {
            steps.put(num, stepsCount);
            if (num % 2 == 1) num /= 2;
            else break;
            stepsCount++;
        }
        return steps;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int t = Integer.parseInt(st.nextToken());
        
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            
            int[] n = new int[m];
            int[] y = new int[m];
            
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                n[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                y[i] = Integer.parseInt(st.nextToken());
            }

            // DSU to group numbers reaching the same final state
            DSU dsu = new DSU(m);
            Map<Integer, Integer> indexMap = new HashMap<>();
            List<Integer> terminatingIndices = new ArrayList<>();
            PriorityQueue<int[]> changeCostPQ = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

            for (int i = 0; i < m; i++) {
                Map<Integer, Integer> steps = terminateAtZero(n[i]);
                if (steps.containsKey(0)) terminatingIndices.add(i);
                
                for (int key : steps.keySet()) {
                    if (indexMap.containsKey(key)) {
                        dsu.union(indexMap.get(key), i);
                    }
                    indexMap.put(key, i);
                }
                changeCostPQ.offer(new int[]{y[i], i});  // Store (cost, index)
            }

            int alreadyZero = terminatingIndices.size();
            if (alreadyZero == k) {
                out.println(0);
                continue;
            }

            List<Integer> groupSizes = new ArrayList<>();
            boolean[] visited = new boolean[m];
            for (int i = 0; i < m; i++) {
                int root = dsu.find(i);
                if (!visited[root]) {
                    groupSizes.add(dsu.size[root]);
                    visited[root] = true;
                }
            }

            Collections.sort(groupSizes);
            int needToChange = Math.abs(k - alreadyZero);
            long minCost = 0;
            if (alreadyZero < k) {
                if (groupSizes.size() < needToChange) {
                    out.println(-1);  // Not possible to achieve k
                    continue;
                }
                for (int i = 0; i < needToChange; i++) {
                    minCost += groupSizes.get(i);
                }
            } else {
                if (changeCostPQ.size() < needToChange) {
                    out.println(-1);  // Not enough numbers to reduce
                    continue;
                }
                for (int i = 0; i < needToChange; i++) {
                    minCost += changeCostPQ.poll()[0];
                }
            }            
            out.println(minCost);
        }
        out.flush();
    }
}
