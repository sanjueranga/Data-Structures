
public class LinkedList {

    Node head;
    Node tail;

    LinkedList() {
        this.head = null;
        this.tail = null;

    }

    public void insertItem(String uid, String itemName, int itemUnitPrice) {
        Item item = new Item(uid, itemName, itemUnitPrice);
        Node newNode = new Node(item);
        if (head == null) {
            head = newNode;
            tail = newNode;

        } else {
            if (searchItem(uid, itemName) != null) {
                this.searchItem(uid, itemName).data.upQuantity();

            } else {
                tail.next = newNode;
                tail = newNode;

            }

        }
    }

    public void insertItem(String uid, String itemName, int itemUnitPrice, int quantitiy) {
        Item item = new Item(uid, itemName, itemUnitPrice, quantitiy);
        Node newNode = new Node(item);
        if (head == null) {
            head = newNode;
            tail = newNode;

        } else {

            tail.next = newNode;
            tail = newNode;

        }

    }

    public boolean nodeExists(String uid, String itemname) {
        Node current = head;
        while (current != null) {
            if (current.data.getItemName() == itemname) {
                return true;
            }
            current = current.next;

        }
        return false;
    }

    public Node searchItem(String uid, String itemname) {
        Node current = head;
        if (nodeExists(uid, itemname)) {
            while (current != null) {

                if (current.data.getItemName().equals(itemname) && current.data.getUserId().equals(uid)) {

                    return current;
                }
                current = current.next;
            }

        }
        return null;

    }

    // to decrease

    void updateQuantity(String uid, String item) {

        searchItem(uid, item).data.downQuantitiy();
    }

    /*
     * we can increase the quantity by adding a new item
     * or
     * 
     * void increaseQuantity(String uid, String item){
     * 
     * searchItem(uid, item).data.upQuantitiy();
     * }
     * 
     * 
     */

    void removeItem(String uid, String item) {
        Node temp = head, prev = null;
        if (temp == searchItem(uid, item)) {
            head = temp.next;
            return;
        }
        while (temp != searchItem(uid, item)) {
            prev = temp;
            temp = temp.next;
        }
        if (temp == null) {
            return;
        }

        prev.next = temp.next;

    }

    public LinkedList filterByUser(String uid) {

        Node temp = head;
        LinkedList user = new LinkedList();

        while (temp != null) {
            if (temp.data.getUserId().equals(uid)) {
                user.insertItem(temp.data.getUserId(), temp.data.getItemName(), temp.data.getItemUnitPrice(),
                        temp.data.getQuantitiy());

            }

            temp = temp.next;

        }

        return user;

    }

    public void printUser(String uid) {

        LinkedList user = filterByUser(uid);

        System.out.println("User ID : " + uid);

        Node temp = user.head;

        int i = 1;
        while (temp != null) {
            System.out.println(i + ".");
            System.out.println("Item Name : " + temp.data.getItemName());
            System.out.println("Item Price : " + temp.data.getItemUnitPrice());
            System.out.println("Item Quantity : " + temp.data.getQuantitiy());

            temp = temp.next;
            i++;
        }

    }

    public void calTheBill(String uid) {
        LinkedList user = filterByUser(uid);
        Node temp = user.head;
        int total = 0;
        while (temp != null) {
            total += temp.data.getItemUnitPrice() * temp.data.getQuantitiy();
            temp = temp.next;

        }
        System.out.println("Total Price : " + total);

    }

}
