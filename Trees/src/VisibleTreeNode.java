import java.util.Arrays;
import java.util.Iterator;

public class VisibleTreeNode {
    /*
    In a binary tree, a node is considered “visible” if no node on the root-to-itself path has a greater value.
    The root is always “visible” since there are no other nodes between the root and itself.
    Given a binary tree, count the number of “visible” nodes.
     */

    static int countVisibleNodes(Node root){
        if(root == null)
            return 0;
        return dfs(root, root.val);
    }

    static int dfs(Node root, int maxTillNow){
        if(root == null)
            return 0;
        int total = 0;
        if(root.val>= maxTillNow){
            total++;
        }

        total += dfs(root.left, Math.max(maxTillNow,root.val));
        total +=dfs(root.right,Math.max(maxTillNow,root.val));

        return total;
    }

    public static void main(String[] args) {
        String[] inputs ={"5 4 3 x x 8 x x 6 x x", "-100 x -500 x -50 x x", "9 8 11 x x 20 x x 6 x x"};
        int[] expected_outputs = {3, 2, 3};
        for(int i = 0; i < inputs.length; i++) {
            Node root = Node.buildTree(Arrays.stream(inputs[i].split(" ")).iterator());
            System.out.println("Visible tree node : "+VisibleTreeNode.countVisibleNodes(root));
        }
    }
}
