public class PeakOfMountainArray {

    /*
    Find the index of the peak element. Assume there are no duplicates.

    Example#
    Input: 0 1 2 3 2 1 0

    Output: 3

    Explanation: The largest element is 3 and its index is 3.
     */

    static int peakOfMountainArray(int[] arr){
        int left =0;
        int right = arr.length-1;
        int result = -1;
        while(left<=right){
            int mid = left +(right-left)/2;
            if( mid == arr.length-1 || arr[mid]> arr[mid+1]){
                result = mid;
                right = mid-1;
            }
            else
                left = mid+1;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("Find peak of mountain :" + PeakOfMountainArray.peakOfMountainArray(new int[]{0, 1, 2, 3, 2, 1, 0}));
        System.out.println("Find peak of mountain :" + PeakOfMountainArray.peakOfMountainArray(new int[]{0, 10, 3, 2, 1, 2}));
        System.out.println("Find peak of mountain :" + PeakOfMountainArray.peakOfMountainArray(new int[]{0, 10, 0}));
    }
}
