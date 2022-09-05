import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class MaxSlidingWindow {

    /*
    Given an integer array and a window of size w,
    find the current maximum value in the window as it slides through the entire array.
     */
    static ArrayDeque<Integer> findMaxSlidingWindow(int[] arr, int windowSize){
        ArrayDeque<Integer> result = new ArrayDeque<>();
        Deque<Integer> list = new ArrayDeque<>();

        if(windowSize>arr.length)
            windowSize = arr.length;
        for(int i=0;i<windowSize;i++){
            while(!list.isEmpty() && arr[i]>=arr[list.peek()])
                list.removeFirst();
            list.addLast(i);
        }
        for(int i= windowSize;i<arr.length;i++){
            result.addLast(arr[list.peekFirst()]);
            while(!list.isEmpty() && list.peek()<=i-windowSize)
                list.removeFirst();
            while(!list.isEmpty() && arr[i]>=arr[list.peek()])
                list.removeFirst();
            list.addLast(i);
        }
        result.addLast(arr[list.peekFirst()]);
        return result;
    }


    public static void main(String[] args) {
        int[] targetList = {3, 2, 1, 2};
        int[][] numsList = {{1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
                {10, 6, 9, -3, 23, -1, 34, 56, 67, -1, -4, -8, -2, 9, 10, 34, 67},
                {4, 5, 6, 1, 2, 3}, {9, 5, 3, 1, 6, 3}};
        for (int i = 0; i < targetList.length; i++) {
            System.out.println((i + 1) + ". Original list:\t" + Arrays.toString(numsList[i]));
            System.out.println("   Window size:\t\t" + targetList[i]);
            ArrayDeque<Integer> output = findMaxSlidingWindow(numsList[i], targetList[i]);
            System.out.println("   Max:\t\t\t" + output);
            System.out.println(
                    "-----------------------------------------------------------------------------------------------------\n");
        }
    }
}
