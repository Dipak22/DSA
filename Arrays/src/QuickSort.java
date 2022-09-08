import java.util.Arrays;

public class QuickSort {

    static int partition(int[] arr,int low,int high){
        int pivotElem = arr[low];
        int i=low,j=high;
        while(i<j){
            while(i<high && arr[i]<= pivotElem)
                i++;
            while(j>low && arr[j]>pivotElem)
                j--;
            if(i<j){
                int temp =arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // swap pivot, to put it in correct position
        arr[low] = arr[j];
        arr[j] = pivotElem;
        return j;
    }

    static void quickSortRec(int[] arr,int low,int high){

        if(low<high){
            int pivot = partition(arr,low,high);
            quickSortRec(arr,low,pivot-1);
            quickSortRec(arr,pivot+1,high);
        }
    }

    static void quickSort(int[] arr){
        quickSortRec(arr,0,arr.length-1);
    }

    public static void main(String[] args) {
        int[][] numsList = {{55, 23, 26, 2, 18, 78, 23, 8, 2, 3}, {1}, {9, 8, 7, 2, 3, 1},
                {10, 20, 30, -1, -2}};

        for (int i = 0; i < numsList.length; i++) {
            System.out.println((i + 1) + ". Before Sorting");
            System.out.println("   " + Arrays.toString(numsList[i]));

            quickSort(numsList[i]);

            System.out.println("   After Sorting");
            System.out.println("   " + Arrays.toString(numsList[i]));
            System.out.println(
                    "-----------------------------------------------------------------------------------------------------\n");
        }

    }
}
