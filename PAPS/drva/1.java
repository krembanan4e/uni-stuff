import java.util.*;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Main {
    private static int countLeaves(SLLTree<Integer> tree, Tree.Node<Integer> askNode) {
        int counter = 0;
        if (tree.childCount(askNode) == 0){ 
            return 1;
        }
        for (Tree.Node<Integer> childNode : tree.childrenNodes(askNode)) { 
            counter += countLeaves(tree, childNode); 
        }
        return counter;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String []line1 = sc.nextLine().split(" ");
        int n = Integer.parseInt(line1[0]);
        int q = Integer.parseInt(line1[1]);
        int nq = n+q;
        SLLTree<Integer> tree = new SLLTree<Integer>();
        Map<Integer, Tree.Node<Integer>> nodes = new HashMap<>(); 

        for (int i = 0; i < nq; i++) {
            String []line = sc.nextLine().split(" ");
            if (Objects.equals(line[0], "root")){
                tree.makeRoot(Integer.parseInt(line[1]));
                nodes.put(Integer.parseInt(line[1]), tree.root);
            }
            else if (Objects.equals(line[0], "add")){
                Tree.Node<Integer> parentNode = nodes.get(Integer.parseInt(line[1]));
                Tree.Node<Integer> childNode = tree.addChild(parentNode, Integer.parseInt(line[2]));
                nodes.put(Integer.parseInt(line[2]), childNode); 
            }
            else{ //ask
                Tree.Node<Integer> askNode = nodes.get(Integer.parseInt(line[1])); 
                System.out.println(countLeaves (tree, askNode));
            }
        }
    }
}
