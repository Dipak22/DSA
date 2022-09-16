import java.util.*;
import java.util.stream.Collectors;

public class NoOfIslands {

    public static void main(String[] args) {

        String[] inputs = {
                "6", "2", "3"
        };
        String[][] inputsMatrix = {
                {
                        "1 1 1 0 0 0", "1 1 1 1 0 0", "1 1 1 0 0 0", "0 1 0 0 0 0", "0 0 0 0 1 0", "0 0 0 0 0 0"
                }, {
                "1 0 1", "0 1 0"
        }, {
                "0 0 0", "0 0 0", "0 0 0"
        }
        };
        for (int i = 0; i<inputs.length; i++) {
            int rows = Integer.parseInt(inputs[i]);
            List<List<Integer>> grid = new ArrayList<>();
            for (int j = 0; j < rows; j++) {
                grid.add(
                        Arrays.stream(inputsMatrix[i][j].split(" ")).map(Integer::parseInt).collect(Collectors.toList())
                );
            }
            int actual_output = NoOfIslands.countNumberOfIslands(grid);
            System.out.println("Count number of islands : " + actual_output);
        }
    }

        public static int countNumberOfIslands(List<List<Integer>> grid) {
            int nRows = grid.size();
            int nCols = grid.get(0).size();
            int islands=0;
            for(int i =0;i<nRows;i++){
                for(int j=0;j<nCols;j++){
                    if(grid.get(i).get(j)==1){
                        bfs(grid, new Coordinate(i,j),nRows,nCols);
                        islands++;
                    }
                }
            }
            return islands;
        }

        public static void bfs(List<List<Integer>> grid , Coordinate start,int nRows,int nCols){
            Deque<Coordinate> queue = new ArrayDeque<>();
            queue.add(start);
            while(!queue.isEmpty()){
                int size =queue.size();
                for(int i=0;i<size;i++){
                    Coordinate current = queue.pop();
                    for(Coordinate neighbour : getNeighbours(grid, current,nRows,nCols)){
                        queue.add(neighbour);
                        grid.get(neighbour.r).set(neighbour.c,0);
                    }
                }
            }
        }

        public static List<Coordinate> getNeighbours(List<List<Integer>> grid , Coordinate start,int nRows,int nCols){
            List<Coordinate> result = new ArrayList<>();
            int[] deltaRow = {-1,0,1,0};
            int[] deltaCol = {0,1,0,-1};
            for(int i =0;i<deltaCol.length;i++){
                int row = start.r+ deltaRow[i];
                int col = start.c+deltaCol[i];
                if(row>=0 && row<nRows && col>=0 && col<nCols && grid.get(row).get(col)==1){
                    result.add(new Coordinate(row,col));

                }
            }
            return result;
        }
}

