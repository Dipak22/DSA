import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SubArraySum {
    /*
    Problem statement#
    Given an array of integers and an integer target, find a subarray that sums to target and returns the start and end indices of the subarray. It’s guaranteed to have a unique solution.

    Example:#
    Input: [1 -20 -3 30 5 4], 7

    Output: 1 4

    Explanation: -20 - 3 + 30 = 7. The indices for subarray [-20,-3,30] is 1 and 4 (right exclusive).
     */

    public static int[] subarraySum(int[] arr, int target) {
        Map<Integer,Integer> prefixSum = new HashMap<>();
        int prefix =0;
        for(int i=0;i<arr.length;i++){
            prefixSum.put(prefix,i);
            prefix+=arr[i];
            int compliment = prefix- target;
            if(prefixSum.containsKey(compliment)){
                return new int[]{(int) prefixSum.get(compliment),i};

            }

        }
        return new int[]{-1,-1};
    }

    public static void main(String[] arg){
        String[] inputs = {"1 3 -3 8 5 7","1 1 1","1 -20 -3 30 5 7"};
        String[] inputs1={"5","3","7"};
        for(int i = 0; i < inputs.length; i++) {
            int[] arr = Arrays.stream(inputs[i].split(" ")).mapToInt(Integer::parseInt).toArray();
            int target = Integer.parseInt(inputs1[i]);
            int[] res = SubArraySum.subarraySum(arr, target);
            System.out.println("Subarray sum : "+res[0] + " " + res[1]);
        }
    }
}
