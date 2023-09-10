package Q2;

public class LinkedList {

    Node head;
    Node tail;

    public LinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void insertRear(Book book) {
        Node new_node = new Node(book);

        if (head == null) {
            head = new_node;
            tail = new_node;
        } else {
            tail.next = new_node;
            tail = new_node;
        }
    }

    public Node searchLinkedList(String author) {

        Node temp = head, prev = null;
        if (temp.data.getAuthor().equals(author)) {
            this.head = head.next;
            return temp;
        }
        while (temp.data.getAuthor().equals(author) != true) {
            prev = temp;
            temp = temp.next;
        }

        prev.next = temp.next;
        return temp;

    }

    public void displayList() {
        Node temp = head;
        while (temp != null) {

            System.out.println(
                    "\t" + temp.data.getBook_id() + "," + temp.data.getBook_name() + "," + temp.data.getAuthor() + ","
                            + temp.data.getNum_pages() + "," + temp.data.getRatings());

            temp = temp.next;
        }

    }

}