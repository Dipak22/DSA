public class BinarySearchBoundary {

    /*
    Problem statement#
    An array of boolean values is divided into two sections:
    the left section consists of all false, and the right section consists of all true.
    Find the boundary of the right section, i.e. the index of the first true element. If there is no true element, return -1.
     */

    static int findBoundary(boolean[] arr){
        int left = 0;
        int right = arr.length-1;
        int result =-1;
        while(left<=right){
            int mid = left +(right-left)/2;
            if(arr[mid]){
                result = mid;
                right = mid-1;
            }
            else{
                left = mid+1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("Find boundary :" + BinarySearchBoundary.findBoundary(new boolean[]{false, false, true, true, true}));
        System.out.println("Find boundary :" + BinarySearchBoundary.findBoundary(new boolean[]{true}));
        System.out.println("Find boundary :" + BinarySearchBoundary.findBoundary(new boolean[]{false, false, false}));
        System.out.println("Find boundary :" + BinarySearchBoundary.findBoundary(new boolean[]{true, true, true, true, true}));
        System.out.println("Find boundary :" + BinarySearchBoundary.findBoundary(new boolean[]{false, true}));
    }
}
