public class Stack {

    Node top;

    Stack() {
        this.top = null;
    }

    void push(char data) {
        Node new_node = new Node(data);
        if (top == null) {
            this.top = new_node;
            new_node.next = null;
        } else {
            new_node.next = this.top;
            this.top = new_node;
        }

    }

    char pop() {
        char temp = this.top.data;
        this.top = this.top.next;
        return temp;
    }

    boolean isEmpty() {
        if (this.top == null) {
            return true;
        } else {
            return false;
        }
    }

    void peek() {
        if (this.isEmpty() == false) {
            System.out.println(top.data);
        }
    }

    void Display() {
        Node temp = this.top;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

}
