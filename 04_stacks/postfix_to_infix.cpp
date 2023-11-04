// Convert a postfix expression to a fully parenthesised infix expression.
#include <cctype>
#include <iostream>
#include <string>

struct Node {
    std::string data;
    Node* next;
    Node(const std::string& d, Node* n) : data(d), next(n) {}
};

class Stack {
    Node* top = nullptr;

public:
    Stack() = default;
    Stack(const Stack&) = delete;
    Stack& operator=(const Stack&) = delete;

    ~Stack() {
        while (!isEmpty()) pop();
    }

    bool isEmpty() const { return top == nullptr; }

    void push(const std::string& data) { top = new Node(data, top); }

    std::string pop() {
        Node* temp = top;
        std::string value = temp->data;
        top = top->next;
        delete temp;
        return value;
    }
};

int main() {
    Stack stack;
    std::string postfix = "ab+cd+*";
    std::string infix;

    for (char c : postfix) {
        if (std::isalpha(static_cast<unsigned char>(c))) {
            stack.push(std::string(1, c));
        } else {
            std::string right = stack.pop();
            std::string left = stack.pop();
            infix = "(" + left + c + right + ")";
            stack.push(infix);
        }
    }

    std::cout << infix << "\n";
    return 0;
}
