import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CountDistinctInWindow {
    /*
    Given an array of integers and a number K. Find the count of distinct elements in every window of size K in the array.
     */

    static ArrayList<Integer> countDistinct(int A[], int n, int k)
    {
        // code here
        Map<Integer,Integer> map = new HashMap<>();

        ArrayList<Integer> result = new ArrayList<>();

        for(int i=0;i<n;i++){
            map.put(A[i],map.getOrDefault(A[i],0)+1);
            if(i>=k){

                map.put(A[i-k],map.get(A[i-k])-1);
                if(map.get(A[i-k])==0)
                    map.remove(A[i-k]);
            }
            if(i>=k-1)
                result.add(map.size());

        }
        return result;
    }

    public static void main(String[] args){

        int[] A = {1,2,1,3,4,2,3};
        int k=4;

        System.out.println(countDistinct(A,A.length,k));
    }
}
