import java.util.Arrays;

public class StockPrices {

    /*
    We’re given an array of daily stock prices (integers for simplicity).
    Return the buying and selling prices for making the maximum profit.

    The values in the array represent the cost of stock each day.
    As we can buy and sell the stock only once, we need to find the best buy and sell prices that
     maximize profit (or minimized loss) over a given span of time.

    We need to maximize the profit from a single buy and sell. If we can’t make any profit, we’ll try to minimize the loss.
     */

    static class Tuple<X, Y> {
        public X x;
        public Y y;

        public Tuple(X x, Y y) {
            this.x = x;
            this.y = y;
        }
    }
    static Tuple<Integer,Integer> findBuySellStockPrices(int[] arr){

        if(arr==null || arr.length<2)
            return null;
        int currentBuy = arr[0];
        int global_sell = arr[1];

        int global_profit = global_sell-currentBuy;
        for(int i=1;i<arr.length;i++){
            int current_profit = arr[i]-currentBuy;
            if(current_profit>global_profit){
                global_profit = current_profit;
                global_sell = arr[i];
            }
            if(arr[i]<currentBuy)
                currentBuy = arr[i];
        }
        return new Tuple<>(global_sell-global_profit,global_sell);
    }
    public static void main(String[] args) {

        int[][] stockNums =
                {{1, 2, 3, 4, 3, 2, 1, 2, 5}, {8, 6, 5, 4, 3, 2, 1}, {12, 30, 40, 90, 110}, {2}};

        for (int i = 0; i < stockNums.length; i++) {
            Tuple<Integer, Integer> result = findBuySellStockPrices(stockNums[i]);
            System.out.println((i + 1) + ". Day stocks: " + Arrays.toString(stockNums[i]));
            if (result != null) {
                System.out.println("   Buy Price: " + result.x + ", Sell Price: " + result.y);
            } else {
                System.out.println("   Buy Price: null, Sell Price: null");
            }
            System.out.println(
                    "-------------------------------------------------------------------------------------------------------\n");
        }
    }
}
