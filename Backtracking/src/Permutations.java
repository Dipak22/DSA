import java.util.ArrayList;
import java.util.List;

public class Permutations {
    /*
    Given a list of unique letters, find all of its distinct permutations.
     */

    public static List<List<Character>> permute(char[] letters) {
        List<Character> path = new ArrayList<>();
        boolean[] used =new boolean[letters.length];
        List<List<Character>> result = new ArrayList<>();
        permuteDfs(path, used,letters,result);
        return result;
    }

    static void permuteDfs(List<Character> path,boolean[] used,char[] letters,List<List<Character>> result){
        if(path.size() == letters.length){
            result.add(new ArrayList<>(path));
            return;
        }

        for(int i=0;i<letters.length;i++){
            if(used[i])
                continue;
            path.add(letters[i]);
            used[i] = true;
            permuteDfs(path,used,letters,result);
            path.remove(path.size()-1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {

        String[] inputs = {"ab","abc"};
        for (int i = 0; i<inputs.length; i++) {
            System.out.println("Permutations : " + Permutations.permute(inputs[i].toCharArray()));
        }
    }
}
