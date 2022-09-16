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

    public static List<Node> getRightSideView(Node root) {
        Deque<Node> queue = new ArrayDeque<>();
        queue.add(root);
        List<Node> result = new ArrayList<>();
        while(!queue.isEmpty()){
            result.add(queue.peekFirst());
            int size = queue.size();
            for(int i=0;i<size;i++){
                Node temp = queue.poll();
                if(temp.right != null){
                    queue.add(temp.right);
                }
                if(temp.left != null)
                    queue.add(temp.left);
            }
        }
        return result;
    }

    public static int getBinaryTreeMinDepth(Node root){
        Deque<Node> queue = new ArrayDeque<>();
        queue.add(root);
        int depth =-1;
        while(!queue.isEmpty()){
            depth++;
            int size = queue.size();
            for(int i=0;i<size;i++){
                Node temp = queue.poll();
                if(temp.right == null && temp.left == null)
                    return depth;
                if(temp.right != null){
                    queue.add(temp.right);
                }
                if(temp.left != null)
                    queue.add(temp.left);
            }
        }
        return depth;
    }

    public static List<Node> getDistanceKNodes(Node root, Node target, int k) {
        int targetLevel = getTargetLevel(root,target);

        return getBfsDistanceKNodes(root,targetLevel,k);

    }

    public static List<Node> getBfsDistanceKNodes(Node root,int targetLevel,int k){
        Deque<Node> queue = new ArrayDeque<>();
        queue.add(root);
        List<Node> result = new ArrayList<>();
        int depth =-1;
        while(!queue.isEmpty()){
            int size = queue.size();
            depth++;
            for(int i=0;i<size;i++){
                Node temp = queue.poll();
                if(Math.abs(depth-targetLevel)==k){
                    result.add(temp);
                }
                if(temp.left != null)
                    queue.add(temp.left);
                if(temp.right != null){
                    queue.add(temp.right);
                }

            }
        }
        return result;
    }

    public static int getTargetLevel(Node root, Node target){
        Deque<Node> queue = new ArrayDeque<>();
        queue.add(root);
        int depth =-1;
        while(!queue.isEmpty()){
            depth++;
            int size = queue.size();
            for(int i=0;i<size;i++){
                Node temp = queue.pop();
                if(temp.equals(target))
                    return depth;
                if(temp.left != null)
                    queue.add(temp.left);
                if(temp.right != null){
                    queue.add(temp.right);
                }

            }
        }
        return depth;

    }
    public static void main(String[] args) {

        // for level order traversal.
       /* String[] inputs = {"1 2 4 x 7 x x 5 x x 3 x 6 x x","0 x x"};
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
        }*/

        // for finding the right most node
        /*String[] inputs ={"1 2 4 x 7 x x 5 x x 3 x 6 x x","0 x x"};
        for (int i = 0; i<inputs.length; i++) {
            Node root = Node.buildTree(Arrays.stream(inputs[i].split(" ")).iterator());
            System.out.println("Binary tree right side : " + LevelOrderTraversal.getRightSideView(root)
                    .stream().map(node -> Integer.toString(node.val))
                    .collect(Collectors.joining(" ")));
        }*/


        // for finding the min depth.
        /*String[] inputs ={"1 2 4 x 7 x x 5 x x 3 x 6 x x","0 x x"};
        for (int i = 0; i<inputs.length; i++) {
            Node root = Node.buildTree(Arrays.stream(inputs[i].split(" ")).iterator());
            System.out.println("Binary tree min depth : " + LevelOrderTraversal.getBinaryTreeMinDepth(root));
        }*/

        String[] inputs ={"1 2 4 x 7 x x 5 x 8 x x 3 x 6 x x","0 1 x x 2 x x"};
        String[] inputs1 ={"6","2"};
        String[] inputs2 ={"1","0"};
        for (int i = 0; i<inputs.length; i++) {
            Node root = Node.buildTree(Arrays.stream( inputs[i].split(" ")).iterator());
            Node target = Node.findNode(root, Integer.parseInt( inputs1[i]));
            int k = Integer.parseInt(inputs2[i]);
            String actual_output = LevelOrderTraversal.getDistanceKNodes(root, target, k)
                    .stream().map(node -> Integer.toString(node.val))
                    .collect(Collectors.joining(" "));
            System.out.println("Binary tree distance K from target node : " + actual_output);
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

    public static Node findNode(Node root, int target) {
        if (root == null || root.val == target) return root;
        Node leftSearch = findNode(root.left, target);
        if (leftSearch != null) return leftSearch;
        return findNode(root.right, target);
    }
}
