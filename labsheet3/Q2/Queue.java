class Queue{
  
  QueueNode front;
  QueueNode rear;
  
  
  //inLine
  
  void inLine(String VIN){
  	QueueNode temp = this.front;
  	int i=0;
  	
  	String vin = temp.data.VIN;
  	
  	while((vin.equals(VIN)!=true)){
  	
  	i++;
  	temp = temp.next;
  	vin =temp.data.VIN;
  	
  	}
  	System.out.println("Number of vehicles to be serviced : " + i);
  }
  
  
  //enterForservice
  
  void enterForService(String VIN, String Vt,String St){
  		
  		Vehicle vehicle = new Vehicle(VIN,Vt,St);
  		
  		enqueue(vehicle);
  	
  }
  
  //exit
    void exitService(){
    if(this.front == null){
      return;
    }
    QueueNode temp = this.front;
    
    this.front = this.front.next;
    
    if(this.front== null){
      this.rear=null;
    }
  }

  
  
  
  
  
  
  
  
  // Enqueue Function
  
   void enqueue(Vehicle data){
    QueueNode newNode = new QueueNode(data);
    
    if(this.front == null){
      this.front = this.rear = newNode;
      return;
    }else{
      rear.next = newNode;
      rear = newNode;
    }
  }
  
  



  
  // Display
  
  void showQueue(){
    QueueNode temp = this.front;
    while(temp != null){
      Vehicle v = temp.data;
      
      System.out.println(" Vehicle Identification No: " + v.VIN);
      System.out.println(" Vehicle type : " + v.vType);
      System.out.println(" Service type : " + v.serviceType);
      
      
      temp = temp.next;
    }
     
  }
  
  
}


