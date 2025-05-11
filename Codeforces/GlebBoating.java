import java.io.*;
import java.util.*;

public class GlebBoating {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int t = Integer.parseInt(br.readLine());
        
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            
            int power = k, pos = 0, turns = 0;
            boolean forward = true;
            
            while (pos + power != s) {
                if (forward) {
                    if (pos + power > s) {
                        forward = false;
                        power = Math.max(1, power - 1);
                        turns++;
                    } else {
                        pos += power;
                    }
                } else {
                    if (pos - power < 0) {
                        forward = true;
                        power = Math.max(1, power - 1);
                        turns++;
                    } else {
                        pos -= power;
                    }
                }
            }
            sb.append(power).append("\n");
        }
        
        System.out.print(sb);
    }
}