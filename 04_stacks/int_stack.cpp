// Stack of ints built on a linked list.
#include <iostream>

struct Node {
    int data;
    Node* next;
    Node(int d, Node* n) : data(d), next(n) {}
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

    void push(int data) { top = new Node(data, top); }

    int pop() {
        if (!top) return -1;  // empty stack
        Node* temp = top;
        int value = temp->data;
        top = top->next;
        delete temp;
        return value;
    }

    void peek() const {
        if (!isEmpty()) std::cout << top->data << "\n";
    }

    void display() const {
        for (Node* cur = top; cur; cur = cur->next) std::cout << cur->data << "\n";
    }
};

int main() {
    Stack stack;
    for (int v : {1, 5, 6, 6, 7, 8, 10, 38}) stack.push(v);
    stack.pop();
    stack.push(58);
    stack.push(43);
    stack.pop();
    stack.push(100);
    stack.push(378);
    stack.display();
    return 0;
}
