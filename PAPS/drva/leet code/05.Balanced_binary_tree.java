package drva;

public class LeetCode_BalancedBinaryTree {

    private int getMaxSubtreeHeight(BNode<Integer> node) {
        if (node == null) return 0;

        return 1 + Math.max(getMaxSubtreeHeight(node.left), getMaxSubtreeHeight(node.right));
    }

    public boolean isBalanced(BNode<Integer> node){
        if (node == null){
            return true;
        }
        int left = getMaxSubtreeHeight(node.left);
        int right = getMaxSubtreeHeight(node.right);

        return Math.abs(left - right) <= 1 && isBalanced(node.left) && isBalanced(node.right);
    }
}
