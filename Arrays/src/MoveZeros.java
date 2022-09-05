import java.util.Arrays;

public class MoveZeros {

    /*
    Move '0' entries to the left in arrays.
     */
    static void moveZerosToLeft(int[] arr){
        int readIndex=arr.length-1;
        int writeIndex = arr.length-1;

        while(readIndex>=0){
            if(arr[readIndex]!=0){
                arr[writeIndex--] = arr[readIndex];

            }
            readIndex--;
        }
        for(int i=writeIndex ;i>=0;i--){
            arr[i]=0;
        }
    }
    public static void main(String[] args) {
        int[][] numsList = {{1, 10, 20, 0, 59, 63, 0, 88, 0}, {1, 0, 2, 3, 0}, {0},
                {-1, 0, 0, -2, 9}, {1, 2, 3, 4, 5}, {2}};

        for (int i = 0; i < numsList.length; i++) {
            System.out.println((i + 1) + ". Before list:\t" + Arrays.toString(numsList[i]));
            moveZerosToLeft(numsList[i]);
            System.out.println("   After list:\t" + Arrays.toString(numsList[i]));
            System.out.println(
                    "----------------------------------------------------------------------------------------------------\n");
        }
    }
}
