public class Driver {
    public static void main(String[] args) {

        BookList My_Booklist = new BookList("My Booklist");

        My_Booklist.AddBook("Uncanny Valley", "Anna Wiener", 10);
        My_Booklist.AddBook("Weather", "Jenny Offil", 4);
        My_Booklist.AddBook("Long Bright River", "Liz Moore", 18);
        My_Booklist.AddBook("The Glass Hotel", "Emily St & John Mandel", 2);
        My_Booklist.AddBook("Afterlife", "Julia Alvarez", 14);

        My_Booklist.searchBook("Long Bright River").setRank(1);

        My_Booklist.searchBook("Afterlife").setStatus("READING");

        My_Booklist.DisplayList();

        System.out.println("##################################");
        System.out.println("");
        My_Booklist.sortByRank();

        System.out.println("##################################");
        System.out.println("");

        My_Booklist.DeleteBook(3);
        My_Booklist.DisplayList();

    }
}
