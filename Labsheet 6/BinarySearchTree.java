public class BinarySearchTree {

    TreeNode root;

    public void insert(int key) {
        TreeNode newNode = new TreeNode(key);
        this.root = insertTreeNode(this.root, newNode);
    }

    private TreeNode insertTreeNode(TreeNode root, TreeNode newNode) {
        int key = newNode.key;
        if (root == null) {
            root = newNode;
            return root;
        }

        if (key < root.key) {
            root.left = insertTreeNode(root.left, newNode);
        } else if (key > root.key) {
            root.right = insertTreeNode(root.right, newNode);

        }
        return root;

    }

    public void inorder() {
        inorderTraversal(this.root);
    }

    private void inorderTraversal(TreeNode root) {
        if (root != null) {
            inorderTraversal(root.left);
            System.out.print(root.key + " ");
            inorderTraversal(root.right);
        }
    }

    public void preorder() {

        preorderTraversal(this.root);
    }

    private void preorderTraversal(TreeNode root) {
        if (root != null) {
            System.out.print(root.key + " ");
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }

    }

    public void postorder() {

        postorderTraversal(this.root);
    }

    private void postorderTraversal(TreeNode root) {
        if (root != null) {

            postorderTraversal(root.left);
            postorderTraversal(root.right);
            System.out.print(root.key + " ");
        }

    }

    public String deapthFirstSearch(int value) {
        Stack stack = new Stack();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            if (temp.key == value) {
                return "found";
            } else {
                if (temp.right != null) {
                    stack.push(temp.right);
                }
                if (temp.left != null) {
                    stack.push(temp.left);
                }
            }

        }
        return "not found";

    }

    public String BFS(int value) {

        if (this.root == null) {
            return "tree is empty";
        } else {
            Queue queue = new Queue();
            queue.enqueue(root);

            while (!queue.isEmpty()) {

                TreeNode temp = queue.dequeue();
                if (temp.key == value) {
                    return "value";
                } else {

                    if (temp.left != null) {
                        queue.enqueue(temp.left);

                    }
                    if (temp.right != null) {
                        queue.enqueue(temp.right);

                    }
                }
                ;
            }

            return "not found";

        }
    }

    public int getLevel(int key) {
        int depth = TreeLevel(root, key, 0);
        return depth;
    }

    private int TreeLevel(TreeNode root, int key, int level) {

        if (root == null) {
            return 0;
        }
        if (root.key == key) {
            return level;
        }
        int result = TreeLevel(root.left, key, level + 1);
        if (result != 0) {
            // If found in left subtree , return
            return result;
        }
        result = TreeLevel(root.right, key, level + 1);

        return result;
    }

}