import java.util.Arrays;
import java.util.Iterator;

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

    public static void printTree(Node root, StringBuilder str) {
        if (root == null) {
            str.append("x ");
        } else {
            str.append(root.val+" ");
            printTree(root.left, str);
            printTree(root.right, str);
        }
    }

    public static Node findNode(Node root, int target) {
        if (root == null) return null;
        if (root.val == target) return root;
        Node leftSearch = findNode(root.left, target);
        if (leftSearch != null) {
            return leftSearch;
        }
        return findNode(root.right, target);
    }

    public static boolean compareNode(Node root, String target){
        if (root == null) return "null" == target;
        if (Integer.toString(root.val) == target) return true;
        return false;
    }
    public static String getValue(Node root){
        if (root == null) return "null";
        return String.valueOf(root.val);
    }
}

public class MaxDepth {

    /*
    The max depth of a binary tree is the longest root-to-leaf path. Given a binary tree, find its max depth.
     */

    static int getMaxTreeDepth(Node root){
        if(root == null)
            return 0;
        return 1 + Math.max(getMaxTreeDepth(root.left), getMaxTreeDepth(root.right));
    }

    public static void main(String[] args) {

        String[] inputs ={"5 4 3 x x 8 x x 6 x x", "1 x x", "x", "6 x 9 x 11 x 7 x x"};
        int[] expected_outputs = {3, 1, 0, 4};
        for (int i = 0; i<inputs.length; i++) {
            Node root = Node.buildTree(Arrays.stream(inputs[i].split(" ")).iterator());
            System.out.println("Get map tree depth " + MaxDepth.getMaxTreeDepth(root));
        }
    }
}
