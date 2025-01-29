import java.util.Scanner;

public class Raspberries {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while (t-->0){
            int n=sc.nextInt(),k=sc.nextInt(),min=k,l=0;
            for (int i=0;i<n;i++){
                int a=sc.nextInt();
                if (a%2==0)l++;
                if (a%k==0)min=0;
                else min=Math.min(k-a%k,min);
            }
            System.out.println(k==4?Math.min(min,Math.max(2-l,0)):min);
        }
    }
}