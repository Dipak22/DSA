import java.util.Arrays;
import java.util.HashMap;

public class SubArraySumDivisibleByK {

    /*
    Problem statement#
    Given an array of integers and an integer K, find the number of subarrays whose sums are divisible by K.

    Example:#
    Input: [3,1,2,5,1], 3

    Output: 6

    Explanation: the six subarrays are[3], [3,1,2], [1,2], [5,1], [3,1,2,5,1], [1,2,5,1]
     */

    public static int subarraySumDivisible(int[] nums, int k) {
        HashMap<Integer,Integer> prefixRemainder = new HashMap<>();
        int prefix = 0;
        int total =0;
        for(int i =0;i<nums.length;i++){
            prefix = (prefix+nums[i])%k;
            int compliment = k - prefix;
            prefixRemainder.put(compliment,prefixRemainder.getOrDefault(prefix,0)+1);
            if(prefixRemainder.containsKey(compliment)){
                total += prefixRemainder.get(compliment);
            }
        }
        return total;

    }

    public static void main(String[] arg){
        String[] inputs = {"3 1 2 5 1"};
        String[] inputs1 = {"3"};
        for(int i = 0; i < inputs.length; i++) {
            int[] nums = Arrays.stream(inputs[i].split(" ")).mapToInt(Integer::parseInt).toArray();
            int k = Integer.parseInt(inputs1[i]);
            System.out.println("Subarray sum divisible :"+SubArraySumDivisibleByK.subarraySumDivisible(nums, k));
        }
    }
}
