public class Queue {

    QNode front;
    QNode rear;

    public void enqueue(TreeNode node) {

        QNode new_node = new QNode(node);
        if (this.front == null) {
            this.front = new_node;
            this.rear = new_node;
        } else {

            rear.next = new_node;
            this.rear = new_node;
        }
    }

    public TreeNode dequeue() {

        if (this.front == null) {
            return null;
        }
        QNode temp = this.front;
        this.front = this.front.next;

        if (this.front == null) {
            this.rear = null;
        }
        return temp.node;
    }

    public boolean isEmpty() {
        if (this.front == null) {
            return true;
        }
        return false;

    }

}