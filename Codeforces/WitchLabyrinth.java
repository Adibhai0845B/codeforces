import java.util.*;
public class WitchLabyrinth {
    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};
    static final char[] dirs = {'U', 'D', 'L', 'R'};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
          while(t-->0){
            int n = sc.nextInt();
            int m = sc.nextInt();
            sc.nextLine();
            char[][] a = new char[n][m];
            for (int i = 0; i < n; i++) {
                String row = sc.nextLine();
               a[i] = row.toCharArray();
            }
            System.out.println(gri(n, m, a));
        }
        sc.close();
    }
    static int gri(int n, int m, char[][] grid) {
        if (seforcount(grid) == 0) {
            return funct1(n, m, grid);
        }
        return funct2(n, m, grid);
    }
    static int funct2(int n, int m, char[][] grid) {
        int msee = 0;
        List<int[]> un = positionarraylist(grid);
        int gt = un.size(); int total = (int) Math.pow(4, gt);
        for (int j = 0; j <total;j++) {
            char[][] currentGrid = new char[n][m];
            for (int i = 0; i < n; i++) {
                currentGrid[i] = Arrays.copyOf(grid[i], m);
            } int tom = j;
            for (int[] pos : un) {
                int hg = tom % 4;
                currentGrid[pos[0]][pos[1]] = dirs[hg];
                tom /= 4;
            }
            msee = Math.max(msee, funct1(n, m, currentGrid));
        }
        return msee;
    }
    static int funct1(int n, int m, char[][] grid) {
        int go = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (funct4(n, m, grid, i, j)) {
                    go++;
                }
            }
        }
        return go;
    }
    static boolean funct4(int n, int m, char[][] grid, int xg, int yg) {
        boolean[][] visited = new boolean[n][m];
        int x = xg, y = yg;
        while (x >= 0 && x < n && y >= 0 && y < m) {
            if (visited[x][y]) return true;
            visited[x][y] = true;
            int dirIndex = search(grid[x][y]);
            x += dx[dirIndex];
            y += dy[dirIndex];
        }
        
        return false;
    }
    static int search(char dir) {
        switch (dir) {
            case 'U': return 0;
            case 'D': return 1;
            case 'L': return 2;
            case 'R': return 3;
            default: return -1;
        }
    }
    static int seforcount(char[][] grid) {
        int ans = 0;
        for (char[] r : grid) {
            for (char c : r) {
                if (c == '?') ans++;
            }
        }
        return ans;
    }
    
    static List<int[]> positionarraylist(char[][] grid) {
        List<int[]> l = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '?') {
                  l.add(new int[]{i, j});
                }
            }
        }
        return l;
    }
}