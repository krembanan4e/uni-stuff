package drva;

//rastojanie pomegju jazli

/*
        1
       / \
      7   9
     / \   \
    2   6   19
       / \  /
      5  11 15

Пример:
Влез:
Бинарно дрво од слика 6-11
Вредноста на првиот jазел: 7
Вредноста на вториот jазел: 15
Излез:
Dist(7, 15) = 4

 */

import java.util.Scanner;

public class KnigaDrva_str285 {
    public static BNode<Integer> zaednickiPredok (BNode<Integer> node, int pocetok, int kraj){
        if (node == null){
            return null;
        }
        if (node.info.equals(pocetok) || node.info.equals(kraj)){
            return node;
        }

        BNode<Integer> levZaednickiPredok = zaednickiPredok(node.left, pocetok, kraj);
        BNode<Integer> desenZaednickiPredok = zaednickiPredok(node.right, pocetok, kraj);

        if (levZaednickiPredok != null && desenZaednickiPredok != null){
            return node; //zaednickiot predok na dvata jazli
        }
        if (levZaednickiPredok == null && desenZaednickiPredok == null){
            return null;
        }
        if (levZaednickiPredok != null){
            return levZaednickiPredok;
        }
        else {
            return desenZaednickiPredok;
        }
    }

    private static int getDepth(int element, BNode<Integer> node, int depth) {
        if (node == null){
            return 0;
        }
        if (node.info.equals(element)){
            return depth;
        }

        int temp_depth = getDepth(element, node.left, depth + 1);
        if (temp_depth != 0){
            return temp_depth;
        }
        temp_depth = getDepth(element, node.right, depth + 1);
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

        int pocetok = sc.nextInt();
        int kraj = sc.nextInt();

        BNode<Integer> predok = zaednickiPredok(tree.root, pocetok, kraj);

        if (predok != null){
            int pocetokDepth = getDepth(pocetok, predok, 0);
            int krajDepth = getDepth(kraj, predok, 0);

            System.out.println("Dist("+pocetok+", "+kraj+") = "+ (pocetokDepth + krajDepth));
        }
    }
}
