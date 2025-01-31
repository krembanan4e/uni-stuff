package drva;

/*
Да се имплементира функциjа коjа ке проверува дали дадено бинарно пребарувачко дрво е балансирано или не.

         8
       /   \
      2     11
     / \       \
    1    5      19
        / \     /
       3   6   13

Излез:
The given binary search tree is NOT balanced.  --> imat greska vo knigata pisit dek e balansirano 
*/

import java.util.*;

public class KnigaDrva_str322 {
    public static int height(BNode<Integer> node){
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(height(node.left), height(node.right));
    }

    private static boolean isBalanced(BNode<Integer> node) {
        if (node == null) {
            return true;
        }

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        if ((Math.abs(leftHeight - rightHeight) <= 1) && isBalanced(node.left) && isBalanced(node.right)) {
            return true;
        }
        return false;
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

        if (isBalanced(tree.getRoot())){
            System.out.println(" The given binary search tree is also balanced.");
        }
        else{
            System.out.println("The given binary search tree is NOT balanced.");
        }
    }
}
