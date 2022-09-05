import java.util.ArrayList;
import java.util.Arrays;

public class MergeIntervals {

    /*
    Consider the input array below. Intervals [1, 5], [3, 7], [4, 6], [6, 8] are overlapping,
    so they should be merged to one big interval [1, 8].
    Similarly, intervals [10, 12] and [12, 15] are also overlapping and should be merged to [10, 15].
     */

    static class Interval{
        int start;
        int end;
        Interval(int start,int end){
            this.start = start;
            this.end =end;
        }
    }

    static ArrayList<Interval> mergeIntervals(ArrayList<Interval> v){
        ArrayList<Interval> result = new ArrayList<>();
        int start = v.get(0).start;
        int end =v.get(0).end;
        for(int i=1;i<v.size();i++){
            Interval temp = v.get(i);
            if(temp.start <=end){
                end = Math.max(end,temp.end);
            }
            else{
                result.add(new Interval(start,end));
                start = temp.start;
                end = temp.end;

            }

        }
        result.add(new Interval(start,end));
        return result;
    }

    static void printIntervalList(ArrayList<Interval> result){
        String result_str = "";
        for (int j = 0; j < result.size(); j++) {
            result_str += "[" + result.get(j).start + ", " + result.get(j).end + "] ";
        }
        System.out.println("   Initial intervals:\t" + result_str);
    }

    public static void main(String[] args) {
        Interval[] v1 = {new Interval(1, 5), new Interval(3, 7), new Interval(4, 6)};
        Interval[] v2 = {new Interval(1, 5), new Interval(4, 6), new Interval(6, 8), new Interval(11, 15)};
        Interval[] v3 = {new Interval(3, 7), new Interval(6, 8), new Interval(10, 12), new Interval(11, 15)};
        Interval[] v4 = {new Interval(1, 5)};
        Interval[][] vList = {v1, v2, v3, v4};

        for (int i = 0; i < vList.length; i++) {
            ArrayList<Interval> v = new ArrayList<Interval>(Arrays.asList(vList[i]));
            System.out.print(i + 1);
            printIntervalList(v);
            ArrayList<Interval> result = mergeIntervals(v);
            String result_str = "";
            for (int j = 0; j < result.size(); j++) {
                result_str += "[" + result.get(j).start + ", " + result.get(j).end + "] ";
            }
            System.out.println("   Merged intervals:\t" + result_str);
            System.out.println(
                    "----------------------------------------------------------------------------------------------------\n");
        }
    }
}
