public class StackNode {
    StackNode next;
    TreeNode node;

    StackNode(TreeNode node) {
        this.next = null;
        this.node = node;
    }
}