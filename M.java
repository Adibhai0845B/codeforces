import java.util.*;
/*
 AdiBhai0845R
  AdiBhai0845R
   AdiBhai0845R
    AdiBhai0845R
     AdiBhai0845R
      AdiBhai0845R
 */
 class M {
    public  void main(int nums[],int target) {
        int ans[] = {-1,-1};
       int s = search(nums, target, true);
      int e = search(nums, target, false);
      ans[0] = s;
      ans[1] = e;
    }
  public  int binarySearch(int[] array, int target,int left,int right) {
   
    while (left <= right) {
        int mid = left + (right - left) / 2;

        // Check if target is present at mid
        if (array[mid] == target) {
            return mid;
        }

        // If target is greater, ignore the left half
        if (array[mid] < target) {
            left = mid + 1;
        } else {
            // If target is smaller, ignore the right half
            right = mid - 1;
        }
    }
    return -1;
}
int search(int array[],int target,boolean first){
   int ans = -1;
    int left =0;
   int right = array.length-1;
    while (left <= right) {
        int mid = left + (right - left) / 2;

        // Check if target is present at mid
        if (array[mid] == target) {
            ans = mid;
            if(first==true){
                right = mid-1;
            }
            else{
                left = mid+1;
            }
        }

        // If target is greater, ignore the left half
        if (array[mid] < target) {
            left = mid + 1;
        } else {
            // If target is smaller, ignore the right half
            right = mid - 1;
        }
    }
    return ans;
}
}