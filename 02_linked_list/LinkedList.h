#pragma once

struct Node {
    int data;
    Node* next;
    Node(int val);
};

class LinkedList {
    private:
        Node* head;
        Node* tail;

    public:
        LinkedList();
        ~LinkedList();

        void append(int val);
        void printList();

};



