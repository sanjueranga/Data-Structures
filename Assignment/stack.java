public class stack {

    stackNode top;

    public void push(Node node) {
        stackNode new_node = new stackNode(node);
        if (this.top == null) {
            this.top = new_node;
        } else {
            new_node.next = top;
            this.top = new_node;
        }
    }

    public Node pop() {

        Node temp = this.top.node;
        this.top = this.top.next;
        return temp;

    }

    public boolean isEmpty() {
        if (this.top == null) {
            return true;
        } else {
            return false;
        }
    }

}
