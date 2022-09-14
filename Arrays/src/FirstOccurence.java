public class FirstOccurence {

    static int find_first_occurrence(int[] arr, int target){
        int left = 0;
        int right = arr.length-1;
        int result = -1;
        while(left<=right){
            int mid = left +(right-left)/2;
            if(arr[mid]== target){
                result = mid;
                right = mid-1;
            }
            else if(arr[mid]< target)
                left = mid+1;
            else
                right = mid-1;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("Find occurrence :" + FirstOccurence.find_first_occurrence(new int[]{1, 3, 3, 3, 3, 6, 10, 10, 10, 100}, 3));
        System.out.println("Find occurrence :" + FirstOccurence.find_first_occurrence(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, 1));
        System.out.println("Find occurrence :" + FirstOccurence.find_first_occurrence(new int[]{1, 22, 22, 33, 50, 100, 20000}, 33));
        System.out.println("Find occurrence :" + FirstOccurence.find_first_occurrence(new int[]{4, 6, 7, 7, 7, 20}, 8));
        System.out.println("Find occurrence :" + FirstOccurence.find_first_occurrence(new int[]{6, 7, 9, 10, 10, 10, 90}, 10));
        System.out.println("Find occurrence :" + FirstOccurence.find_first_occurrence(new int[]{4}, 4));
    }
}
