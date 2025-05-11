import java.util.*;
import java.io.*;

public class DisjointSet {
    public static void main(String[] args) throws IOException {
        FastReader in = new FastReader();
        FastWriter out = new FastWriter();
        Mani solver = new Mani();
        solver.solve(1, in, out);
        out.close();
    }
}
class Mani {
    Graph g;
    public void solve(int testNumber, FastReader in, FastWriter out) throws IOException {
        int n = in.nextInt();
        int m = in.nextInt();
        g = new Graph();
        g.initGraph(n, m);
        for (int i = 0; i < m; ++i) {
            g.addEdge(in.nextInt() - 1, in.nextInt() - 1);
        }
        Set<Integer> h1=new HashSet<>();
       for(int i=0;i<n;i++) {
        h1.add(i);
        }
        int[] queue = new int[n];
        int size;
        List<Integer> a1;
        List<List<Integer>> finansw = new ArrayList<>();
        for(int fir = 0; fir < n; ++fir) {
            if (h1.contains(fir)) {
           size = 0;
        queue[size++] = fir;
          a1 = new ArrayList<>();
           h1.remove(fir);
        for (int i = 0; i < size; ++i) {
          a1.add(queue[i] + 1);
                Set<Integer> h1i1 = new HashSet<>();
   for (int j = g.first[queue[i]]; j != -1; j = g.next[j]) {
int to = g.to[j];
             if (h1.contains(to)) {
               h1i1.add(to);
               h1.remove(to);
            }
       }
             for(int x:h1) {
            queue[size++] = x;
                    }
                 h1.clear();
             h1.addAll(h1i1);
             }
             finansw.add(a1);
         }
        }
        out.println(finansw.size());
        for (List<Integer> list : finansw) {
            out.print(list.size());
            for (int vv : list) {
                out.print(" " + vv);
            }
            out.println();
        }
    }
}
class Graph {
    public int[] from;
    public int[] to;
    public int[] first;
    public int[] next;
    public int nVertex;
    public int nEdges;
    public int curEdge;
    public void initGraph(int n, int m) {
        curEdge = 0;
        nVertex = n;
        nEdges = m;
        from = new int[m * 2];
        to = new int[m * 2];
        first = new int[n];
        next = new int[m * 2];
        Arrays.fill(first, -1);
    }
    public void addEdge(int a, int b) {
        next[curEdge] = first[a];
        first[a] = curEdge;
        to[curEdge] = b;
        from[curEdge] = a;
        ++curEdge;

        next[curEdge] = first[b];
        first[b] = curEdge;
        to[curEdge] = a;
        from[curEdge] = b;
        ++curEdge;
    }
}
class FastReader {
    BufferedReader br;
    StringTokenizer st;

    public FastReader() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    String next() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }

    int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }

    String nextLine() throws IOException {
        return br.readLine();
    }
}

class FastWriter {
    private final BufferedWriter bw;
    public FastWriter() {
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    public void print(Object o) throws IOException {
        bw.write(o.toString());
    }

    public void println(Object o) throws IOException {
        bw.write(o.toString());
        bw.newLine();
    }

    public void println() throws IOException {
        bw.newLine();
    }

    public void close() throws IOException {
        bw.flush();
        bw.close();
    }
}
