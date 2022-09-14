import java.util.Arrays;

public class ValidBST {

    /*
    Given a binary tree, determine whether it is a binary search tree.
     */

    static boolean isValid(Node root){
        return dfs(root, Integer.MIN_VALUE,Integer.MAX_VALUE);
    }

    static boolean dfs(Node root, int min, int max){
        if(root == null)
            return true;
        if(!(min<= root.val && root.val<=max))
            return false;
        return dfs(root.left , min, root.val) && dfs(root.right, root.val, max);
    }

    public static void main(String[] args) {

        String[] inputs ={"6 4 3 x x 5 x x 8 x x", "6 4 3 x x 8 x x 8 x x", "1 2 x x 3 x x", "x", "7 7 7 x x x 7 x 7 x x"};        int[] expected_outputs = {3, 1, 0, 4};
        for (int i = 0; i<inputs.length; i++) {
            Node root = Node.buildTree(Arrays.stream(inputs[i].split(" ")).iterator());
            System.out.println("Get map tree depth : " + ValidBST.isValid(root));
        }
    }
}
