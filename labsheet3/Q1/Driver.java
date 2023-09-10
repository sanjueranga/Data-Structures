class Driver{
  public static void main( String []args){
    
  Queue q = new Queue();
  //1
  q.enqueue(2);
  q.enqueue(5);
  q.enqueue(38);
  q.enqueue(44);
  q.enqueue(73);
  q.enqueue(105);
  q.enqueue(225);
  q.enqueue(515);
  

 //2
  
  q.dequeue();
 
  
  //3
  q.enqueue(30);
  q.enqueue(10);
  
  //4 

  q.dequeue();
  
  
  q.enqueue(838);
  q.enqueue(586);
  
  //5
 
  q.display();
  
  
  
  
  
    
  }

}
