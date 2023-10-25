// Shopping cart for several users, kept in one linked list of items.
#include <iostream>
#include <string>

class Item {
    std::string userId;
    std::string itemName;
    int unitPrice;
    int quantity;

public:
    Item(const std::string& uid, const std::string& name, int price, int qty = 1)
        : userId(uid), itemName(name), unitPrice(price), quantity(qty) {}

    void upQuantity() { quantity++; }
    void downQuantity() { quantity--; }
    const std::string& getUserId() const { return userId; }
    const std::string& getItemName() const { return itemName; }
    int getUnitPrice() const { return unitPrice; }
    int getQuantity() const { return quantity; }
};

struct Node {
    Item data;
    Node* next = nullptr;
    explicit Node(const Item& item) : data(item) {}
};

class LinkedList {
    Node* head = nullptr;
    Node* tail = nullptr;

    void append(const Item& item) {
        Node* node = new Node(item);
        if (!head) head = tail = node;
        else {
            tail->next = node;
            tail = node;
        }
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

    // Adds the item, or bumps the quantity if the user already has it.
    void insertItem(const std::string& uid, const std::string& name, int price) {
        if (Node* existing = searchItem(uid, name)) existing->data.upQuantity();
        else append(Item(uid, name, price));
    }

    Node* searchItem(const std::string& uid, const std::string& name) const {
        for (Node* cur = head; cur; cur = cur->next) {
            if (cur->data.getItemName() == name && cur->data.getUserId() == uid) return cur;
        }
        return nullptr;
    }

    // Decrease the quantity by one.
    void updateQuantity(const std::string& uid, const std::string& name) {
        if (Node* n = searchItem(uid, name)) n->data.downQuantity();
    }

    // Remove the item completely.
    void removeItem(const std::string& uid, const std::string& name) {
        Node* target = searchItem(uid, name);
        if (!target) return;

        Node* prev = nullptr;
        for (Node* cur = head; cur != target; cur = cur->next) prev = cur;

        if (prev) prev->next = target->next;
        else head = target->next;
        if (target == tail) tail = prev;
        delete target;
    }

    void printUser(const std::string& uid) const {
        std::cout << "User ID : " << uid << "\n";
        int i = 1;
        for (Node* cur = head; cur; cur = cur->next) {
            if (cur->data.getUserId() != uid) continue;
            std::cout << i << ".\n";
            std::cout << "Item Name : " << cur->data.getItemName() << "\n";
            std::cout << "Item Price : " << cur->data.getUnitPrice() << "\n";
            std::cout << "Item Quantity : " << cur->data.getQuantity() << "\n";
            i++;
        }
    }

    void calTheBill(const std::string& uid) const {
        int total = 0;
        for (Node* cur = head; cur; cur = cur->next) {
            if (cur->data.getUserId() == uid) {
                total += cur->data.getUnitPrice() * cur->data.getQuantity();
            }
        }
        std::cout << "Total Price : " << total << "\n";
    }
};

int main() {
    LinkedList list;

    list.insertItem("user1", "Book", 100);
    list.insertItem("user1", "pen", 200);
    list.insertItem("user1", "pen", 200);
    list.insertItem("user1", "bottle", 500);
    list.insertItem("user1", "pen", 200);
    list.insertItem("user2", "pencil", 400);
    list.insertItem("user2", "Book", 100);
    list.insertItem("user3", "bottle", 500);
    list.insertItem("user3", "Book", 100);
    list.insertItem("user1", "Book", 100);
    list.insertItem("user1", "Book", 100);

    list.printUser("user1");
    std::cout << "###############################\n";

    list.removeItem("user1", "pen");
    list.printUser("user1");
    std::cout << "###############################\n";

    list.updateQuantity("user1", "Book");
    list.printUser("user1");
    std::cout << "###############################\n";

    list.calTheBill("user1");
    return 0;
}
