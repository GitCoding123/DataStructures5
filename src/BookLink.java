public class BookLink {
	String name; 
	long population; 
	long deaths; 
	BookLink nextBookLink; 
	 
	public BookLink(String name, long population, long deaths) { 
		this.name = name; 
		this.population = population; 
		this.deaths = deaths; 
	} 
	
	public int getKey() {
		int key;
		int sum = 0;
		
		for (int i = 0; i < name.length(); i++) {
			sum += (name.charAt(i));
		}
		
		key = sum % 101;
		return key;
	}
	
	public void printNode() { 
		System.out.printf("%-30s %-20.2f\n", name, (double)deaths/population*100000); 
	} 

}
