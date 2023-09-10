import java.util.Scanner;

public class BookList {

    private String bookListName;
    public Book[] bookList = new Book[15];
    private int bookCount = 0;

    public BookList(String listname) {

        this.bookListName = listname;
    }

    Scanner sc = new Scanner(System.in);

    public String getListName() {
        return bookListName;
    }

//Adding a book
    public int AddBook(String name, String author, int rank) {

        bookList[bookCount] = new Book(name, author, rank);
        bookList[bookCount].setId(bookCount + 1);
        bookCount++;
        return bookCount;
    }
//Deleting book
    public int DeleteBook(int id) {

        for (int i = id; i <= bookCount - 1; i++) {
            if (i == 15) {
                bookList[14] = null;
                break;
            }
            bookList[i - 1] = bookList[i];
            bookList[i - 1].setId(i);

        }

        bookCount--;
        return bookCount;
    }
//Display book list
    public void DisplayList() {
        System.out.println("ID" + "\tName" + "\t\tAuthor(s)" + "\tRank" + "\tStatus");
        for (int l = 0; l <= bookCount - 1; l++) {

            System.out.println(bookList[l].getId() + "\t" + bookList[l].getName() + "\t\t" + bookList[l].getAuthor()
                    + "\t" + bookList[l].getRank() + "\t"
                    + bookList[l].getStatus());
        }
    }
    
  // DIspalying a book by name

    public void DisplayBook(String name) {
        for (Book book : bookList) {
            if (book.getName() == name) {
                if (book != null) {
                    System.out.println("ID : " + "\t" + book.getId());
                    System.out.println("Name : " + "\t" + book.getName());
                    System.out.println("Author : " + "\t" + book.getAuthor());
                    System.out.println("Rank : " + "\t" + book.getRank());
                    System.out.println("Status : " + "\t" + book.getStatus());
                }
            }
        }
    }
// search a book
    public Book searchBook(String name) {
        for (Book book : bookList) {
            if (book.getName() == name) {
                return book;
            }
        }
        return null;

    }
//To modify
    public void ModifyBook(String name) {
        for (Book book : bookList) {
            if (book.getName() == name) {
                System.out.println("Select Option");
                System.out.println("1. Modify Name");
                System.out.println("2. Modify Author(s)");
                System.out.println("3. Modify Rank");
                System.out.println("4. Modify Status");
                int choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("Enter new name");
                        String new_name = sc.nextLine();
                        book.setName(new_name);
                        break;

                    case 2:
                        System.out.println("Enter Authors");
                        String author_1 = sc.nextLine();
                        book.setAuthor(author_1);
                        break;
                    case 3:
                        System.out.println("Enter Authors");
                        int rnk = sc.nextInt();
                        book.setRank(rnk);
                        break;
                    case 4:
                        System.out.print("Enter Status");
                        System.out.println("ALREADY_READ , READING, TO_BE_READ ");
                        String stts = sc.nextLine();
                        book.setStatus(stts);
                        break;

                    default:
                        System.out.println("Invalid input");
                        break;
                }
            }
        }
    }
    
    
    //Get current reading book

    public void getCurrentBook() {
        for (Book book : bookList) {
            if (book.getStatus() == "READING") {
                System.out.println("ID : " + "\t" + book.getId());
                System.out.println("Name : " + "\t" + book.getName());
                System.out.println("Author : " + "\t" + book.getAuthor());
                System.out.println("Rank : " + "\t" + book.getRank());
                System.out.println("Status : " + "\t" + book.getStatus());
            }
        }
    }
    
    //Sort

    public void sortByRank() {

        for (int j = 0; j < bookCount - 1; j++) {
            for (int k = 0; k < bookCount - 1; k++) {

                if (bookList[j].getRank() < bookList[k].getRank()) {
                    Book temp = bookList[j];
                    bookList[j] = bookList[k];

                    bookList[k] = temp;

                }
            }

        }
        //printing Sorted array
        Book[] sorted = bookList;
        System.out.println("ID" + "\tName" + "\t\tAuthor(s)" + "\tRank" + "\tStatus");
        for (int l = 0; l <= bookCount - 1; l++) {
            sorted[l].setId(l + 1);
            System.out.println(sorted[l].getId() + "\t" + sorted[l].getName() + "\t\t" + sorted[l].getAuthor() + "\t"
                    + sorted[l].getRank() + "\t" + sorted[l].getStatus());
        }

    }

}
