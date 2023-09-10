public class Queue {

    QNode front;
    QNode rear;

    public void enqueue(TreeNode data) {
        QNode new_node = new QNode(data);
        if (this.front == null) {
            this.rear = this.front = new_node;
        } else {
            this.rear.next = new_node;
            this.rear = new_node;
        }

    }

    public TreeNode dequeue() {
        QNode temp = this.front;
        this.front = this.front.next;
        return temp.node;
    }

    public boolean isEmpty() {
        if (this.front == null) {
            return true;
        }
        return false;

    }
}
