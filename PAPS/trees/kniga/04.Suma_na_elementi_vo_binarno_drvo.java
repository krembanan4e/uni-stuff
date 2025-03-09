package drva;

//suma na elementi vo binarno drvo

/*
        1
       / \
      7   9
     / \   \
    2   6   19
       / \  /
      5  11 15

 */

import java.util.Scanner;

public class KnigaDrva_str281 {
    public static int sum(BNode<Integer> node){
        if (node == null){
            return 0;
        }

        return node.info + sum(node.left) + sum(node.right);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        BTree<Integer> tree = new BTree<>();
        tree.makeRoot(1);
        BNode<Integer> node1 = tree.addChild(tree.root, BNode.LEFT, 7);
        BNode<Integer> node2 = tree.addChild(tree.root, BNode.RIGHT, 9);
        BNode<Integer> node3 = tree.addChild(node1, BNode.LEFT, 2);
        BNode<Integer> node4 = tree.addChild(node1, BNode.RIGHT, 6);
        BNode<Integer> node5 = tree.addChild(node2, BNode.RIGHT, 19);
        BNode<Integer> node6 = tree.addChild(node4, BNode.LEFT, 5);
        BNode<Integer> node7 = tree.addChild(node4, BNode.RIGHT, 11);
        BNode<Integer> node8 = tree.addChild(node5, BNode.LEFT, 15);

        int suma = sum(tree.root);
        System.out.println("The sum of all elements in this tree is: "+suma);
    }
}
