package drva;


/*
dijametar na drvo -> max leva visina + max desna visina (nemorat da e na root-ot mojt i od nekoj vnatresen jazol da se gleat) 
 */

public class LeetCode_DiameterOfBinaryTree {

    private int largestDiameter = 0;

    public int height (BNode<Integer> node) {
        if (node == null){
            return 0;
        }

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        int diameter = leftHeight + rightHeight;

        largestDiameter = Math.max(largestDiameter, diameter);

        return 1 + Math.max(leftHeight, rightHeight);
    }

    public int diameterOfBinaryTree(BNode<Integer> node) {
        height(node);
        return largestDiameter;
    }
}
