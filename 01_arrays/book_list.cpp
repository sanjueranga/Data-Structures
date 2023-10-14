// A book list backed by a fixed-size array of Book pointers.
#include <iostream>
#include <string>

enum class Status { ALREADY_READ, READING, TO_BE_READ };

static std::string statusName(Status s) {
    switch (s) {
        case Status::ALREADY_READ: return "ALREADY_READ";
        case Status::READING: return "READING";
        default: return "TO_BE_READ";
    }
}

class Book {
    int id = 0;
    std::string name;
    std::string author;
    int rank = 0;
    Status status = Status::TO_BE_READ;

public:
    Book(const std::string& name, const std::string& author, int rank)
        : name(name), author(author), rank(rank) {}

    void setId(int v) { id = v; }
    int getId() const { return id; }
    void setName(const std::string& v) { name = v; }
    const std::string& getName() const { return name; }
    void setAuthor(const std::string& v) { author = v; }
    const std::string& getAuthor() const { return author; }
    void setRank(int v) { rank = v; }
    int getRank() const { return rank; }
    Status getStatus() const { return status; }

    void setStatus(const std::string& s) {
        if (s == "ALREADY_READ") status = Status::ALREADY_READ;
        else if (s == "READING") status = Status::READING;
        else if (s == "TO_BE_READ") status = Status::TO_BE_READ;
    }
};

class BookList {
    static const int CAPACITY = 15;
    std::string listName;
    Book* books[CAPACITY] = {nullptr};
    int count = 0;

    static void printHeader() {
        std::cout << "ID\tName\t\tAuthor(s)\tRank\tStatus\n";
    }

    static void printRow(const Book& b) {
        std::cout << b.getId() << "\t" << b.getName() << "\t\t" << b.getAuthor() << "\t"
                  << b.getRank() << "\t" << statusName(b.getStatus()) << "\n";
    }

public:
    explicit BookList(const std::string& name) : listName(name) {}

    ~BookList() {
        for (int i = 0; i < count; i++) delete books[i];
    }

    BookList(const BookList&) = delete;
    BookList& operator=(const BookList&) = delete;

    const std::string& getListName() const { return listName; }

    int addBook(const std::string& name, const std::string& author, int rank) {
        if (count == CAPACITY) {
            std::cout << "List is full\n";
            return count;
        }
        books[count] = new Book(name, author, rank);
        books[count]->setId(count + 1);
        count++;
        return count;
    }

    int deleteBook(int id) {
        if (id < 1 || id > count) return count;
        delete books[id - 1];
        for (int i = id; i < count; i++) {
            books[i - 1] = books[i];
            books[i - 1]->setId(i);
        }
        books[count - 1] = nullptr;
        count--;
        return count;
    }

    void displayList() const {
        printHeader();
        for (int i = 0; i < count; i++) printRow(*books[i]);
    }

    Book* searchBook(const std::string& name) const {
        for (int i = 0; i < count; i++) {
            if (books[i]->getName() == name) return books[i];
        }
        return nullptr;
    }

    void displayBook(const std::string& name) const {
        const Book* b = searchBook(name);
        if (!b) return;
        std::cout << "ID : \t" << b->getId() << "\n";
        std::cout << "Name : \t" << b->getName() << "\n";
        std::cout << "Author : \t" << b->getAuthor() << "\n";
        std::cout << "Rank : \t" << b->getRank() << "\n";
        std::cout << "Status : \t" << statusName(b->getStatus()) << "\n";
    }

    void modifyBook(const std::string& name) {
        Book* b = searchBook(name);
        if (!b) return;
        std::cout << "Select Option\n1. Modify Name\n2. Modify Author(s)\n"
                     "3. Modify Rank\n4. Modify Status\n";
        int choice;
        std::cin >> choice;
        std::cin.ignore();
        std::string text;
        switch (choice) {
            case 1:
                std::cout << "Enter new name\n";
                std::getline(std::cin, text);
                b->setName(text);
                break;
            case 2:
                std::cout << "Enter Authors\n";
                std::getline(std::cin, text);
                b->setAuthor(text);
                break;
            case 3: {
                std::cout << "Enter new rank\n";
                int rank;
                std::cin >> rank;
                b->setRank(rank);
                break;
            }
            case 4:
                std::cout << "Enter Status (ALREADY_READ, READING, TO_BE_READ)\n";
                std::getline(std::cin, text);
                b->setStatus(text);
                break;
            default:
                std::cout << "Invalid input\n";
        }
    }

    void displayCurrentBook() const {
        for (int i = 0; i < count; i++) {
            if (books[i]->getStatus() == Status::READING) displayBook(books[i]->getName());
        }
    }

    // Bubble sort by rank (ascending), then renumber the ids.
    void sortByRank() {
        for (int pass = 0; pass < count - 1; pass++) {
            for (int j = 0; j < count - 1 - pass; j++) {
                if (books[j]->getRank() > books[j + 1]->getRank()) {
                    Book* tmp = books[j];
                    books[j] = books[j + 1];
                    books[j + 1] = tmp;
                }
            }
        }
        for (int i = 0; i < count; i++) books[i]->setId(i + 1);
        displayList();
    }
};

int main() {
    BookList myBooks("My Booklist");

    myBooks.addBook("Uncanny Valley", "Anna Wiener", 10);
    myBooks.addBook("Weather", "Jenny Offil", 4);
    myBooks.addBook("Long Bright River", "Liz Moore", 18);
    myBooks.addBook("The Glass Hotel", "Emily St & John Mandel", 2);
    myBooks.addBook("Afterlife", "Julia Alvarez", 14);

    myBooks.searchBook("Long Bright River")->setRank(1);
    myBooks.searchBook("Afterlife")->setStatus("READING");

    myBooks.displayList();

    std::cout << "##################################\n\n";
    myBooks.sortByRank();

    std::cout << "##################################\n\n";
    myBooks.deleteBook(3);
    myBooks.displayList();
    return 0;
}
