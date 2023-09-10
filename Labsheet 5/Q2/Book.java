package Q2;

public class Book {
    private String book_id;
    private String book_name;
    private String author;
    private int num_pages;
    private int ratings;

    public Book(String id, String name, String author, int pages, int ratings) {

        this.book_id = id;
        this.book_name = name;
        this.author = author;
        this.num_pages = pages;
        this.ratings = ratings;
    }

    public String getBook_id() {
        return book_id;
    }

    public String getAuthor() {
        return author;
    }

    public String getBook_name() {
        return book_name;
    }

    public int getNum_pages() {
        return num_pages;
    }

    public int getRatings() {
        return ratings;
    }
}
