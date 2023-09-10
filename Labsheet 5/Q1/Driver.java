class Driver {
  
  public static void main(String args[]){
  
    
    HashTable hashtable = new HashTable();
    
    hashtable.insert(5);
    hashtable.insert(10);
    hashtable.insert(20);
    hashtable.insert(1);
    hashtable.insert(0);
    hashtable.insert(100);
    hashtable.insert(13);
    hashtable.insert(21);
    
    
   hashtable.Display();
    
    hashtable.retrive(100);
    
    System.out.println("after deletion");
    hashtable.Display();


  }


}