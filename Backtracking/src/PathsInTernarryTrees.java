import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

class Node {
    int val;
    Node[] children;

    public Node(int val, Node[] children) {
        this.val = val;
        this.children = children;
    }

    public static Node buildTree(Iterator<String> nodes) {
        String nxt = nodes.next();
        if (nxt.equals("x")) return null;
        Node node = new Node(Integer.parseInt(nxt), new Node[3]);
        for (int i = 0; i < 3; i++) {
            node.children[i] = buildTree(nodes);
        }
        return node;
    }
}
public class PathsInTernarryTrees {
    /*
    Given a ternary tree (each node of the tree has at most three children), find all root-to-leaf paths.
     */

    static String[] ternaryTreePaths(Node root){
        if(root==null)
            return null;
        ArrayList<String> result = new ArrayList<String>();
        ternaryTreePathsDfs(root, new ArrayList<String>(),result);
        return result.toArray(new String[result.size()]);
    }

    static void ternaryTreePathsDfs(Node root, ArrayList<String> path, ArrayList<String> result){
        if(root.children[0]==null && root.children[1] == null && root.children[2]==null){
            path.add(Integer.toString(root.val));

            result.add(String.join("->",path)) ;
            return;
        }

        for(Node child : root.children){
            if(child !=null){
                ArrayList<String> copyPath = new ArrayList<>(path);
                copyPath.add(Integer.toString(root.val));
                ternaryTreePathsDfs(child,copyPath,result);
            }

        }
    }

    // Driver code
    public static void main(String[] args) {

        String[] inputs = {"1 2 5 x x x x x 3 x x x 4 x x x", "1 2 3 x x x 4 x x x 7 x x x 5 x x x 6 x x x"};
        for (int i = 0; i<inputs.length; i++) {
            Node root = Node.buildTree(Arrays.stream(inputs[i].split(" ")).iterator());
            System.out.println("Ternary tree paths : " + Arrays.toString(PathsInTernarryTrees.ternaryTreePaths(root)));
        }

    }

}
