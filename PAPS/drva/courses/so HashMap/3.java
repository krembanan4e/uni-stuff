package drva;

import java.util.HashMap;
import java.util.Scanner;

public class CoursesDrva03 {
    private static int countNodesWithTwoChildren(BNode<String> node) {
        if (node == null) {
            return 0;
        }
        if (node.left != null && node.right != null) {
            return 1 + countNodesWithTwoChildren(node.left) + countNodesWithTwoChildren(node.right);
        }
        return countNodesWithTwoChildren(node.left) + countNodesWithTwoChildren(node.right);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int q = sc.nextInt();
        sc.nextLine();

        BTree<String> tree = new BTree<>();
        HashMap<String, BNode<String>> map = new HashMap<>();

        for (int i = 0; i < n+q; i++) {
            String []parts = sc.nextLine().split(" ");
            if (parts[0].equals("root")){
                String parentId = parts[1];
                tree.makeRoot(parentId);
                map.put(parentId, tree.root);
            }
            else if (parts[0].equals("add")){
                String parentId = parts[1];
                String childId = parts[2];
                String position = parts[3];
                if (position.equals("LEFT")){
                    BNode<String> node = tree.addChild(map.get(parentId), BNode.LEFT, childId);
                    map.put(childId, node);
                }
                else{ //RIGHT
                    BNode<String> node = tree.addChild(map.get(parentId), BNode.RIGHT, childId);
                    map.put(childId, node);
                }
            }
            else{ //ask
                String parentId = parts[1];
                BNode<String> node = map.get(parentId);
                System.out.println(countNodesWithTwoChildren(node));
            }
        }
    }
}
