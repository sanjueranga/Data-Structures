package Q2;

public class HashTable {
    private static final int SIZE_OF_ARRAY = 10;
    private LinkedList indexes[] = new LinkedList[SIZE_OF_ARRAY];

    public int hashCode(String author) {
        int ascii = 0;
        for (int i = 0; i < author.length(); i++) {

            ascii = author.charAt(i) + ascii;

        }
        return ascii % SIZE_OF_ARRAY;
    }

    public void Insert(Book book) {
        int index = hashCode(book.getAuthor());

        if (indexes[index] == null) {

            LinkedList list = new LinkedList();
            indexes[index] = list;
            list.insertRear(book);
        } else {
            LinkedList temp = indexes[index];
            temp.insertRear(book);

        }
    }

    public Book retrive(String author) {
        int index = hashCode(author);
        return indexes[index].searchLinkedList(author).data;

    }

    public void Display() {

        for (int i = 0; i < SIZE_OF_ARRAY; i++) {
            if (indexes[i] != null) {

                indexes[i].displayList();
                System.out.println("");

            }
        }

    }

}
