public class Driver {
    public static void main(String[] args) {

        BST tree = new BST();

        tree.insert(12);
        tree.insert(1);
        tree.insert(9);
        tree.insert(3);
        tree.insert(4);
        tree.insert(22);
        tree.insert(22);
        tree.insert(1);

        tree.insert(15);

        tree.insert(8);

        // tree.DFS(12);
        // System.out.println("");
        // tree.BFS(12);
        // tree.inorder();
        // System.out.println("");
        tree.preorder();
        System.out.println("");
        // tree.postorder();
        // System.out.println("");

        tree.DFS(256);

    }
}
