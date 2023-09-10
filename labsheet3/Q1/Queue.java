class Queue{
  
  QueueNode front;
  QueueNode rear;
  // Enqueue Function
  
   void enqueue(int data){
    QueueNode newNode = new QueueNode(data);
    
    if(this.front == null){
      this.front = this.rear = newNode;
      return;
    }else{
      rear.next = newNode;
      rear = newNode;
    }
  }
  
  //Dequeue Function 
  
  void dequeue(){
    if(this.front == null){
      return;
    }
    QueueNode temp = this.front;
    System.out.println(this.front.data);
    this.front = this.front.next;
    
    if(this.front== null){
      this.rear=null;
    }
  }

// peek 

  void peek(){
  
    if(this.front == null){
      System.out.println("the queue is empty");
    }
    else{
      System.out.print(this.front.data);
    }
  }
  
  // Display
  
  void display(){
    QueueNode temp = this.front;
    while(temp != null){
      System.out.print(temp.data+" ");
      temp = temp.next;
    }
     
  }
  
  
}


