import java.util.*;

public class q1
{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0)
		{
			String s=sc.next();
			int n=s.length(); 
		
			ArrayList<Integer> a=new ArrayList();
			int k=0,j=0,sum=0;
			for(int i=0;i<n;i++){
				if(s.charAt(i)=='A'){
					k++;
				    sum++;
			}
				else{
					j++;
					if(k!=0)a.add(k);
					k=0;
				}
				
			}
			if(k!=0)a.add(k);
			Collections.sort(a);
			if(j>=a.size())System.out.println(sum);
			else System.out.println(sum-a.get(0));
		
		//System.out.println(a);

		}
	}
}
