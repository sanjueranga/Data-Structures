#include "LinkedList.h"
#include <iostream>

Node::Node(int val) {
    data = val;
    next = nullptr;
}

LinkedList::LinkedList() {
    head = nullptr;
    tail = nullptr;
}

void LinkedList::append(int val) {
    Node* newNode = new Node(val);

    if (head == nullptr) {
        head = newNode;
        tail = newNode;
    } else {
        tail->next = newNode;
        tail = newNode;
    }

}


void LinkedList::printList() {
    Node* current = head;
    while (current != nullptr) {
        std::cout << current->data << " -> ";
        current = current->next;
    }
    std::cout << "nullptr\n";
}

  LinkedList::~LinkedList() {
    Node* current = head;
    while (current != nullptr) {
        Node* nextNode = current->next;
        delete current;
        current = nextNode;
    }
}