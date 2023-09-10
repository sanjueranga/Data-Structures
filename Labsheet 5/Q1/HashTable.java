class HashTable {
  private static final int SIZE_OF_ARRAY = 10;


  LinkedList[] indexes = new LinkedList[10];

  public int hashCode(int data) {

    return data % SIZE_OF_ARRAY;
  }



  public void insert(int data) {
    int index = hashCode(data);

    if (indexes[index] == null) {
      LinkedList newList = new LinkedList();
      indexes[index] = newList;
      newList.insert(data);

    } else {
      LinkedList temp = indexes[index];
      temp.insert(data);

    }

  }

  public void retrive(int data) {

    int index = hashCode(data);
    if (indexes[index] == null) {
      System.out.println("Item Not Found");
    } else {
      indexes[index].remove(data);
    }

  }

  public void Display() {

    for (int i = 0; i < SIZE_OF_ARRAY; i++) {

      LinkedList temp = indexes[i];
      if (temp != null) {
        temp.display();
        System.out.println("");
      }
    }

  }

}
