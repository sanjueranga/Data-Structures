public class Driver {

    public static void main(String[] args) {
        BinarySearchTree BST = new BinarySearchTree();

        BST.insert('N');
        BST.insert('O');
        BST.insert('N');
        BST.insert('L');
        BST.insert('I');
        BST.insert('N');
        BST.insert('E');
        BST.insert('A');
        BST.insert('R');
        BST.insert('D');
        BST.insert('A');
        BST.insert('T');
        BST.insert('A');
        BST.insert('T');
        BST.insert('Y');
        BST.insert('P');
        BST.insert('E');

        System.out.println(BST.getLevel('E'));

        BST.deapthFirstSearch('T');
        System.out.println("");
        BST.BFS('T');

    }
}
