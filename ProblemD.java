import java.util.*;

public class Main{
	static StringBuilder res=new StringBuilder();
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0) {
			int n=sc.nextInt(), d=sc.nextInt(), k=sc.nextInt();
			
			int[] l=new int[n+1], r=new int[n+1];
			for(int i=0;i<k;i++) {
				l[sc.nextInt()]++;
				r[sc.nextInt()]++;
			}
			for(int i=1;i<=n;i++) {
				l[i]+=l[i-1]; 
				r[i]+=r[i-1];
			}
			int max=Integer.MIN_VALUE, min=Integer.MAX_VALUE;
			int first=-1, second=-1;
			int i=d;
			while(i<=n) {
				int cwc=l[i]-r[i-d];
				if(max<cwc) {
					max=cwc;
					first=i-d+1;
				}
				
				if(min>cwc) {
					min=cwc;
					second=i-d+1;
				}
				i++;
			}			
			res.append(first+" "+second);
			res.append("\n");
		}
		System.out.println(res);
		sc.close();
	}
}