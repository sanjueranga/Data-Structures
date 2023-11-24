// Browser history kept as a linked list (newest first) with a stack for reverse display.
#include <iostream>
#include <stack>
#include <string>

struct History {
    std::string pageName;
    std::string pageId;
    std::string date;
    std::string url;
    bool bookmark;
};

struct Node {
    History data;
    Node* next = nullptr;
    explicit Node(const History& h) : data(h) {}
};

class LinkedList {
    Node* head = nullptr;

    static void print(const History& h) {
        std::cout << h.pageName << " | " << h.pageId << " | " << h.date << " | " << h.url
                  << " | " << (h.bookmark ? "true" : "false") << " | \n";
    }

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

    // New pages go to the front so the newest visit is shown first.
    void insert(const History& h) {
        Node* node = new Node(h);
        node->next = head;
        head = node;
    }

    void display() const {
        for (Node* cur = head; cur; cur = cur->next) print(cur->data);
    }

    void displayReverse() const {
        std::stack<const Node*> pending;
        for (Node* cur = head; cur; cur = cur->next) pending.push(cur);
        while (!pending.empty()) {
            print(pending.top()->data);
            pending.pop();
        }
    }

    void remove(const std::string& name) {
        Node* prev = nullptr;
        Node* cur = head;
        while (cur && cur->data.pageName != name) {
            prev = cur;
            cur = cur->next;
        }
        if (!cur) return;

        if (prev) prev->next = cur->next;
        else head = cur->next;
        delete cur;
    }

    void displayBookmarked() const {
        for (Node* cur = head; cur; cur = cur->next) {
            if (cur->data.bookmark) print(cur->data);
        }
    }
};

int main() {
    LinkedList history;
    history.insert({"YouTube", "001A", "10.08.2020", "https://www.youtube.com/", false});
    history.insert({"GeeksforGeeks", "011B", "19.08.2020", "https://www.geeksforgeeks.org/", true});
    history.insert({"Tutorialspoint", "012C", "06.08.2020", "https://www.tutorialspoint.com/index.htm", true});
    history.insert({"Stackoverflow", "003D", "05.08.2020", "https://stackoverflow.com/", false});

    history.display();
    std::cout << "\n";

    history.remove("Stackoverflow");
    history.display();
    std::cout << "\n";

    history.displayReverse();
    std::cout << "\n";
    history.displayBookmarked();
    return 0;
}
