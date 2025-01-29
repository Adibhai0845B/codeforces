
import java.util.*;
public class Grad {
	static Scanner scan = new Scanner(System.in);
	static int t;
	static String s;
	public static void main(String[] args){
		t = scan.nextInt();
		while(t--!=0)
		{
			s = scan.next();
			int n = s.length();
			if(s.charAt(1)=='a')
			{
				System.out.print(s.charAt(0)+" "+s.charAt(1)+" ");
				System.out.println(s.substring(2, n));
			}else {
				System.out.println(s.charAt(0)+" "+s.substring(1,n-1)+" "+s.charAt(n-1));
			}
		}
	}
}
	
	