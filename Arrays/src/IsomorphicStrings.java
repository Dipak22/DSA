import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {

    public static boolean isIsomorphic(String s, String t) {

        if(s.length() != t.length())
            return false;
        Map<Character,Character> mapST = new HashMap<>();

        Map<Character,Character> mapTS = new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(mapST.get(s.charAt(i)) == null && mapTS.get(t.charAt(i)) == null){
                mapST.put(s.charAt(i),t.charAt(i));
                mapTS.put(t.charAt(i),s.charAt(i));
            }

            else if((mapST.get(s.charAt(i)) ==null || mapST.get(s.charAt(i)) != t.charAt(i))
                || (mapTS.get(t.charAt(i)) ==null || mapTS.get(t.charAt(i)) != s.charAt(i)) )
                return false;


        }

        return true;
    }

    public static void main(String[] args){
        System.out.println(isIsomorphic("badc","baba"));
    }

}
