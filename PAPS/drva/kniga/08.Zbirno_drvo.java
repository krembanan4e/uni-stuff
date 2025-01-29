package drva;

//Збирно дрво е бинарно дрво каде вредноста на еден jазел е еднаква
//со збирот од вредностите на jазлите во неговото лево и неговото десно поддрво.
//Се смета дека празно дрво е збирно дрво и збирот е 0.

/*
        26
       /  \
      10   3
     / \    \
    4   6    3

Пример:
Влез:
Бинарно дрво од слика 6-14
Излез:
The given tree is a SumTree

 */

public class KnigaDrva_str289_290 {
    private static int sumOfLeftSubtree(BNode<Integer> node) {
        if (node == null){
            return 0;
        }
        return node.info + sumOfLeftSubtree(node.left) + sumOfLeftSubtree(node.right);
    }

    private static int sumOfRightSubtree(BNode<Integer> node) {
        if (node == null){
            return 0;
        }
        return node.info + sumOfRightSubtree(node.left) + sumOfRightSubtree(node.right);
    }

    public static void main(String[] args) {
        BTree<Integer> tree = new BTree<>();
        tree.makeRoot(26);
        BNode<Integer> node1 = tree.addChild(tree.root, BNode.LEFT, 10);
        BNode<Integer> node2 = tree.addChild(tree.root, BNode.RIGHT, 3);
        BNode<Integer> node3 = tree.addChild(node1, BNode.LEFT, 4);
        BNode<Integer> node4 = tree.addChild(node1, BNode.RIGHT, 6);
        BNode<Integer> node5 = tree.addChild(node2, BNode.RIGHT, 3);

        int leftSum = sumOfLeftSubtree(tree.root.left);
        int rightSum = sumOfRightSubtree(tree.root.right);

        if (leftSum + rightSum == tree.root.info){
            System.out.println("The given tree is a SumTree");
        }
        else{
            System.out.println("The given tree is NOT a SumTree");
        }
    }
}
