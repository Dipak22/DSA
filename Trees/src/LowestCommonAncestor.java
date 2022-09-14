import java.util.Arrays;

public class LowestCommonAncestor {
    /*
    Given two nodes of a binary tree, find their lowest common ancestor.
     */

    static Node lca(Node root, Node node1, Node node2){
        if(root == null)
            return null;
        if(root.equals(node1) || root.equals(node2))
            return root;
        Node left = lca(root.left,node1,node2);
        Node right = lca(root.right,node1,node2);

        if(left !=null && right != null)
            return root;
        if(left != null)
            return left;
        if(right != null)
            return right;
        return null;
    }

    public static void main(String[] args) {

        String[] inputs ={"6 4 3 x x 5 x x 8 x x", "6 4 3 x x 5 x x 8 x x", "6 4 3 x x 5 x x 8 x x", "x"};
        int[] inputs1 ={4, 4, 3, 3};
        int[] inputs2 ={8, 6, 5, 2};
        for (int i = 0; i<inputs.length; i++) {
            Node root = Node.buildTree(Arrays.stream(inputs[i].split(" ")).iterator());
            Node node1 = Node.findNode(root, inputs1[i]);
            Node node2 = Node.findNode(root, inputs2[i]);
            Node actual_output = LowestCommonAncestor.lca(root, node1, node2);
            System.out.println("Lowest common ancestor : " + Node.getValue(actual_output));
        }
    }
}
