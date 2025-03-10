import java.util.*;

public class Main{

    private static int findDepth(BNode<Integer> root, BNode<Integer> node, int depth) {
        if (root == null){
            return -1;
        }
        if (node.info.compareTo(root.info) < 0) {
            return findDepth(root.left, node, depth+1);
        }
        else if (node.info.compareTo(root.info) > 0) {
            return findDepth(root.right, node, depth+1);
        }
        else { //ako se isti (compareTo==0)
            return depth;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        sc.nextLine();
        BinarySearchTree<Integer> bstree = new BinarySearchTree<>();

        for (int i = 0; i < n+q; i++) {
            String []parts = sc.nextLine().split(" ");
            int number = Integer.parseInt(parts[1]);
            if (parts[0].equals("insert")){
                bstree.insert(number);
            }
            else{ //ask
                BNode<Integer> node = bstree.find(number);
                System.out.println(findDepth(bstree.getRoot(), node, 1));
            }
        }
    }
}
