import java.io.*;
import java.util.*;

public class SegmentTree {
    public static void main(String[] args) throws IOException {
        FastInput sc = new FastInput();
         int n = sc.nextInt();
             long m = sc.nextlong();
             long a[] =new long[n];
             for(int i=0;i<n;i++){
                a[i] = sc.nextlong();
             }
             long seg[] = new long[4*n];
             build(0, 0, n-1, a, seg);
             while(m-->0){
                long type = sc.nextlong();
                if(type==1){
                    long i = sc.nextlong();
                    long val = sc.nextlong();
                    update(0,0,n-1,i, val, seg);
                }
           else{
            long l = sc.nextlong();
            long r = sc.nextlong();
            long ans = query(0,0,n-1,l,r-1,a,seg);
            System.out.println(ans);
           }
             }
   }
   public static void build(int ind,int low,int high,long a[],long seg[]){
        if(low==high){
            seg[ind] = a[low];
            return;
        }
       int mid =(low+high)/2;
     build(2*ind+1,low,mid,a,seg);
      build(2*ind+2,mid+1,high,a,seg);
     seg[ind] = seg[2*ind+1]+seg[2*ind+2];
   }
   public static long query(int ind, long low, long high,long l,long r,long a[],long seg[]){
        if(low>r||high<l){
              return 0;
        }
        if(low>=l&&high<=r){
              return seg[ind];
        }
        long mid = (low+high)/2;
        long left = query(2*ind+1,low,mid,l,r,a,seg);
        long right = query(2*ind+2,mid+1,high,l,r,a,seg);
        return left+right;
   }
   public static void update(int ind,long low,long high,long i ,long val,long seg[]){
    if(low==high){
        seg[ind] = val;
        return;
    }
    long mid = (low+high)/2;
   if(i<=mid)update(2*ind+1,low,mid,i,val,seg);
   else update(2*ind+2,mid+1,high,i,val,seg);
   seg[ind] = seg[2*ind+1]+seg[2*ind+2];
}
}
 class FastInput {
    BufferedReader br;
    StringTokenizer st;

    public FastInput() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    String next() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine());
        }
        return st.nextToken();
    }

int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    long nextlong() throws IOException {
        return Long.parseLong(next());
    }

    double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }

    String nextLine() throws IOException {
        return br.readLine();
    }

    public void close() throws IOException {
        br.close();
    }
}
class Pair3 {
    long  first, second, third;

    Pair3(long first, long second, long third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }
}


