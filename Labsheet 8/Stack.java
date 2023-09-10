public class Stack {

    StackNode top;

    public void push(TreeNode data) {
        StackNode new_node = new StackNode(data);
        if (this.top == null) {
            this.top = new_node;
        } else {
            new_node.next = this.top.next;
            this.top = new_node;
        }
    }

    public TreeNode pop() {
        if (this.top != null) {
            TreeNode temp = this.top.node;
            this.top = this.top.next;
            return temp;
        } else {
            System.out.println("The stack is empty");
            return null;
        }
    }

    public boolean isEmpty() {
        if (this.top == null) {
            return true;
        }
        return false;
    }
}