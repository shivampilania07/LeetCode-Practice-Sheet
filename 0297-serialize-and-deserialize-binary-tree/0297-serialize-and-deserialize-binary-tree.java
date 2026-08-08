/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.*;

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        if (root == null) {
            return "null,";
        }

        String left = serialize(root.left);
        String right = serialize(root.right);

        return root.val + "," + left + right;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        Queue<String> nodes = new LinkedList<>();

        nodes.addAll(Arrays.asList(data.split(",")));

        return helper(nodes);
    }

    public TreeNode helper(Queue<String> nodes) {

        String valueOfNode = nodes.poll();

        if (valueOfNode.equals("null")) {
            return null;
        }

        TreeNode newValue = new TreeNode(Integer.parseInt(valueOfNode));

        newValue.left = helper(nodes);
        newValue.right = helper(nodes);

        return newValue;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));