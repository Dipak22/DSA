import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneLetterPermutation {
    private static final Map<Character, char[]> KEYBOARD = new HashMap<>();
    static {
        KEYBOARD.put('2', "abc".toCharArray());
        KEYBOARD.put('3', "def".toCharArray());
        KEYBOARD.put('4', "ghi".toCharArray());
        KEYBOARD.put('5', "jkl".toCharArray());
        KEYBOARD.put('6', "mno".toCharArray());
        KEYBOARD.put('7', "pqrs".toCharArray());
        KEYBOARD.put('8', "tuv".toCharArray());
        KEYBOARD.put('9', "wxyz".toCharArray());
    }
    public static List<String> letterCombinationsOfPhoneNumber(String digits) {
        StringBuilder path = new StringBuilder();
        List<String> result = new ArrayList<>();
        letterCombinationsOfPhoneNumberDfs(path,result,digits.toCharArray());
        return result;
    }

    static void letterCombinationsOfPhoneNumberDfs(StringBuilder path, List<String> result, char[] digits){
        if(path.length() == digits.length){
            result.add(path.toString());
            return;
        }
        for(char letter : KEYBOARD.get(digits[path.length()])){
            path.append(letter);
            letterCombinationsOfPhoneNumberDfs(path,result,digits);
            path.deleteCharAt(path.length()-1);

        }
    }

    public static void main(String[] args) {
        String[] inputs = {"56", "23", "235"};
        for(int i = 0; i < inputs.length; i++) {
            System.out.println("Letter combinations of phone number : " + PhoneLetterPermutation.letterCombinationsOfPhoneNumber(inputs[i]));
        }
    }
}
