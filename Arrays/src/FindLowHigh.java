import java.util.Arrays;

public class FindLowHigh {
    /*
    We’re given a sorted array of integers, nums, and an integer value, target.
    Return the low and high index of the given target element. If the indexes are not found, return -1.
     */

    static int findLowIndex(int[] nums,int target){
        int low=0;
        int high = nums.length-1;

        while(low<=high){
            int mid = low +(high-low)/2;
            if(target>nums[mid])
                low = mid+1;
            else
                high = mid-1;
        }

        if(low<nums.length && nums[low]==target)
            return low;
        return -1;
    }

    static int findHighIndex(int[] nums,int target){
        int low=0;
        int high =nums.length-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(target>=nums[mid])
                low = mid+1;
            else
                high = mid-1;
        }
        if(high>=0 && nums[high]==target )
            return high;
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 6, 6, 6, 6, 6, 6};
        System.out.println("Original List: " + Arrays.toString(nums) + "\n");

        int target = 5;
        int low = findLowIndex(nums, target);
        int high = findHighIndex(nums, target);
        System.out.println("Low Index of " + target + ": " + low);
        System.out.println("High Index of " + target + ": " + high);

        System.out.println();

        target = -2;
        low = findLowIndex(nums, target);
        high = findHighIndex(nums, target);
        System.out.println("Low Index of " + target + ": " + low);
        System.out.println("High Index of " + target + ": " + high);
    }
}
