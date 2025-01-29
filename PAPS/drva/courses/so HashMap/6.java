package drva;

import java.util.Scanner;

public class CoursesDrva06 {
    private static int findDepth(BNode<Integer> node, int element) {
        if (node == null){
            return 0;
        }
        else if (node.info.equals(element)){
            return 1;
        }
        else if (node.info > element){
            return 1 + findDepth(node.left, element);
        }
        else{
            return 1 + findDepth(node.right, element);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int q = sc.nextInt();
        sc.nextLine();

        BinarySearchTree<Integer> tree = new BinarySearchTree<>();

        for (int i = 0; i < n+q; i++) {
            String []parts = sc.nextLine().split(" ");
            String command = parts[0];
            int nodeId = Integer.parseInt(parts[1]);

            if (command.equals("insert")) {
                tree.insert(nodeId);
            }
            else{ //ask
                System.out.println(findDepth(tree.getRoot(), nodeId));
            }
        }
    }
}
