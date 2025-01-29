package drva;

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

public class KnigaDrva_str276 {
    private static BNode<Integer> find(int element, BNode<Integer> node) {
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

    public static void main(String[] args) {
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

        Scanner sc = new Scanner(System.in);
        int vrednost = sc.nextInt();

        BNode<Integer> najde = find(vrednost, tree.root);
        
        if (najde != null){
            System.out.println("Node with value "+vrednost+" exists in the given binary tree");
        }
        else {
            System.out.println("Node with value "+vrednost+" does not exist in the given binary tree");
        }
    }
}
