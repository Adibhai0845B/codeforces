import java.io.*;
import java.util.*;

public class SegLazy {
    public static void main(String[] args) throws IOException {
        FastInput sc = new FastInput();
       int n = sc.nextInt();
        long seg[] = new long[4*n];
        long lazy[] = new long[4*n];
        int a[] = new int[n];
        for(int i =0;i<n;i++){
            a[i] =sc.nextInt();
        }
        build(0,0,n-1,a,seg);
        int q = sc.nextInt();
        while(q-->0){
            int type = sc.nextInt();
            if(type==1){
                int l = sc.nextInt();
                int r = sc.nextInt();
               int val = sc.nextInt();
                update(0,0,n-1,l,r,seg,a,lazy,val);
            }
            else{
                int l = sc.nextInt();
                int r = sc.nextInt();
                System.out.println(query(0,0,n-1,l,r,seg,a,lazy));
            }
        }
        System.out.println(Arrays.toString(a));
    }
    public static  void build(int ind, int low,int high,int a[],long seg[]){
         if(low==high){
            seg[ind]=a[low];
         }
         int mid = (low+high)/2;
         build(2*ind+1,low,mid,a,seg);
         build(2*ind+2,mid+1,high,a,seg);
         seg[ind] =seg[ind*2+1]+seg[2*ind+2];
    }
    public static  void update(int ind,int low,int high, int l ,int r,long seg[], int a[],long lazy[],int val){
     if(lazy[ind]!=0){
        seg[ind]+=lazy[ind];
       if(low!=high){
          lazy[2*ind+1] +=lazy[ind];
          lazy[2*ind+2] +=lazy[ind];
       }
       lazy[ind] =0;
    }
    if(high<l||low>r){
        return ;
    }
    if(low>=l&&high<=r){
        seg[ind]+=val;
        if(low!=high){
            lazy[2*ind+1] +=val;
            lazy[2*ind+2] +=val;
        }
        return;
    }
    int mid = (low+high)/2;
    update(2*ind+1,low,mid,l,r,seg,a,lazy,val);
    update(2*ind+2,mid+1,high,l,r, seg,a,lazy,val);
       seg[ind] = Math.min(seg[2*ind+1],seg[2*ind+2]);   
}
public static  long query(int ind ,int low,int high , int l ,int r , long seg[],int a[],long lazy[]){
      if(lazy[ind]!=0){
        seg[ind] +=lazy[ind];
                 if(low!=high){
                    lazy[2*ind+1] +=lazy[ind];
                    lazy[2*ind+2] +=lazy[ind];
                 }
                 lazy[ind] =0;
      }    
    if(high<l||low>r){
            return Integer.MAX_VALUE;
          }
          if(low>=l&&high<=r){
          return seg[ind];  
        }
        int mid = (low+high)/2;
        long left =  query(2*ind+1,low,mid,l,r,seg,a,lazy);
        long right =  query(2*ind+2,mid+1,high,l,r,seg,a,lazy);
         return Math.min(left,right);
    }
    }
    // for minimum
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
class Pair {
    long  first, second;

    Pair(long first, long second) {
        this.first = first;
        this.second = second;
    }
}


