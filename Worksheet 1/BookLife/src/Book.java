
public class Book {

    enum Status {
        ALREADY_READ,
        READING,
        TO_BE_READ
    }

    private int id;
    private String name;
    private String author;
    private int rank;
    private Status status = Status.TO_BE_READ;

    public Book() {

    }

    public Book(String name, String author, int rank) {
        this.rank = rank;
        this.name = name;
        this.author = author;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getRank() {
        return this.rank;
    }

    public void setStatus(String stts) {
        switch (stts) {
            case "ALREADY_READ":
                this.status = Status.ALREADY_READ;
                break;
            case "READING":
                this.status = Status.READING;
                break;
            case "TO_BE_READ":
                this.status = Status.TO_BE_READ;
                break;
        }
    }

    public String getStatus() {
        return this.status.name();
    }

}
