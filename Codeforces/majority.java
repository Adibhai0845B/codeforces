/*AdiBHai0845R */
import java.io.*;
import java.util.*;
public class majority {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine()); 
        while (t > 0) {
            t--;
        String[] nmq = br.readLine().split(" ");    
        int n = Integer.parseInt(nmq[0]);
       int m = Integer.parseInt(nmq[1]);
      int q = Integer.parseInt(nmq[2]);
            int[] a = new int[n];
            Queue<Integer> q1 = new LinkedList<>();
            String[] aStr = br.readLine().split(" ");   
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(aStr[i]);
                q1.add(a[i]);
            }
            
            int[] b = new int[m];
            String[] bStr = br.readLine().split(" ");
            
            for (int i = 0; i < m; i++) {
                b[i] = Integer.parseInt(bStr[i]);
            }
            
            int count = 0;
            HashSet<Integer> a1 = new HashSet<>();
            for (int i = 0; i < m; i++) {
                if (!a1.contains(b[i])) {
                    if (!q1.isEmpty()) {
                        int f = q1.poll();
               a1.add(f);               
                        if (f != b[i] && !a1.contains(b[i])) {     
                                 count++;
              break;

                        }
                    } else {                if (!a1.contains(b[i])) {
                            count++;
                            break;
                        }
                    }
                }
            }    if (count > 0) {
                bw.write("TIDAK\n");
            } else {
                bw.write("YA\n");     }
        }
        bw.flush();
        bw.close();
    }
}
