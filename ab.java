import java.util.Scanner;

public class ab {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int n = s.length();
        StringBuilder sb = new StringBuilder();
  int x = 0;
  int y =0;
  for(int i =0;i<n;i++){
    if(s.charAt(i)=='x'){
        x++;
    }
    else{
        y++;
    }
  }
  int c = Math.abs(x-y);
  if(x>y){
    for(int i =0;i<c;i++){
        sb.append('x');
    }
  }
  else{
    for(int i =0;i<c;i++){
        sb.append('y');
    }
  }
  System.out.println(sb.toString());
    }
}
