public class LinkedList {

    Node head;
    Node tail;

    public LinkedList() {
        this.head = this.tail = null;

    }

    public void insert(History data) {
        Node new_node = new Node(data);

        if (this.head == null) {
            this.head = this.tail = new_node;

        } else {

            new_node.next = this.head;
            this.head = new_node;

        }
    }

    public void display() {
        Node temp = this.head;

        while (temp != null) {
            System.out.print(temp.data.pageName + " | ");
            System.out.print(temp.data.pageId + " | ");
            System.out.print(temp.data.Date + " | ");
            System.out.print(temp.data.url + " | ");
            System.out.print(temp.data.Bookmark + " | ");
            System.out.println("");

            temp = temp.next;

        }
    }

    public void display(Node node) {

        System.out.print(node.data.pageName + " | ");
        System.out.print(node.data.pageId + " | ");
        System.out.print(node.data.Date + " | ");
        System.out.print(node.data.url + " | ");
        System.out.print(node.data.Bookmark + " | ");
        System.out.println("");

    }

    public void displayReverse() {
        Node temp = this.head;
        stack stack = new stack();

        while (temp != null) {

            stack.push(temp);

            temp = temp.next;
        }

        while (!stack.isEmpty()) {

            display(stack.pop());

        }
    }

    public void delete(String name) {
        Node temp = this.head;
        Node prev = head;
        if (this.head.data.pageName.equals(name)) {

            this.head = head.next;
            return;
        }

        while (temp != null) {

            if (temp.data.pageName.equals(name)) {
                prev.next = temp.next;

            }
            prev = temp;
            temp = temp.next;
        }

    }

    public void displayBookmarked() {
        Node temp = this.head;

        while (temp != null) {
            if (temp.data.Bookmark == true) {
                System.out.print(temp.data.pageName + " | ");
                System.out.print(temp.data.pageId + " | ");
                System.out.print(temp.data.Date + " | ");
                System.out.print(temp.data.url + " | ");
                System.out.print(temp.data.Bookmark + " | ");
                System.out.println("");

            }
            temp = temp.next;
        }
    }
}
