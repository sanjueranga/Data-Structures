public class Stack {
    sNode top;

    public void push(TreeNode node) {
        sNode newNode = new sNode(node);
        if (this.top == null) {
            this.top = newNode;
        } else {
            newNode.next = this.top;
            this.top = newNode;
        }
    }

    public TreeNode pop() {
        sNode temp = this.top;
        this.top = this.top.next;

        return temp.node;
    }

    public boolean isEmpty() {
        if (this.top == null) {
            return true;
        }
        return false;
    }
}
