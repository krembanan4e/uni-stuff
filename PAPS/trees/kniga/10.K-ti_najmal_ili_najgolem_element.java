package drva;

/*

        8
       /  \
      2    11
     / \     \
    1   5     19
        /\    /
       3  6  13

Пример:
Влез:
Бинарно дрво од слика 6-39
Вредност за k: 4

Излез:
The 4-th smallest element in BST is 5
The 4-th biggest element in BST is 8
 */

import java.util.*;

public class KnigaDrva_str324 {
    private static void inorder(BNode<Integer> node, ArrayList<Integer> list) { //inorder == sortirano vo rastecki redosled
        if (node == null){
            return;
        }

        //levo koren desno

        inorder(node.left, list);
        list.add(node.info);
        inorder(node.right, list);
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.insert(8);
        tree.insert(2);
        tree.insert(11);
        tree.insert(1);
        tree.insert(5);
        tree.insert(19);
        tree.insert(3);
        tree.insert(6);
        tree.insert(13);

        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();

        ArrayList<Integer> list = new ArrayList<>();
        inorder(tree.getRoot(), list);

//        for (int i = 0; i < list.size(); i++) {
//            System.out.print(list.get(i) + " ");
//            System.out.println();
//        }

        if (k > 0 && k <= list.size()){
            System.out.println("The "+k+"-th smallest element in BST is " + list.get(k-1));
            System.out.println("The "+k+"-th biggest element in BST is " + list.get(list.size() - k));
        }

        else {
            System.out.println("Enter a valid number");
        }

    }
}
