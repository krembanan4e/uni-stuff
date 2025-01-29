package drva;

import java.util.HashMap;
import java.util.Scanner;

public class CoursesDrva02 {
    private static int countInsideNodes(BNode<String> node) {
        if (node == null){
            return 0;
        }
        if (node.left == null && node.right == null){
            return 0;
        }
        return 1 + countInsideNodes(node.left) + countInsideNodes(node.right);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int q = sc.nextInt();

        BTree<String> tree = new BTree<>();
        HashMap<String, BNode<String>> map = new HashMap<>();

        sc.nextLine();
        for (int i = 0; i < n+q; i++) {
            String []parts = sc.nextLine().split(" ");
            if (parts[0].equals("root")){
                String rootId = parts[1];
                tree.makeRoot(rootId);
                map.put(rootId, tree.root);
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
                System.out.println(countInsideNodes(node));
            }
        }
    }
}
