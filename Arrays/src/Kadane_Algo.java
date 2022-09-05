import java.util.Arrays;

public class Kadane_Algo {

    static int findMaxSumSubArray(int[] arr){
        int globalSum =arr[0];
        int currentSum = arr[0];
        for(int i=1;i<arr.length;i++){
            if(currentSum<0)
                currentSum=arr[i];
            else
                currentSum += arr[i];
            if(globalSum<currentSum)
                globalSum = currentSum;
        }
        return globalSum;
    }
    public static void main(String[] args){
        int[] arr1 = {1, 7, -2, -5, 10, -1};
        System.out.println("Array: "+ Arrays.toString(arr1));
        System.out.println("Sum: " + findMaxSumSubArray(arr1));
    }
}
