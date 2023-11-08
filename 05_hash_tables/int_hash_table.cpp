// Hash table of ints using separate chaining (modulo hash).
#include <iostream>

struct Node {
    int data;
    Node* next = nullptr;
    explicit Node(int d) : data(d) {}
};

class LinkedList {
    Node* head = nullptr;
    Node* tail = nullptr;

public:
    LinkedList() = default;
    LinkedList(const LinkedList&) = delete;
    LinkedList& operator=(const LinkedList&) = delete;

    ~LinkedList() {
        while (head) {
            Node* next = head->next;
            delete head;
            head = next;
        }
    }

    void insert(int value) {
        Node* node = new Node(value);
        if (!head) head = tail = node;
        else {
            tail->next = node;
            tail = node;
        }
    }

    bool remove(int value) {
        Node* prev = nullptr;
        Node* cur = head;
        while (cur && cur->data != value) {
            prev = cur;
            cur = cur->next;
        }
        if (!cur) return false;

        if (prev) prev->next = cur->next;
        else head = cur->next;
        if (cur == tail) tail = prev;
        delete cur;
        return true;
    }

    void display() const {
        for (Node* cur = head; cur; cur = cur->next) std::cout << cur->data << " ";
    }
};

class HashTable {
    static const int SIZE = 10;
    LinkedList* buckets[SIZE] = {nullptr};

    static int hashCode(int data) { return data % SIZE; }

public:
    HashTable() = default;
    HashTable(const HashTable&) = delete;
    HashTable& operator=(const HashTable&) = delete;

    ~HashTable() {
        for (LinkedList* b : buckets) delete b;
    }

    void insert(int data) {
        int index = hashCode(data);
        if (!buckets[index]) buckets[index] = new LinkedList();
        buckets[index]->insert(data);
    }

    // Looks the value up and removes it from the table.
    void retrieve(int data) {
        LinkedList* bucket = buckets[hashCode(data)];
        if (!bucket || !bucket->remove(data)) std::cout << "Item Not Found\n";
    }

    void display() const {
        for (LinkedList* b : buckets) {
            if (b) {
                b->display();
                std::cout << "\n";
            }
        }
    }
};

int main() {
    HashTable table;
    for (int v : {5, 10, 20, 1, 0, 100, 13, 21}) table.insert(v);

    table.display();
    table.retrieve(100);
    std::cout << "after deletion\n";
    table.display();
    return 0;
}
