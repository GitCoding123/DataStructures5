
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * COP 3530: Project 5 – Hash Table
 * <p>
 * The Project5 class reads in a file containing states and covid-related information creating state objects, then 
 * inserts them into linked lists within the hash table.
 * 
 * @author Brian Gerkens
 * @version 11/10/2021
 */
public class Project5 {	
	/**
	 * default constructor for Project5
	 */
	public Project5() {
		
	}
	/**
	 * main method for Project5 class.
	 */
	public static void main(String[] args) {
		
		String line = "";
		boolean running = true;
		Scanner scan = new Scanner(System.in);
		Scanner scan2 = new Scanner(System.in);
		Scanner scan3 = new Scanner(System.in);
		Scanner scan4 = new Scanner(System.in);
		Scanner scan5 = new Scanner(System.in);
		BufferedReader br = null;
		
		HashTable ht = new HashTable();
				
		State state = null; 			//states read from file
		
		printHeader();
		System.out.println("Enter the file name: ");
		
		while(running) {
			String fileName = scan.next();
			try {
				br = new BufferedReader(new FileReader(fileName));
					
				String headLine = br.readLine();
				while((line = br.readLine()) != null) {
							
					String[] data = line.split(",");
					//parse data from file
					String name = data[0];
					String capitol = data[1];
					String region = data[2];
					int usHouseSeats = Integer.parseInt(data[3]);
					long population = Long.parseLong(data[4]);
					long covidCases = Long.parseLong(data[5]);
					long covidDeaths = Long.parseLong(data[6]);
					int income = Integer.parseInt(data[7]);
					double crimeRate = Double.parseDouble(data[8]);
					long CFR = covidCases / covidDeaths;
					long caseRate = covidCases / population * 100000;
					long deathRate = covidDeaths / population * 100000;
					
					state = new State(name, capitol, region, usHouseSeats, population,					//Create state objects from file, line by line.
							covidCases, covidDeaths, income, crimeRate, CFR, caseRate, deathRate);
					
					//link = new BookLink(state.getName(), state.getPopulation(), state.getCovidDeaths());
					
					ht.insert(state.getName(), state.getPopulation(), state.getCovidDeaths());
					
					//ht.hashFunction(state.getName());
					
					//ht.insert(state.getName(), state.getPopulation(), state.getCovidDeaths());
					
				}
				running = false;			//end main while loop		
			}
			catch (FileNotFoundException e) {
				System.out.println("YIKES!!! Incorrect file name. Please try again.\nEnter the file name: ");
			}
			catch(IOException e) {
				e.printStackTrace();
			}
		}
	
		
		System.out.println("\nThere were 50 records read into the hash table.\n ");	
		
		running = true;
		int menuNumber = 0;
		while(running) {
			printMenu();
			try {
				menuNumber = scan.nextInt();
			}
			catch(InputMismatchException e) {
				printError();
				scan.reset();
				scan.next();
				continue;
			}
			if(menuNumber == 1) {
			//Print hash table.
				ht.display();
				System.out.println("");
				continue;
			}
			else if(menuNumber == 2) {
			//Delete state of a given name.
				System.out.println("Enter name of state to delete: ");
				String stateName = scan2.nextLine();
				int val = ht.find(stateName);
				
				if (val == -1) {
					System.out.println(stateName + " cannot be found in the hash table.");
					System.out.println("");
					continue;
				}
				else {
					ht.delete(stateName);
					System.out.println(stateName + " has been deleted from the hash table.");
				}
				
				continue;
			}
			else if(menuNumber == 3) {
			//Insert state of a given name.
				
				String stateName;
				long pop;
				long covD;
				
				System.out.println("Enter name of state to insert: ");
				stateName = scan3.nextLine();
				System.out.println("Enter state population: ");
				try {
					pop = scan4.nextLong();
				}
				catch (InputMismatchException e) {
					printError();
					scan4.reset();
					scan4.next();
					continue;
				}
				System.out.println("Enter state COVID deaths: ");
				try {
					covD = scan4.nextLong();
				}
				catch (InputMismatchException e) {
					printError();
					scan4.reset();
					scan4.next();
					continue;
				}
				ht.insert(stateName, pop, covD);
			}
			else if(menuNumber == 4) {
			//Search and print a state and its DR for given name.
				System.out.println("Enter a state name: ");
				String stateName = scan5.nextLine();
				double DR;
				int val = ht.find(stateName);
				int key = ht.getKey(stateName);
				
				if (val == -1) {
					System.out.println(val);
					System.out.println(stateName + " cannot be found in the hash table.");
					System.out.println("");
					continue;
				}
				else {
					
					
					DR = ht.findDR(val, key);
//					if(state.getName() == stateName) {
//						DR = state.getDeathRate();
//					}
					System.out.println(stateName + " is found at index " + val + " with a DR of " + DR + ".");
					System.out.println();
					continue;
				}
				
//				node = null;
//				node = ht.getFindNode(key);
				
			}
			else if(menuNumber == 5) {
			//Print numbers of empty and collided cells.
				ht.printEmptyAndCollidedCells();
				continue;
			}
			else if(menuNumber == 6) {
				//Exit
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				System.out.println("File closed.\nProgram terminated.\nHave a nice day!");
				scan.close();
				scan2.close();
				scan3.close();
				scan4.close();
				scan5.close();
				running = false;
			}

			else {
				System.out.println("\nERROR!!!\nInvalid number. Please try again: \n");
			}	
		}
	}
	
	/**
	 * the printHeader method prints the header for project 4.
	 */
	public static void printHeader() {
		System.out.println("COP3530 Project 5\nInstructor: Xudong Liu\n");
		System.out.println("Hash Table");
	}
	
	/**
	 * The printMenu() method prints the menu to the user with options 1-8.
	 */
	public static void printMenu() {
		System.out.println("1.) Print hash table.\n2.) Delete a state of a given name.\n3.) Insert a state of its name, population, and COVID deaths.");
		System.out.println("4.) Search and print a state and its DR for a given name.\n5.) Print numbers of empty and collided cells.");
		System.out.println("6.) Exit\nPlease enter your choice: \n");
	}
	
	/**
	 * printError() method prints an error method if an invalid option is
	 * chosen from the number menu.
	 */
	public static void printError() {
		System.out.println("\nERROR!!!   Invalid option.\nPlease enter a number from the menu: \n");
	}
}
