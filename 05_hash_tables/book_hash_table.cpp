// Hash table of books keyed by author (sum of character codes mod table size).
#include <iostream>
#include <string>

struct Book {
    std::string id;
    std::string name;
    std::string author;
    int pages;
    int ratings;
};

struct Node {
    Book data;
    Node* next = nullptr;
    explicit Node(const Book& b) : data(b) {}
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

    void insertRear(const Book& book) {
        Node* node = new Node(book);
        if (!head) head = tail = node;
        else {
            tail->next = node;
            tail = node;
        }
    }

    // Unlinks the first book by this author and returns it; false if none.
    bool removeByAuthor(const std::string& author, Book& out) {
        Node* prev = nullptr;
        Node* cur = head;
        while (cur && cur->data.author != author) {
            prev = cur;
            cur = cur->next;
        }
        if (!cur) return false;

        out = cur->data;
        if (prev) prev->next = cur->next;
        else head = cur->next;
        if (cur == tail) tail = prev;
        delete cur;
        return true;
    }

    void display() const {
        for (Node* cur = head; cur; cur = cur->next) {
            const Book& b = cur->data;
            std::cout << "\t" << b.id << "," << b.name << "," << b.author << ","
                      << b.pages << "," << b.ratings << "\n";
        }
    }
};

class HashTable {
    static const int SIZE = 10;
    LinkedList* buckets[SIZE] = {nullptr};

    static int hashCode(const std::string& author) {
        int sum = 0;
        for (char c : author) sum += c;
        return sum % SIZE;
    }

public:
    HashTable() = default;
    HashTable(const HashTable&) = delete;
    HashTable& operator=(const HashTable&) = delete;

    ~HashTable() {
        for (LinkedList* b : buckets) delete b;
    }

    void insert(const Book& book) {
        int index = hashCode(book.author);
        if (!buckets[index]) buckets[index] = new LinkedList();
        buckets[index]->insertRear(book);
    }

    bool retrieve(const std::string& author, Book& out) {
        LinkedList* bucket = buckets[hashCode(author)];
        return bucket && bucket->removeByAuthor(author, out);
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
    table.insert({"B01", "Harry Potter", "Rowling", 652, 2095690});
    table.insert({"B02", "The Lost Continent", "Bryson", 299, 45712});
    table.insert({"B03", "The Lord of the Rings", "Tolkein", 1184, 1710});
    table.insert({"B04", "Notes from a Small Island", "Bryson", 324, 80609});
    table.insert({"B05", "The Changeling Sea ", "Patricia", 137, 4454});
    table.insert({"B06", "Heirs of General Practice", "McPhee", 128, 268});
    table.insert({"B07", "Salmon of Doubt", "Douglas", 336, 5});
    table.insert({"B08", "For the New Intellectual", "Rand", 224, 2750});
    table.insert({"B09", "City of Glass", "Auster", 203, 12410});
    table.insert({"B10", "A War Like No Other", "Davis", 397, 1693});

    table.display();

    Book found;
    if (!table.retrieve("Tolkein", found)) std::cout << "Author not found\n";
    std::cout << "******************************\n";
    table.display();
    return 0;
}
