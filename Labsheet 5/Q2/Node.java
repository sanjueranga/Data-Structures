package Q2;

public class Node {

    Node next;
    Book data;

    public Node(Book data) {
        this.next = null;
        this.data = data;
    }

    public void printDetails() {
        System.out.println(data + " ");
    }
}