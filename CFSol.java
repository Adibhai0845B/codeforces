import java.util.*;
public class CFSol {
    public static void main(String args[] ) throws Exception {
       
      Scanner sc=new Scanner(System.in);
     int t=sc.nextInt();
     while(t>0){
   int n=sc.nextInt();
   int m=sc.nextInt();
   int k=sc.nextInt();
   int jf[]=new int[n];
   int gf[]=new int[m];

   for(int i=0;i<n;i++){
        jf[i]=sc.nextInt();
       
   }
   for(int i=0;i<m;i++){
    gf[i]=sc.nextInt();
   }
   Arrays.sort(gf);
   Arrays.sort(jf);
   int min=(int)Math.min(gf[0],jf[0]);
   int max=(int)Math.max(gf[m-1],jf[n-1]);
   if(jf[0]<gf[m-1]){
   jf[0]=jf[0]+gf[m-1];
   gf[m-1]=jf[0]-gf[m-1];
   jf[0]=jf[0]-gf[m-1];
   }
   long jsum=0;
   for(int i=0;i<n;i++){
	jsum+=jf[i];
   }
   System.out.println(((k-1)%2==0)? jsum:jsum-max+min);
    t--;
  
     }
}
}