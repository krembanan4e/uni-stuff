package drva;

/*
Given the root of a binary tree and an integer targetSum,
return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.
A leaf is a node with no children

            5
           /  \
          4    8
         /    / \
        11   13  4
       /  \       \
      7    2       1

target sum: 22
output: true (patekata 5-4-11-2 == 22)
 */

public class LeetCode_PathSum {
    public boolean hasPathSum(BNode<Integer> node, int targetSum) {
        return hasSum(node, 0, targetSum);
    }

    public boolean hasSum(BNode<Integer> node, int currentSum, int targetSum) {
        if (node == null) return false;

        currentSum += node.info;

        if (node.left == null && node.right == null) { //aku dojt do list, vrati dali momentalnata suma e = na sumata sho se barat
            return currentSum == targetSum; // true/false
        }

        return hasSum(node.left, currentSum, targetSum) || hasSum(node.right, currentSum, targetSum);

    }
}
