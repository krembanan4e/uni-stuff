package drva;

public class KnigaDrva_str274 {
    public static void main(String[] args) {
        BTree<String> tree = new BTree<>();
        tree.makeRoot("apple");

        BNode<String> node1 = tree.addChild(tree.root, BNode.LEFT, "pear");
        BNode<String> node2 = tree.addChild(node1, BNode.LEFT, "peach");
        BNode<String> node3 = tree.addChild(tree.root, BNode.RIGHT, "banana");
        BNode<String> node4 = tree.addChild(node3, BNode.LEFT, "lemon");
        BNode<String> node5 = tree.addChild(node3, BNode.RIGHT, "orange");

        tree.inorder();
    }
}
