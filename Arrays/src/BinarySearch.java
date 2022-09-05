public class BinarySearch {

    static int binarySearch(int[] arr,int target){
        int low =0;
        int high = arr.length-1;

        while(low<=high){
            int mid = low +(high-low)/2;
            if(arr[mid]==target)
                return mid;
            else if (arr[mid]>target){
                high = mid-1;
            }
            else
                low = mid+1;
        }
        return -1;
    }

    public static void main(String[]  args){
        int[] arr = {1,3,7,9,20,27,100};
        int target = 20;
        System.out.println(binarySearch(arr,target));
    }
}
