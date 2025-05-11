import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Jah{
    static char[] arr;
    static int[] seg;
    static int[] left;
    static int[] right;
    public static void build(int v,int l,int r){
        if(l+1==r) {
            if(arr[l]=='(')
                left[v] = 1;
            else
                right[v] = 1;
        }
        else{
           int  mid = (l+r)/2;
            build(2*v,l,mid);
            build(2*v+1,mid,r);
            int val = Math.min(left[2*v],right[2*v+1]);
            seg[v] = seg[2*v] + seg[2*v+1]+ val*2;
            left[v] = left[2*v] + left[2*v+1] -val;
            right[v] = right[2*v] + right[2*v+1] - val;
        }
    }
    public static int[] query(int x,int y,int i,int l,int r){
        if(l>=y || x>=r)
            return new int[]{0,0,0};
        if(x<=l && r<=y)
            return new int[]{seg[i],left[i],right[i]};
        int mid = (l+r)/2;
        int[] ans1 = query(x,y,2*i,l,mid); int[] ans2 = query(x,y,2*i+1,mid,r);
        int v = Math.min(ans1[1],ans2[2]);
        int s =ans1[0] +ans2[0]+ v*2; int left = ans1[1]+ans2[1]-v;
        int right = ans1[2]+ans2[2]-v;
        return new int[]{s,left,right};
    }
    public static void main(String[] args) throws IOException {
        BufferedReader in  = new BufferedReader(new InputStreamReader(System.in));
        arr = in.readLine().toCharArray();
        seg = new int[arr.length*4];
        left = new int[arr.length*4];
        right = new int[arr.length*4];
        build(1,0,arr.length);
        int q = Integer.parseInt(in.readLine());
        for(int i=0;i<q;i++){
            String[] input = in.readLine().split(" ");
            int l = Integer.parseInt(input[0]) -1;
            int r =Integer.parseInt(input[1]);
            System.out.println(query(l,r,1,0,arr.length)[0]);
        }
    }
}