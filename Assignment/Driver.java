public class Driver {
    public static void main(String[] args) {

        LinkedList browser_history = new LinkedList();

        browser_history.insert(new History("YouTube", "001A", "10.08.2020", "https://www.youtube.com/", false));
        browser_history
                .insert(new History("GeeksforGeeks", "011B", "19.08.2020", "https://www.geeksforgeeks.org/", true));
        browser_history.insert(
                new History("Tutorialspoint", "012C", "06.08.2020", "https://www.tutorialspoint.com/index.htm", true));
        browser_history.insert(new History("Stackoverflow", "003D", "05.08.2020", "https://stackoverflow.com/", false));

        browser_history.display();
        System.out.println("");

        // browser_history.displayReverse();
        browser_history.delete("Stackoverflow");
        browser_history.display();

        // browser_history.displayBookmarked();

    }
}
