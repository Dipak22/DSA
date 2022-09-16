import java.util.*;

public class WordLadder {

    /*
    Given a start word, an end word, and a list of dictionary words, determine the minimum number of steps to go from the start word to the end word using only words from the dictionary.

    Example#
    Input:

    start = "COLD"
    end = "WARM"
    word_list = ["COLD", "GOLD", "CORD", "SOLD", "CARD", "WARD", "WARM", "TARD"]
    Output:

    4
    Explanation: We can go from COLD to WARM by going through COLD → CORD → CARD → WARD → WARM
     */

    public static final char[] ALPHABETS = new char[26];
    static {
        // ascii representation of english alphabets a - z are numbers 97 - 122
        for (int i = 0; i < 26; i++) {
            ALPHABETS[i] = (char) (i + 'a');
        }
    }
    public static  int wordLadder(String source, String target, String[] wprdList){
        Set<String> words =  new HashSet<String>(List.of(wprdList));

        int result = 0;

        Deque<String > queue = new ArrayDeque<>();
        queue.add(source);
        while(!queue.isEmpty()){
            int size = queue.size();
            result++;
            for(int i =0;i<size;i++){
                String currentWord = queue.pop();
                for(int j = 0;j<currentWord.length();j++){
                    for(char c: ALPHABETS){
                        StringBuilder temp = new StringBuilder();
                        temp.append(currentWord.substring(0,j));
                        temp.append(c);
                        temp.append(currentWord.substring(j+1));
                        if(temp.toString().equals(target))
                            return result;
                        if( words.contains(temp.toString()) ){
                            queue.add(temp.toString());
                            words.remove(temp.toString());
                        }
                    }


                }

               // result++;

            }

        }
        return 0;

    }
    public static void main(String[] args) {
        String[] inputs = {"cold", "fool"};
        String[] inputs1 = {"warm", "sage"};
        String[] inputs2 = {"cold  gold  cord  card  ward  warm  tard  sold","fool pool poll pole pale sale sage"};

        for(int i = 0; i < inputs.length; i++) {
            System.out.println("Word ladder : " + WordLadder.wordLadder(inputs[i], inputs1[i], inputs2[i].split(" ")));
        }
    }
}
