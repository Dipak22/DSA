public class FindMinRotated {

    /*
    Problem statement#
    A sorted array was rotated at an unknown pivot. For example, [10, 20, 30, 40, 50] becomes [30, 40, 50, 10, 20]. Find the index of the minimum element in this array.

    Example#
    Input: [30, 40, 50, 10, 20]

    Output: 3

    Explanation: The smallest element is 10 and its index is 3.
     */
    static int findMinRotated(int[] arr){
        int left = 0;
        int right = arr.length-1;
        int result = -1;
        while(left<=right){
            int mid = left +(right-left)/2;
            if(arr[mid]<=arr[arr.length-1]){
                result = mid;
                right =mid -1;
            }
            else{
                left = mid+1;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println("Find minimum rotated :" + FindMinRotated.findMinRotated(new int[]{30, 40, 50, 10, 20}));
        System.out.println("Find minimum rotated :" + FindMinRotated.findMinRotated(new int[]{0, 1, 2, 3, 4, 5}));
        System.out.println("Find minimum rotated :" + FindMinRotated.findMinRotated(new int[]{0}));
    }
}
