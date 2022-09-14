public class WordBreak {
    /*
    Given a string and a list of words, determine if the string can be constructed from concatenating words
    from the list of words. A word can be used multiple times.

    Input:

    s = "educativeio"

    words = ["educative", "io"]

    Output: true

    Input:

    s = "aab"

    words = ["a", "c"]

    Output: false
     */

    static boolean wordBreak(String str,String[] words ){
        Boolean[] memo = new Boolean[str.length()];
        return wordBreakDfs(0, str, words,memo);
    }

    static boolean wordBreakDfs(int index, String str, String[] words,Boolean[] memo){
        if(index == str.length())
            return true;

        if(memo[index] != null)
            return memo[index];
        boolean ok = false;
        for(String word : words){
            if(str.substring(index).startsWith(word)){
                ok= ok || wordBreakDfs(index+word.length(),str,words,memo);
            }
        }
        memo[index] = ok;
        return ok;
    }

    public static void main(String[] args) {

        String[] inputs = {"algomonster", "aab", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab"};
        String[] inputs2 = {"algo monster", "a c", "a aa aaa aaaa aaaaa aaaaaa aaaaaaa aaaaaaaa aaaaaaaaa aaaaaaaaaa"};

        for (int i = 0; i<inputs.length; i++) {
            System.out.println("Word break : " + WordBreak.wordBreak(inputs[i], inputs2[i].split(" ")));
        }
    }
}
