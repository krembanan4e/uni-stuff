package drva;

//print elements at given level (ako root e level 1)

/*
        2
      /   \
     7     5
    / \     \
   2   6     9
      / \    /
     5  11  4

 */

import java.util.Scanner;

public class YT08 {
    public static void printNodesAtLevel(BNode<Integer> node, int level){
        if (node == null){
            return;
        }
        if (level == 1){
            System.out.print(node.info + " ");
        }

        printNodesAtLevel(node.left, level-1);
        printNodesAtLevel(node.right, level-1);
    }

    public static void main(String[] args) {
        BTree<Integer> tree = new BTree<>();
        tree.makeRoot(2);
        BNode<Integer> node1 = tree.addChild(tree.root, BNode.LEFT, 7);
        BNode<Integer> node2 = tree.addChild(tree.root, BNode.RIGHT, 5);
        BNode<Integer> node3 = tree.addChild(node1, BNode.LEFT, 2);
        BNode<Integer> node4 = tree.addChild(node1, BNode.RIGHT, 6);
        BNode<Integer> node5 = tree.addChild(node4, BNode.LEFT, 5);
        BNode<Integer> node6 = tree.addChild(node4, BNode.RIGHT, 11);
        BNode<Integer> node7 = tree.addChild(node2, BNode.RIGHT, 9);
        BNode<Integer> node8 = tree.addChild(node7, BNode.LEFT, 4);

        Scanner sc = new Scanner(System.in);
        int level = sc.nextInt();

        printNodesAtLevel(tree.root, level);
    }
}
