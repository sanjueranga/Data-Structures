// BST of letters (duplicates go left) with DFS / BFS that print the visit order.
#include <iostream>
#include <queue>
#include <stack>
#include <string>

struct TreeNode {
    char letter;
    TreeNode* left = nullptr;
    TreeNode* right = nullptr;
    explicit TreeNode(char c) : letter(c) {}
};

class BinarySearchTree {
    TreeNode* root = nullptr;

    static TreeNode* insertNode(TreeNode* node, char letter) {
        if (!node) return new TreeNode(letter);
        if (letter <= node->letter) node->left = insertNode(node->left, letter);
        else node->right = insertNode(node->right, letter);
        return node;
    }

    static int treeLevel(const TreeNode* n, char letter, int level) {
        if (!n) return -1;
        if (n->letter == letter) return level;
        int found = treeLevel(n->left, letter, level + 1);
        if (found != -1) return found;
        return treeLevel(n->right, letter, level + 1);
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

    void insert(char letter) { root = insertNode(root, letter); }
    int getLevel(char letter) const { return treeLevel(root, letter, 0); }

    std::string depthFirstSearch(char value) const {
        if (!root) return "tree is empty";
        std::stack<TreeNode*> pending;
        pending.push(root);
        while (!pending.empty()) {
            TreeNode* cur = pending.top();
            pending.pop();
            std::cout << "->" << cur->letter;
            if (cur->letter == value) return "found";
            if (cur->right) pending.push(cur->right);
            if (cur->left) pending.push(cur->left);
        }
        return "not found";
    }

    std::string breadthFirstSearch(char value) const {
        if (!root) return "tree is empty";
        std::queue<TreeNode*> pending;
        pending.push(root);
        while (!pending.empty()) {
            TreeNode* cur = pending.front();
            pending.pop();
            std::cout << "->" << cur->letter;
            if (cur->letter == value) return "found at level " + std::to_string(getLevel(value));
            if (cur->left) pending.push(cur->left);
            if (cur->right) pending.push(cur->right);
        }
        return "not found";
    }
};

int main() {
    BinarySearchTree tree;
    for (char c : std::string("NONLINEARDATATYPE")) tree.insert(c);

    std::cout << "level of E: " << tree.getLevel('E') << "\n";
    std::cout << "\nDFS: " << tree.depthFirstSearch('T') << "\n";
    std::cout << "BFS: " << tree.breadthFirstSearch('T') << "\n";
    return 0;
}
