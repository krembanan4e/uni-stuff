import java.util.*;

public class Drva6 {
    private static int findDepth(int element, BNode<Integer> node) {
        if (node == null){
            return 0;
        }
        if (node.info.equals(element)){
            return 1;
        }
        if (element < node.info){
            return 1 + findDepth(element, node.left);
        }
        return 1 + findDepth(element, node.right);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        sc.nextLine();

        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        for (int i = 0; i < n+q; i++) {
            String []parts = sc.nextLine().split(" ");
            switch (parts[0]){
                case "insert":
                    tree.insert(Integer.parseInt(parts[1]));
                    break;
                case "ask":
                    BNode<Integer> nodeToAsk = tree.find(Integer.parseInt(parts[1]));
                    if (nodeToAsk != null) {
                        int depth = findDepth(Integer.parseInt(parts[1]), tree.getRoot());
                        System.out.println(depth);
                    }
                    break;
            }
        }
    }
}
