import java.util.Arrays;

public class BInarySearchRotated {
    /*
    We’re given a sorted integer array, nums and an integer value, target.
    The array is rotated by some arbitrary number.
    Search the target in this array. If the target does not exist then return -1.
     */

    static int binarySearchRotated(int[] nums, int target){
        int low = 0;
        int high = nums.length-1;
        while(low<=high){
            int mid = low +(high-low)/2;
            if(nums[mid]==target)
                return mid;
            //if first halve sorted.
            else if(nums[low]<=nums[mid]){
                if(target>=nums[low] && target<nums[mid])
                    high = mid-1;
                else
                    low = mid+1;
            }
            // if second halve sorted
            else{
                if(target>nums[mid] && target <=nums[high])
                    low = mid +1;
                else
                    high = mid-1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] targetList = {3, 6, 3, 6};
        int[][] numsList = {{6, 7, 1, 2, 3, 4, 5}, {6, 7, 1, 2, 3, 4, 5}, {4, 5, 6, 1, 2, 3},
                {4, 5, 6, 1, 2, 3}};

        for (int i = 0; i < targetList.length; i++) {
            System.out.println((i + 1) + ". Rotated array: " + Arrays.toString(numsList[i]));
            System.out.println("   target " + targetList[i] + " found at index "
                    + binarySearchRotated(numsList[i], targetList[i]));
            System.out.println(
                    "----------------------------------------------------------------------------------------------------\n");
        }
    }
}
