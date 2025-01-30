package drva;

/*
Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
 */

public class LeetCode_SameTree {

    public boolean isSameTree(BNode<Integer> p, BNode<Integer> q) {
        return isSameTree(p, q);
    }

    public boolean isSame(BNode<Integer> p, BNode<Integer> q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.info != q.info) return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
