package drva;

/*

Да се напише функциjа коjа ке го наjде претходникот и следбеникот на даден jазел при inorder изминување на бинарно пребарувачко дрво.
Вредноста на jазелот се внесува од тастатура.
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
Вредност за jазел: 3
Излез:
The inorder predecessor for 3 is 2
The inorder successor for 3 is 5
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class KnigaDrva_str326 {
    public static void inorder(BNode<Integer> node, ArrayList<Integer> list) {
        if (node == null) {
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

        ArrayList<Integer> list = new ArrayList<>();
        inorder(tree.getRoot(), list);

        HashMap<Integer, Integer> map = new HashMap<>(); //mapiranje element vo indeks
        HashMap<Integer, Integer> indeksi = new HashMap<>(); //mapiranje indeks vo element

        for (int i = 0; i < list.size(); i++) {
            map.put(list.get(i), i);
            indeksi.put(i, list.get(i));
        }

        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();

        if (!list.contains(x)) {
            System.out.println("The element " + x + " is not in this tree");
            return;
        }

        else {
            int index = map.get(x);
          
            if (index == 0) {
                System.out.println(x + " doesn't have a predecessor");
                System.out.println("The inorder successor for " + x + " is " + indeksi.get(index + 1));
                return;
            }
            else if (index == list.size() - 1) {
                System.out.println("The inorder predecessor for " + x + " is " + indeksi.get(index - 1));
                System.out.println(x + " doesn't have a successor");
                return;
            }
            else {
                System.out.println("The inorder predecessor for " + x + " is " + indeksi.get(index - 1));
                System.out.println("The inorder successor for " + x + " is " + indeksi.get(index + 1));
                return;
            }
        }
    }
}
