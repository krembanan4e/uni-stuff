package drva;

//suma na poddrva na daden element vo binarno drvo
//suma na elementite vo levoto poddrvo na daden jazol koi se POMALI od nego
//suma na elementite vo desnoto poddrvo na daden jazol koi se POGOLEMI od nego

/*
        1
       / \
      7   9
     / \   \
    2   6   19
       / \  /
      5  11 15

Влез:
Бинарно дрво од слика 6-11.
Вредност на jазел: 7
Излез:
The sum of the left subtree is 2
The sum of the right subtree is 11
 */

import java.util.Scanner;

public class KnigaDrva_str282 {
    public static BNode<Integer> find (int element, BNode<Integer> node){
        if (node == null){
            return null;
        }
        if (node.info.equals(element)){
            return node;
        }

        BNode<Integer> foundLeft = find(element, node.left);
        BNode<Integer> foundRight = find(element, node.right);
        if (foundLeft != null){
            return foundLeft;
        }
        return foundRight;
    }

    private static int sumLeftSubtree(BNode<Integer> node, int vrednost) {
        if (node == null){
            return 0;
        }

        int temp = sumLeftSubtree(node.left, vrednost) + sumLeftSubtree(node.right, vrednost);
        if (node.info < vrednost){
            return temp + node.info;
        }
        else {
            return temp;
        }
    }

    private static int sumRightSubtree(BNode<Integer> node, int vrednost) {
        if (node == null){
            return 0;
        }

        int temp = sumRightSubtree(node.left, vrednost) + sumRightSubtree(node.right, vrednost);
        if (node.info > vrednost){
            return temp + node.info;
        }
        else {
            return temp;
        }
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

        int vrednost = sc.nextInt();
        BNode<Integer> najde = find(vrednost, tree.root);

        if (najde != null){
            int sumaNaLevoPoddrvo = sumLeftSubtree(najde.left, vrednost);
            int sumaNaDesnoPoddrvo = sumRightSubtree(najde.right, vrednost);

            System.out.println("The sum of left subtree is: " + sumaNaLevoPoddrvo);
            System.out.println("The sum of right subtree is: " + sumaNaDesnoPoddrvo);
        }
        else {
            System.out.println("The value "+vrednost+" doesn't exist in this tree");
        }
    }
}
