public class Driver {
    public static void main(String[] args) {
        LinkedList list1 = new LinkedList();

        list1.insertItem("user1", "Book", 100);

        list1.insertItem("user1", "pen", 200);
        list1.insertItem("user1", "pen", 200);
        list1.insertItem("user1", "bottle", 500);
        list1.insertItem("user1", "pen", 200);
        list1.insertItem("user2", "pencil", 400);
        list1.insertItem("user2", "Book", 100);
        list1.insertItem("user3", "bottle", 500);
        list1.insertItem("user3", "Book", 100);
        list1.insertItem("user1", "Book", 100);
        list1.insertItem("user1", "Book", 100);

        list1.printUser("user1");
        System.out.println("###############################");
        // remove Item completly

        list1.removeItem("user1", "pen");
        list1.printUser("user1");
        System.out.println("###############################");
        // decrease item count
        list1.updateQuantity("user1", "Book");

        list1.printUser("user1");
        System.out.println("###############################");

        list1.calTheBill("user1");

    }
}