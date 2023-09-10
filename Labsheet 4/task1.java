public class task1{
  
  public static void main(String args[]){
  
    double datapoints[] = {2.5,19.7,8.95,11.0,28.4,7.11,4.16};
    double reversedArray[] = new double[7];
    int j = 0 ;
    for( int i = 6 ; i >= 0; i--){
     
        reversedArray[j] = datapoints[i];
        j++;
      
    }
    
    for ( int k = 0; k<=6; k++){
      System.out.println( reversedArray[k]);
    }
  }
}