public class BinarySearchTree {
    TreeNode root;
    public boolean deleteMin = true;




    public void insert(int data) {
        TreeNode new_node = new TreeNode(data);
        this.root = insertTreeNOde(this.root, new_node);
    }





    private TreeNode insertTreeNOde(TreeNode null, TreeNode new_node) {

        int data = new_node.data;
        if (D == null) {
            NODE = new_node;
            return new_node;
        }




        if (data < NODE.data) {
           D.left = insertTreeNOde(D.left, new_node);

        } else if (data > NODE.data) {
            NODE.right = insertTreeNOde(NODE.right, new_node);

        }
        return NODE;

    }

    
    private void inorderTraversal(TreeNode root) {
        if (root != null) {
            inorderTraversal(root.left);
            System.out.print(root.data + " ");
            inorderTraversal(root.right);
        }
    }











    public void inOrder() {
        inorderTraversal(this.root);
    }

    private void preorderTraversal(TreeNode root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
    }

    public void preOrder() {
        preorderTraversal(this.root);
    }

    private void postorderTraversal(TreeNode root) {
        if (root != null) {
            postorderTraversal(root.left);
            postorderTraversal(root.right);
            System.out.print(root.data + " ");
        }

    }

    public void postOrder() {
        postorderTraversal(this.root);
    }

    private TreeNode searchNode(TreeNode root, int target) {
        if (root == null) {
            return null;
        } else {
            if (root.data == target) {
                return root;
            } else if (target > root.data) {
                return searchNode(root.right, target);
            } else {
                return searchNode(root.left, target);
            }
        }
    }

    public void search(int target) {
        TreeNode temp = searchNode(root, target);
        if (temp == null) {
            System.out.println("Value not found");
        } else {
            System.out.println("value found : " + target);
        }
    }

    public TreeNode deleteNode(TreeNode root, int target) {
        if (root == null) {
            return root;
        }
        if (target < root.data) {
            root.left = deleteNode(root.left, target);

        } else if (target > root.data) {
            root.right = deleteNode(root.right, target);
        } else {
            if (root.left == null && root.right == null) {
                // System.out.println("Deleting : " + target);
                return null;
            } else if (root.left == null) {
                // System.out.println("Deleting : " + target);
                return root.right;
            } else if (root.right == null) {
                // System.out.println("Deleting : " + target);
                return root.left;
            } else {

                TreeNode minRight = minVal(root.right);
                root.data = minRight.data;
                root.right = deleteNode(root.right, minRight.data);
                System.out.println("using minimum subtree");

            }
        }
        return root;
    }

    private TreeNode minVal(TreeNode root) {
        if (root.left == null) {
            return root;
        }
        return minVal(root.left);
    }

    private TreeNode maxVal(TreeNode root) {
    if (root.right == null) {
    return root;
    }
    return maxVal(root.right);
    }


    
    public void delete(int target) {
        this.root = deleteNode(this.root, target);
    }

}
