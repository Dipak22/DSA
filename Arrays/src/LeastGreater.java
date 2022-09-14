public class LeastGreater {
    /*
    Problem statement#
    Given an array of integers sorted in increasing order and a target,
    find the index of the first element in the array that is larger or equal to the target.
    Assume that it is guaranteed to find a satisfying number.

    Example#
    Input: arr = [1, 3, 3, 5, 8, 8, 10],target = 2

    Output: 1
     */

    static int first_not_smaller(int[] arr,int target){
        int left = 0;
        int right = arr.length-1;
        int result = -1;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(arr[mid]>= target){
                result = mid;
                right = mid -1;
            }
            else{
                left = mid+1;
            }

        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("Find first element :" + LeastGreater.first_not_smaller(new int[]{1, 3, 3, 5, 8, 8, 10}, 2));
        System.out.println("Find first element :" + LeastGreater.first_not_smaller(new int[]{0}, 0));
        System.out.println("Find first element :" + LeastGreater.first_not_smaller(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 10));
        System.out.println("Find first element :" + LeastGreater.first_not_smaller(new int[]{1, 1, 1, 1, 4, 5}, 3));
    }
}
