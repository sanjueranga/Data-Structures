public class Driver {

    public static void main(String[] args) {

        BinarySearchTree tree = new BinarySearchTree();

        tree.insert(18);
        tree.insert(9);
        tree.insert(26);
        tree.insert(3);
        tree.insert(16);
        tree.insert(20);
        tree.insert(34);
        tree.insert(1);
        tree.insert(5);
        tree.insert(11);
        tree.insert(17);
        tree.insert(19);
        tree.insert(23);
        tree.insert(32);
        tree.insert(13);
        tree.insert(21);
        tree.insert(12);
        tree.insert(15);

        // // i
        tree.search(1);
        tree.delete(1);
        tree.search(1);

        System.out.println(" ");

        // // ii
        tree.search(34);
        tree.delete(34);
        tree.search(34);

        System.out.println(" ");

        // iii , dlete method uses minimum subtree method by default

        tree.delete(9);
        tree.search(9);

        System.out.println(" ");

        // setting deleteMin variable to false to chose the maximum subtree method

        tree.delete(20);
        tree.search(20);

        tree.inOrder();

    }

}