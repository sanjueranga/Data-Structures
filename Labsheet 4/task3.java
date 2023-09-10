public class task3{


public static void main(String args[]){

	String names[][] = {{"Cargils","100000"}, {"Uniion Bank","300000"},{"Laugh Gas","200000"}, {"Odel","400000"}, {"Melstacorp","600000"},{"Kingsbury","150000"},{"Hemas","250000"},{"Brandix","450000"}};
	
	String revised[][] = new String[7][2];
	//String sorted[][] = new String[7][2];
	
	
	int t =0;
	for(int i =0; i<8; i++){
		
		if(names[i][0] != "Melstacorp"){
			revised[t][0]= names[i][0];
			
			revised[t][1] = names[i][1];
			t++;
			
		}
	}
	
		
	String[] temp = revised[1];	
	for (int i = 0; i <7; i++) {     
          for (int j = i+1; j <7; j++) {  
          	
          	Integer a = Integer.valueOf(revised[i][1]);
          	Integer b = Integer.valueOf(revised[j][1]);
          	
          	if(a>b){
          		temp= revised[i];
          		revised[i] = revised[j];
          		revised[j]= temp; 
          	}
          	
            }     
        }  

	
	
	
	
	for(int j = 0 ; j<7;j++){
		
		System.out.println(revised[j][0]+":"+ revised[j][1]);
	}
	
	

	
	
	
	
	
	

}

}
	
