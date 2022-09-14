public class SquareRoot {
    /*
    Problem statement#
    Given an integer, find its square root without using the built-in square root function.
    Only return the integer part (truncate the decimals).
     */

    static int square_root(int num){
        if(num==0)
            return 0;
        int left = 1;
        int right = num;
        int result = -1;
        while(left <= right){
            int mid = left +(right-left)/2;
            //mid*mid<= num , it will result in integer overflow, so change it to mid <=num/mid
            if(mid<= num/mid){
                result= mid;
                left = mid+1;
            }
            else
                right = mid -1;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("Square root :" + SquareRoot.square_root(4));
        System.out.println("Square root :" + SquareRoot.square_root(8));
        System.out.println("Square root :" + SquareRoot.square_root(100000));
    }
}
