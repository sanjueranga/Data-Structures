class LinkedList {

  Node head; // head of the list
  Node tail; // tail of the list

  // creating an empty linked list
  LinkedList() {
    this.head = null;
    this.tail = null;

  }

  // Insert Front

  public void insertFront(int new_data) {

    Node new_node = new Node(new_data);

    if (head == null) {
      head = new_node;
      tail = new_node;
    } else {
      new_node.next = head;
      head = new_node;
    }

  }

  // Insert Rear

  public void insertRear(int new_data) {
    Node new_node = new Node(new_data);

    if (head == null) {
      head = new_node;
      tail = new_node;
    } else {
      tail.next = new_node;
      tail = new_node;
    }
  }
  // Insert next

  public void insertNext(Node prev_node, int new_data) {

    if (prev_node == null) {
      System.out.println("The given previous node cannot be null");
    } else {

      Node new_node = new Node(new_data);
      new_node.next = prev_node.next;
      prev_node.next = new_node;

    }
  }

  // Existance

  public boolean nodeExists(Node head, int x) {
    Node current = head;
    while (current != null) {

      if (current.data == x) {
        return true;
      }
      current = current.next;

    }
    return false;

  }

  // Search

  public Node search(Node head, int x) {
    Node current = head;
    if (nodeExists(current, x) == true) {
      while (current != null) {
        if (current.data == x) {
          return current;
        }
        current = current.next;
      }

    } else {
      return null;
    }
    return null;
  }

  // Display
  public void display() {
    Node temp = head;

    while (temp != null) {
      System.out.print(temp.data + " ");

      temp = temp.next;
    }
    System.out.println();
  }

  // Delete

  void Delete(int key) {

    Node temp = head, prev = null;

    if (temp != null && temp.data == key) {
      head = temp.next;

      return;
    }

    while (temp != null && temp.data != key) {
      prev = temp;
      temp = temp.next;
    }

    if (temp == null)
      return;
    if (temp == this.tail) {
      this.tail = prev;
    }
    prev.next = temp.next;
  }

}
