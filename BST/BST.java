public class BST {
    TreeNode root;

    public void insert(int data) {
        TreeNode new_node = new TreeNode(data);
        this.root = insertNode(this.root, new_node);
    }

    private TreeNode insertNode(TreeNode root, TreeNode new_node) {
        if (root == null) {
            root = new_node;
            return root;
        } else if (new_node.data < root.data) {
            root.left = insertNode(root.left, new_node);
        } else if (new_node.data >= root.data) {
            root.right = insertNode(root.right, new_node);
        }
        return root;
    }

    public void DFS(int value) {
        Stack stack = new Stack();
        stack.push(this.root);

        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            System.out.print(temp.data + " ");
            if (temp.data == value) {
                System.out.println("value found");
                return;
            }

            if (temp.right != null) {
                stack.push(temp.right);

            }
            if (temp.left != null) {
                stack.push(temp.left);
            }
        }
    }

    public void BFS(int value) {
        Queue queue = new Queue();
        queue.enqueue(this.root);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.dequeue();
            System.out.print(temp.data + " ");
            if (temp.data == value) {
                System.out.println("found");
                return;
            } else {
                if (temp.left != null) {
                    queue.enqueue(temp.left);
                }
                if (temp.right != null) {
                    queue.enqueue(temp.right);

                }
            }
        }

    }

    public void inorder() {
        inorderTraversal(this.root);
    }

    private void inorderTraversal(TreeNode root) {
        if (root != null) {
            inorderTraversal(root.left);
            System.out.print(root.data + " ");
            inorderTraversal(root.right);
        }

    }

    public void preorder() {
        preorderTraversal(this.root);
    }

    private void preorderTraversal(TreeNode root) {
        if (root != null) {

            System.out.print(root.data + " ");
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }

    }

    public void postorder() {
        postorderTraversal(this.root);
    }

    private void postorderTraversal(TreeNode root) {
        if (root != null) {

            preorderTraversal(root.left);
            preorderTraversal(root.right);
            System.out.print(root.data + " ");
        }

    }

    public void delete(int value) {
        this.root = deleteNode(this.root, value);
    }

    private TreeNode deleteNode(TreeNode root, int value) {
        if (root == null) {
            return root;
        } else if (value < root.data) {
            root.left = deleteNode(root.left, value);
        } else if (value > root.data) {
            root.right = deleteNode(root.right, value);
        } else {
            if (root.right == null && root.left == null) {
                return null;
            } else if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                TreeNode min = minVal(root.right);
                root.data = min.data;
                root.right = deleteNode(root.right, min.data);
            }
        }
        return root;
    }

    public void getLevel(int value) {
        int level = TreeLevel(this.root, value, 0);
        System.out.println(level);
    }

    private int TreeLevel(TreeNode root, int value, int level) {

        if (root == null) {
            return 0;
        }
        if (root.data == value) {
            return level;
        }
        int result = TreeLevel(root.left, value, level);
        if (result != 0) {
            return result;
        }
        result = TreeLevel(root.right, value, level);
        return result;
    }

    private TreeNode minVal(TreeNode root) {
        if (root.left == null) {
            return root;
        }
        return minVal(root.left);
    }

}
