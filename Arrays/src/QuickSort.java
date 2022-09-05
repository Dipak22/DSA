import java.util.Arrays;

public class QuickSort {

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
