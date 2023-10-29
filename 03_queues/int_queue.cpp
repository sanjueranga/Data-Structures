// Queue of ints built on a linked list.
#include <iostream>

struct QueueNode {
    int data;
    QueueNode* next = nullptr;
    explicit QueueNode(int d) : data(d) {}
};

class Queue {
    QueueNode* front = nullptr;
    QueueNode* rear = nullptr;

public:
    Queue() = default;
    Queue(const Queue&) = delete;
    Queue& operator=(const Queue&) = delete;

    ~Queue() {
        while (front) {
            QueueNode* next = front->next;
            delete front;
            front = next;
        }
    }

    bool isEmpty() const { return front == nullptr; }

    void enqueue(int data) {
        QueueNode* node = new QueueNode(data);
        if (!front) {
            front = rear = node;
        } else {
            rear->next = node;
            rear = node;
        }
    }

    // Removes the front item and prints it.
    void dequeue() {
        if (!front) return;
        QueueNode* temp = front;
        std::cout << front->data << "\n";
        front = front->next;
        if (!front) rear = nullptr;
        delete temp;
    }

    void peek() const {
        if (!front) std::cout << "the queue is empty\n";
        else std::cout << front->data << "\n";
    }

    void display() const {
        for (QueueNode* cur = front; cur; cur = cur->next) std::cout << cur->data << " ";
        std::cout << "\n";
    }
};

int main() {
    Queue q;
    for (int v : {2, 5, 38, 44, 73, 105, 225, 515}) q.enqueue(v);

    q.dequeue();

    q.enqueue(30);
    q.enqueue(10);

    q.dequeue();
    q.enqueue(838);
    q.enqueue(586);

    q.display();
    return 0;
}
