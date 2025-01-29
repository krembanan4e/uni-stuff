package drva;

// збирот на елементите чии jазли имаат само леви деца. (ovde se zbiret samo 7 i 19)

/*
        1
       / \
      7   9
     /     \
    2       19
            /
           15

Излез:
The sum is 26

 */

public class KnigaDrva_str289 {
    private static int sumOfLeftChildren(BNode<Integer> node, int sum) {
        if (node == null){
            return 0;
        }
        if (node.left != null && node.right == null){
            return node.info;
        }

        int left = sumOfLeftChildren(node.left, sum);
        int right = sumOfLeftChildren(node.right, sum);
        if (left != 0){
            sum += left;
        }
        sum += right;

        return sum;
    }

    public static void main(String[] args) {
        BTree<Integer> tree = new BTree<>();
        tree.makeRoot(1);
        BNode<Integer> node1 = tree.addChild(tree.root, BNode.LEFT, 7);
        BNode<Integer> node2 = tree.addChild(tree.root, BNode.RIGHT, 9);
        BNode<Integer> node3 = tree.addChild(node1, BNode.LEFT, 2);
        BNode<Integer> node4 = tree.addChild(node2, BNode.RIGHT, 19);
        BNode<Integer> node5 = tree.addChild(node4, BNode.LEFT, 15);

        System.out.println(sumOfLeftChildren(tree.root, 0));
    }
}
