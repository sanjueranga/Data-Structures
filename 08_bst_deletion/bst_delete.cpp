// BST with search and node deletion (leaf, one child, two children).
#include <iostream>

struct TreeNode {
    int data;
    TreeNode* left = nullptr;
    TreeNode* right = nullptr;
    explicit TreeNode(int d) : data(d) {}
};

class BinarySearchTree {
    TreeNode* root = nullptr;

    static TreeNode* insertNode(TreeNode* node, int data) {
        if (!node) return new TreeNode(data);
        if (data < node->data) node->left = insertNode(node->left, data);
        else if (data > node->data) node->right = insertNode(node->right, data);
        return node;
    }

    static TreeNode* searchNode(TreeNode* node, int target) {
        if (!node || node->data == target) return node;
        return target > node->data ? searchNode(node->right, target)
                                   : searchNode(node->left, target);
    }

    static TreeNode* minNode(TreeNode* node) {
        while (node->left) node = node->left;
        return node;
    }

    static TreeNode* maxNode(TreeNode* node) {
        while (node->right) node = node->right;
        return node;
    }

    TreeNode* deleteNode(TreeNode* node, int target) {
        if (!node) return nullptr;

        if (target < node->data) {
            node->left = deleteNode(node->left, target);
        } else if (target > node->data) {
            node->right = deleteNode(node->right, target);
        } else if (!node->left && !node->right) {
            delete node;
            return nullptr;
        } else if (!node->left) {
            TreeNode* child = node->right;
            delete node;
            return child;
        } else if (!node->right) {
            TreeNode* child = node->left;
            delete node;
            return child;
        } else if (useMinOfRight) {
            TreeNode* replacement = minNode(node->right);
            node->data = replacement->data;
            node->right = deleteNode(node->right, replacement->data);
        } else {
            TreeNode* replacement = maxNode(node->left);
            node->data = replacement->data;
            node->left = deleteNode(node->left, replacement->data);
        }
        return node;
    }

    static void inorder(const TreeNode* n) {
        if (!n) return;
        inorder(n->left);
        std::cout << n->data << " ";
        inorder(n->right);
    }

    static void destroy(TreeNode* n) {
        if (!n) return;
        destroy(n->left);
        destroy(n->right);
        delete n;
    }

public:
    // true: replace with the smallest value of the right subtree,
    // false: replace with the largest value of the left subtree.
    bool useMinOfRight = true;

    BinarySearchTree() = default;
    BinarySearchTree(const BinarySearchTree&) = delete;
    BinarySearchTree& operator=(const BinarySearchTree&) = delete;
    ~BinarySearchTree() { destroy(root); }

    void insert(int data) { root = insertNode(root, data); }
    void remove(int target) { root = deleteNode(root, target); }
    void inOrder() const { inorder(root); }

    void search(int target) const {
        if (searchNode(root, target)) std::cout << "value found : " << target << "\n";
        else std::cout << "Value not found\n";
    }
};

int main() {
    BinarySearchTree tree;
    for (int v : {18, 9, 26, 3, 16, 20, 34, 1, 5, 11, 17, 19, 23, 32, 13, 21, 12, 15}) {
        tree.insert(v);
    }

    // leaf
    tree.search(1);
    tree.remove(1);
    tree.search(1);
    std::cout << "\n";

    // one child
    tree.search(34);
    tree.remove(34);
    tree.search(34);
    std::cout << "\n";

    // two children, using the minimum of the right subtree
    tree.remove(9);
    tree.search(9);
    std::cout << "\n";

    // two children, using the maximum of the left subtree
    tree.useMinOfRight = false;
    tree.remove(20);
    tree.search(20);

    tree.inOrder();
    std::cout << "\n";
    return 0;
}
