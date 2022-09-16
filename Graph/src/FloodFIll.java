import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

class Coordinate {
    int r;
    int c;

    public Coordinate(int r, int c) {
        this.r = r;
        this.c = c;
    }
}
public class FloodFIll {

    /*

    Implement the flood fill algorithm by taking an image:
    a 2d-matrix, a start position: (row, col) and then a replacement_color:
    an integer representing a specific color as input to update that image.
     */

    public static void floodFill(List<List<Integer>> image, Coordinate start, int replacementColor) {
        int numRow= image.size();
        int numCol = image.get(0).size();
        bfs(image,start,replacementColor,numRow,numCol);
    }

    private static List<Coordinate> getNeighbour(List<List<Integer>> image,Coordinate start , int numRow,int numCol,int originalColor){
        List<Coordinate> result = new ArrayList<>();
        int[] deltaRow = {-1,0,1,0};
        int[] deltaCol = {0,1,0,-1};

        for(int i =0;i<deltaCol.length;i++){
            int neighbourRow = start.r+deltaRow[i];
            int neighbourCol = start.c+deltaCol[i];
            if(neighbourRow>=0 && neighbourRow<numRow && neighbourCol>=0 && neighbourCol<numCol
             && image.get(neighbourRow).get(neighbourCol) == originalColor){
                result.add(new Coordinate(neighbourRow,neighbourCol));
            }
        }
        return result;
    }

    public  static  void bfs(List<List<Integer>> image, Coordinate start, int replacementColor, int numRow, int numCOl){
        Deque<Coordinate> queue = new ArrayDeque<>();
        queue.add(start);
        Set<Coordinate> visited = new HashSet<>();
        visited.add(start);
        int originalColor = image.get(start.r).get(start.c);
        image.get(start.r).set(start.c,replacementColor);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i =0;i<size;i++){
                Coordinate currentCoordinate = queue.pop();
                for(Coordinate neighbour : getNeighbour(image, currentCoordinate,numRow,numCOl,originalColor)){
                    if(!visited.contains(neighbour)){
                        queue.add(neighbour);
                        visited.add(neighbour);
                        image.get(neighbour.r).set(neighbour.c,replacementColor);
                    }
                }

            }
        }
    }

    public static void main(String[] args) throws IOException {
        String[] inputs = {"2 2","1 1"};
        String[] inputs1 = {"9", "9"};
        String[] inputs2 = {"5", "4"};
        String[][] inputs3 = {{"0 1 3 4 1","3 8 8 3 3","6 7 8 8 3","12 2 8 9 1","12 3 1 3 2"},
                {"0 1 6 4","2 3 3 5","3 3 3 3","6 4 3 4"}};

        for(int i = 0; i < inputs.length; i++) {
            String[] coord = inputs[i].split(" ");
            Coordinate start = new Coordinate(Integer.parseInt(coord[0]), Integer.parseInt(coord[1]));
            int color = Integer.parseInt(inputs1[i]);
            int rows = Integer.parseInt(inputs2[i]);
            List<List<Integer>> image = new ArrayList<>();
            for (int j = 0; j < rows; j++) {
                image.add(
                        Arrays.stream(inputs3[i][j].split(" ")).map(Integer::parseInt).collect(Collectors.toList())
                );
            }


            FloodFIll.floodFill(image, start, color);

            List<String> actual_output = image.stream().map(row -> row.stream().map(pixel -> Integer.toString(pixel)).collect(Collectors.joining(" "))).collect(Collectors.toList());

            System.out.println("output : " + Arrays.toString(actual_output.toArray()));
        }
    }
}
