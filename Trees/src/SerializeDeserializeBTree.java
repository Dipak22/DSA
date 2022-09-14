import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class SerializeDeserializeBTree {

    static String serialize(Node root){
        StringBuilder str = new StringBuilder();
        serializeDfs(root,str);
        return str.toString();
    }

    static void serializeDfs(Node root, StringBuilder str){
        if(root == null){
            str.append("x");
            str.append(" ");
            return;
        }
        str.append(root.val);
        str.append(" ");
        serializeDfs(root.left, str);
        serializeDfs(root.right,str);
    }

    static Node deserialize(String str){

         return deserializeDfs(Arrays.stream(str.split(" ")).iterator());

    }

    static Node deserializeDfs(Iterator<String> nodes){
        String val = nodes.next();
        if(val.equals("x")){
            return null;

        }
        Node cur = new Node(Integer.parseInt(val));
        cur.left = deserializeDfs(nodes);
        cur.right = deserializeDfs(nodes);
        return cur;

    }

    public static void main(String[] args) {
        String[] inputs ={"6 4 3 x x 5 x x 8 x x", "1 2 x x 3 x x", "10 86 x x 100 x x", "x"};
        for (int i = 0; i<inputs.length; i++) {
            Node root = Node.buildTree(Arrays.stream(inputs[i].split(" ")).iterator());
            Node actual_output = SerializeDeserializeBTree.deserialize(SerializeDeserializeBTree.serialize(root));
            List<String> list = new ArrayList<String>();
            StringBuilder sb = new StringBuilder();
            Node.printTree(actual_output, sb);
            sb.deleteCharAt(sb.length()-1);
            System.out.println("Serializing and deserializing : " + sb.toString());
        }
    }
}
