// Singly linked list of ints with head and tail pointers.
#include <iostream>

struct Node {
    int data;
    Node* next;
    explicit Node(int d) : data(d), next(nullptr) {}
};

class LinkedList {
public:
    Node* head = nullptr;
    Node* tail = nullptr;

    ~LinkedList() {
        while (head) {
            Node* next = head->next;
            delete head;
            head = next;
        }
    }

    void insertFront(int value) {
        Node* node = new Node(value);
        if (!head) {
            head = tail = node;
        } else {
            node->next = head;
            head = node;
        }
    }

    void insertRear(int value) {
        Node* node = new Node(value);
        if (!head) {
            head = tail = node;
        } else {
            tail->next = node;
            tail = node;
        }
    }

    void insertNext(Node* prev, int value) {
        if (!prev) {
            std::cout << "The given previous node cannot be null\n";
            return;
        }
        Node* node = new Node(value);
        node->next = prev->next;
        prev->next = node;
        if (prev == tail) tail = node;
    }

    Node* search(int x) const {
        for (Node* cur = head; cur; cur = cur->next) {
            if (cur->data == x) return cur;
        }
        return nullptr;
    }

    bool nodeExists(int x) const { return search(x) != nullptr; }

    void display() const {
        for (Node* cur = head; cur; cur = cur->next) std::cout << cur->data << " ";
        std::cout << "\n";
    }

    void remove(int key) {
        Node* cur = head;
        Node* prev = nullptr;
        while (cur && cur->data != key) {
            prev = cur;
            cur = cur->next;
        }
        if (!cur) return;

        if (prev) prev->next = cur->next;
        else head = cur->next;
        if (cur == tail) tail = prev;
        delete cur;
    }
};

int main() {
    LinkedList list;

    list.insertRear(20);
    list.insertRear(30);
    list.insertRear(40);
    list.insertRear(50);
    list.insertFront(10);
    list.insertRear(60);
    list.insertNext(list.search(30), 70);
    list.display();

    list.remove(60);
    list.display();

    list.remove(10);
    list.insertRear(23);
    list.display();
    return 0;
}
