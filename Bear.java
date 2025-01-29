import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bear {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(sc.readLine());
        int k = Integer.parseInt(sc.readLine());
        String s = sc.readLine();
        int max =0;   
        int diff[] = new int[n];
        for(int i =0;i<n;i++){
            max+=(int)('z'-s.charAt(i));
             diff[i] = (int)('z'-s.charAt(i));
        }
        if(k>max){
            System.out.println("-1");
        }
        else{
            StringBuilder sb = new StringBuilder();
            int i =0;
            while(i<n){
          if(diff[i]<k){
            sb.append('z');
               k-=diff[i];
               i++;
          }
          else if(diff[i]>k){
  sb.append();
          }
            }
        }
    }
}
