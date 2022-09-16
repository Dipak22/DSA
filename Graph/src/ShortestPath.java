import java.util.*;
import java.util.stream.Collectors;

public class ShortestPath {

    public static int getLengthOfShortestPath(Map<Node, List<Node>> graph, Node A, Node B) {
        return bfs(graph,A,B);
    }

    public static int bfs(Map<Node, List<Node>> graph, Node A, Node B){
        Deque<Node> queue= new ArrayDeque<>();
        Set<Node> visited = new HashSet<>();
        queue.add(A);
        int pathLength =0;
        while(!queue.isEmpty()){
            int size = queue.size();

            for(int i =0;i<size;i++){
                Node temp = queue.pop();
                if(temp.equals(B)){
                    return pathLength;
                }
                for(Node neighbour : graph.get(temp)){
                    if(visited.contains(neighbour))
                        continue;
                    queue.add(neighbour);
                    visited.add(neighbour);
                }
            }
            pathLength++;
        }
        return pathLength;
    }

    public static void main(String[] args) {
        String[] inputs =  {"4"};
        String[][] inputs1 = {{"1", "2"},{"0", "2", "3"},{"0", "1"},{"1"}};
        String[] inputs2 = {"0"};
        String[] inputs3 = {"3"};

        for(int i = 0; i < inputs.length; i++) {

            int n = Integer.parseInt(inputs[i]);
            Node[] nodes = new Node[n];
            for (int j = 0; j < n; j++) {
                nodes[j] = new Node(j);
            }
            Map<Node, List<Node>> graph = new HashMap<>(n);
            for (int j = 0; j < n; j++) {
                List<Node> neighbors = Arrays.stream(inputs1[j]).map(node -> nodes[Integer.parseInt(node)]).collect(Collectors.toList());
                graph.put(nodes[j], neighbors);
            }
            Node A = nodes[Integer.parseInt(inputs2[i])];
            Node B = nodes[Integer.parseInt(inputs3[i])];

            System.out.println("Length of shortest path : " + String.valueOf(ShortestPath.getLengthOfShortestPath(graph, A, B)));
        }
    }
}

class Node {
    int val;

    public Node(int val) {
        this.val = val;
    }
}
