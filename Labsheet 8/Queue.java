public class Queue {

    QueueNode front;
    QueueNode rear;

    public void enqueue(TreeNode data) {

        QueueNode new_node = new QueueNode(data);
        if(this.front==null){
            this.front = new_node;
            this.rear = new_node;
        }else{
            rear.next = new_node;
            this.rear = new_node;
        }
       
    }

    public TreeNode dequeue() {

        if (front != null) {
            TreeNode temp = this.front.node;
            this.front = front.next;
            return temp;
        }
        return null;

    }

    public boolean isEmpty(){
        if(this.front == null){
            return true;
        }
        return false;
    }

}