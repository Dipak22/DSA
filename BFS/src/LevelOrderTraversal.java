import java.util.*;
import java.util.stream.Collectors;

public class LevelOrderTraversal {

    /*
    Given a binary tree, return its level order traversal.
    The input is the root node of the tree.
    The output should be a list of lists containing tree nodes at each level.
     */

    static List<List<Node>> levelOrderTraversal(Node root){
        Queue<Node> queue = new LinkedList<>();
        List<List<Node>> result = new ArrayList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Node> levelNodes = new ArrayList<>();
            for(int i=0;i<size;i++){
                Node temp = queue.poll();
                levelNodes.add(temp);
                if(temp.left != null)
                    queue.add(temp.left);
                if(temp.right != null)
                    queue.add(temp.right);
            }
            result.add(levelNodes);
        }
        return  result;
    }

    public static void main(String[] args) {

        String[] inputs = {"1 2 4 x 7 x x 5 x x 3 x 6 x x","0 x x"};
        for (int i = 0; i<inputs.length; i++) {
            Node root = Node.buildTree(Arrays.stream(inputs[i].split(" ")).iterator());
            List<List<Node>> actual_output = LevelOrderTraversal.levelOrderTraversal(root);
            String[] result = new String[inputs.length];
            String actualData = "";
            for (int j = 0; j< actual_output.size() ;j++) {
                List<Node> level = actual_output.get(j);
                actualData  += "["+level.stream().map(node -> Integer.toString(node.val)).collect(Collectors.joining(","))+"]";
            }
            System.out.println("Binary tree level order traversal : [" +actualData+"]");
        }
    }


}

class Node {
    int val;
    Node left, right;

    public Node(int val) {
        this.val = val;
    }

    public static Node buildTree(Iterator<String> iter) {
        String nxt = iter.next();
        if (nxt.equals("x")) return null;
        Node node = new Node(Integer.parseInt(nxt));
        node.left = buildTree(iter);
        node.right = buildTree(iter);
        return node;
    }
}
