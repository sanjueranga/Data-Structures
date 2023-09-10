class LinkedList {

  Node head;
  Node tail;

  LinkedList() {
    this.head = null;
    this.tail = null;

  }

  public void insert(int new_data) {
    Node new_node = new Node(new_data);

    if (head == null) {
      head = new_node;
      tail = new_node;
    } else {
      tail.next = new_node;
      tail = new_node;
    }

  }

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

  public Node search(int x) {
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

  void remove(int data) {

    Node temp = head, prev = null;
    if (temp == search(data)) {
      head = temp.next;
      return;
    }
    while (temp != search(data)) {
      prev = temp;
      temp = temp.next;

    }
    if (temp == null) {
      return;
    }
    prev.next = temp.next;
  }

  void display() {
    Node temp = head;
    while (temp != null) {
      System.out.print(temp.data + " ");
      temp = temp.next;
    }
  }

}