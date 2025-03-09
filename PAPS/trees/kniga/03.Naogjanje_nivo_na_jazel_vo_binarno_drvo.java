package drva;

 //naogjanje nivo na jazel, ako korenot se naogja na nivo 1 (dlabocina)

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

public class KnigaDrva_str279 {
    private static int getDepth(int element, BNode<Integer> node, int depth) {
        if (node == null){
            return 0;
        }
        if (node.info.equals(element)){
            return depth;
        }

        int temp_depth = getDepth(element, node.left, depth+1);
        if (temp_depth != 0){
            return temp_depth;
        }

        temp_depth = getDepth(element, node.right, depth+1);
        return temp_depth;
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
        int dlabocina = getDepth(vrednost, tree.root, 1);

        if (dlabocina != 0){
            System.out.println("Level of " +vrednost+" is " + dlabocina);
        }
        else {
            System.out.println("The value "+vrednost+" doesn't exist in this tree");
        }
    }
}
