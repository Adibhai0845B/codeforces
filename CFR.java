import java.util.*;
public class CFR{
	static int[] f=new int[212345];
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int m=in.nextInt();
		long[] a=new long[n+1];
		for (int i=1;i<=n;++i)
		  a[i]=in.nextLong();
		Pair[] t=new Pair[n+m];
		for (int i=0;i<n+m-1;++i) t[i]=new Pair();
		for (int i=0;i<m;++i) {
			t[i].first=in.nextInt();t[i].second=in.nextInt();t[i].third=in.nextLong();
		}
		int id=1;
		for (int i=2;i<=n;++i) if (a[i]<a[id])
			id=i;
		int anscnt=m;
		for (int i=1;i<=n;++i) if (id!=i) {
			t[anscnt].first=id;t[anscnt].second=i;t[anscnt++].third=a[id]+a[i];
		}
        Arrays.sort(t,0,n+m-1);
		for (int i=1;i<=n;++i)f[i]=i;
		long answ=0;
		for(int i=0;i<n+m-1;++i) {
			int num1=F(t[i].first);int pare=F(t[i].second);
			if (num1!=pare) {
				answ+=t[i].third;f[num1]=pare;
			}
        }
		System.out.println(answ);
	}
    public static int F(int x) {
        return f[x]==x?x:(f[x]=F(f[x]));
    }
    static class Pair implements Comparable<Pair> {
		int first,second;
		long third;
        Pair(){}
		Pair(int fir,int sec,long thir) {
			first=fir;
			second=sec;
			third=thir;
		}
		@Override
		public int compareTo(Pair o) {
			return Long.compare(third,o.third);
		}
	};
}