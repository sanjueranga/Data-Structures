// Binary search tree of ints: traversals, DFS/BFS search and node level.
#include <iostream>
#include <queue>
#include <stack>
#include <string>

struct TreeNode {
    int key;
    TreeNode* left = nullptr;
    TreeNode* right = nullptr;
    explicit TreeNode(int k) : key(k) {}
};

class BinarySearchTree {
    TreeNode* root = nullptr;

    static TreeNode* insertNode(TreeNode* node, int key) {
        if (!node) return new TreeNode(key);
        if (key < node->key) node->left = insertNode(node->left, key);
        else if (key > node->key) node->right = insertNode(node->right, key);
        return node;
    }

    static void inorder(const TreeNode* n) {
        if (!n) return;
        inorder(n->left);
        std::cout << n->key << " ";
        inorder(n->right);
    }

    static void preorder(const TreeNode* n) {
        if (!n) return;
        std::cout << n->key << " ";
        preorder(n->left);
        preorder(n->right);
    }

    static void postorder(const TreeNode* n) {
        if (!n) return;
        postorder(n->left);
        postorder(n->right);
        std::cout << n->key << " ";
    }

    // Level of key below node, or -1 if it is not in this subtree.
    static int treeLevel(const TreeNode* n, int key, int level) {
        if (!n) return -1;
        if (n->key == key) return level;
        int found = treeLevel(n->left, key, level + 1);
        if (found != -1) return found;
        return treeLevel(n->right, key, level + 1);
    }

    static void destroy(TreeNode* n) {
        if (!n) return;
        destroy(n->left);
        destroy(n->right);
        delete n;
    }

public:
    BinarySearchTree() = default;
    BinarySearchTree(const BinarySearchTree&) = delete;
    BinarySearchTree& operator=(const BinarySearchTree&) = delete;
    ~BinarySearchTree() { destroy(root); }

    void insert(int key) { root = insertNode(root, key); }
    void inorder() const { inorder(root); }
    void preorder() const { preorder(root); }
    void postorder() const { postorder(root); }
    int getLevel(int key) const { return treeLevel(root, key, 0); }

    std::string depthFirstSearch(int value) const {
        if (!root) return "tree is empty";
        std::stack<TreeNode*> pending;
        pending.push(root);
        while (!pending.empty()) {
            TreeNode* cur = pending.top();
            pending.pop();
            if (cur->key == value) return "found";
            if (cur->right) pending.push(cur->right);
            if (cur->left) pending.push(cur->left);
        }
        return "not found";
    }

    std::string breadthFirstSearch(int value) const {
        if (!root) return "tree is empty";
        std::queue<TreeNode*> pending;
        pending.push(root);
        while (!pending.empty()) {
            TreeNode* cur = pending.front();
            pending.pop();
            if (cur->key == value) return "found";
            if (cur->left) pending.push(cur->left);
            if (cur->right) pending.push(cur->right);
        }
        return "not found";
    }
};

int main() {
    BinarySearchTree tree;
    for (int k : {44, 27, 37, 60, 12, 28, 62, 45}) tree.insert(k);

    std::cout << "inorder:   ";
    tree.inorder();
    std::cout << "\npreorder:  ";
    tree.preorder();
    std::cout << "\npostorder: ";
    tree.postorder();
    std::cout << "\n";

    std::cout << "level of 12: " << tree.getLevel(12) << "\n";
    std::cout << "DFS 45: " << tree.depthFirstSearch(45) << "\n";
    std::cout << "BFS 99: " << tree.breadthFirstSearch(99) << "\n";
    return 0;
}
