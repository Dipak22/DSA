import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DecodeString {

    /*
    Given a non-empty string of digits, how many ways are there to decode it?

Example 1#
Input: "18"

Output: 2

Explanation: "18" can be decoded as "AH" or "R"

Example 2#
Input: "123"

Output: 3

Explanation: "123" can be decoded as "ABC", "LC", "AW"
     */

    private static final List<String> LETTERS = IntStream.range(1, 27).mapToObj(Integer::toString).collect(Collectors.toList());


    static int countDecodeWays(String input){
        return dfs(input, 0, LETTERS);
    }

    static int dfs(String input, int index, List<String> LETTERS){
        if(index==input.length())
            return 1;
        int decodeWays = 0;
        for(String prefix : LETTERS){
            if(input.substring(index).startsWith(prefix)){
                decodeWays+= dfs(input,index+prefix.length(),LETTERS);
            }
        }
        return decodeWays;
    }
    public static void main(String[] args) {

        String[] inputs = {"12", "123", "11223"};
        for (int i = 0; i<inputs.length; i++) {
            System.out.println("Decode ways : " + DecodeString.countDecodeWays(inputs[i]));
        }
    }
}
