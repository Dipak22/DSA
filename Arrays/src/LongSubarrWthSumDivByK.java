import java.util.HashMap;
import java.util.Map;

public class LongSubarrWthSumDivByK {

    static int longSubarrWthSumDivByK(int a[], int n, int k)
    {
        // Complete the function
        int sum =0;
        int maxLen =0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            sum+=a[i];
            int rem = sum%k;
            if(rem<0)
                rem +=k;
            if(rem ==0){
                maxLen = Math.max(maxLen,i+1);
            }
            if(map.get(rem) !=null){
                maxLen = Math.max(maxLen,i-map.get(rem));
            }else{
                map.put(rem,i);
            }
        }
        return maxLen;

    }

    public static void main(String[] args){
        int[] arr = {-2, 2, -5, 12, -11, -1, 7};
        int k = 3;
        int result= longSubarrWthSumDivByK(arr,arr.length,k);
        System.out.println(result);
    }
}
