public class task2{

  public static void main(String args[]){
  
    int A[][] = {{ 2,5,8},{4,8,3},{ 9,1,6}};
    int B[][] = {{1,7,9},{6,4,5},{2,8,3}};
    int C[][] = new int[3][3];
    
    for ( int i = 0 ; i< 3;i++){
      for ( int j = 0 ; j<3 ; j++){
      	int t = 0;
      	for ( int k = 0 ; k<3 ; k++){
      	
      		t = A[i][k]*B[k][j] +t;
      	}
      	C[i][j] = t;
      }
      
      
      
    }
    

    for (int a =0; a<3;a++){
    
    	for (int b =0; b<3;b++){
    	
    	System.out.print(C[a][b]);
    	System.out.print(" ");
    	
    	}
    	System.out.println("");
    }
  }
}
