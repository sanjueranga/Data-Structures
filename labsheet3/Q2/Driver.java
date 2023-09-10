class Driver{
  public static void main( String []args){
    
  Queue q = new Queue();
  
  
  q.enterForService("AB200","SUV","oil change");
  q.enterForService("CS250","Van","Body wash");
  q.enterForService("LK560","Jeep","full service");
  q.enterForService("NM301","Car","oil change");
  q.enterForService("LK900","SUV","Interior cleaning");
  
  //q.showQueue();
  
  //q.showQueue();
  
 // q.exitService();
  
 // q.showQueue();
  
  q.inLine("LK560");
  
  q.showQueue();
  q.exitService();
  
  System.out.println("++++++++++++++++++++++++++++++++++++++++");
  
  q.showQueue();
  
 
 
    
  }

}
