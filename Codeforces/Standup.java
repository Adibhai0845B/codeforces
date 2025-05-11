import java.util.*;
public class Standup
{
	public static long findMinincrease(int[] threadSize) {
        int n = threadSize.length;
        int m = n - 2;
        if (m <= 0) {
            return 0;
        }
        
        long groupA_cost = 0;
        long groupB_cost = 0;
        
        for (int f = 2; f <= n -1; f++) {
            int index = f -1; 
            int left = threadSize[index -1];
            int right = threadSize[index +1];
            long target = Math.max((long)left, (long)right) +1;
            long cost = target - (long)threadSize[index];
            if (cost <0){
                cost =0;
            }
            if (f %2 ==0){
                groupA_cost += cost;
            }
            else{
                groupB_cost += cost;
            }
        }
        
        if (m %2 ==1){
            return groupA_cost;
        }
        else{
            return Math.min(groupA_cost, groupB_cost);
        }
    }
//Find mini increase

    public static void main(String[] args) {
        int[] threadSize = {3, 1, 4, 5, 5, 2};
        System.out.println(findMinincrease(threadSize));
    }
}