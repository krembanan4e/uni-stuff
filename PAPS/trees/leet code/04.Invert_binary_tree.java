package drva;

public class LeetCode_InvertBinaryTree {
    public BNode<Integer> invertTree(BNode<Integer> node) {
        if (node == null){
            return null;
        }

        BNode<Integer> left = invertTree(node.left);
        BNode<Integer> right = invertTree(node.right);

        //swap
        node.left = right;
        node.right = left;

        return node;
    }
}
