/**
 * This HashTable class possesses methods and classes
 * in which we can create an array of double-ended singly-linked lists.
 * 
 * @author Brian Gerkens
 * @version 12/10/2021
 */
public class HashTable {
	public SinglyLinkedList[] hashArray;
	
	private int arraySize = 101;
	public State nonState;
	SinglyLinkedList sll = new SinglyLinkedList();
	
	/**
	 * The private Node class contains all relevant information 
	 * to create a node for our singly linked lists.
	 * 
	 * @author bgerk
	 */
	private class Node {
		String name; 
		long population; 
		long deaths; 
		Node nextNode; 
		/**
		 * The Node constructor allows us to create a node that takes the given parameters.
		 * 
		 * @param name          this is the name of the state contained in the node
		 * @param population    this is the population of the state contained in the node
		 * @param deaths        this is the number of deaths of the state contained in the node
		 */
		public Node(String name, long population, long deaths) { 
			this.name = name; 
			this.population = population; 
			this.deaths = deaths; 
		} 
		/**
		 * 
		 */
		public void printNode() { 
			System.out.printf("%-30s %-20.2f\n", name, (double)deaths/population*100000); 
		 } 
	}
	
	/**
	 * The class SinglyLinkedList creates a list for our Nodes that will be incorporated
	 * hashArray.
	 * 
	 * @author bgerk
	 */
	public class SinglyLinkedList {
		
		private Node first;
		private Node last;
		
		/**
		 * Constructor for the singly linked list.
		 */
		public SinglyLinkedList() {
			first = null;
		}
		
		/**
		 * Insert method for inserting nodes into the END of the list.
		 * 
		 * @param node    Node to be inserted into the list.
		 */
		public void insertToList(Node node) {
			//Code for END insertion
			
			if(isEmpty()) {
				first = node;
			}
			else {
				last.nextNode = node;
			}
			last = node;
		}
		
		/**
		 * Method for 
		 * 
		 * @return    true if first == null, false if otherwise.
		 */
		public boolean isEmpty() {
			return first == null;
		}
		
		/**
		 * Method that deletes node from list.
		 * 
		 * @param key    used as a parameter to find which node we must delete
		 */
		public void deleteFromList(int key) {
			

			Node current = first;
			Node previous = first;
			while (true) {

				if(current.name == findNode(key).name) {
					//System.out.println(current.name + " has been deleted from the hash table.");
					first = first.nextNode;
					break;
				}
			
				else {
					previous = current;
					current = current.nextNode;
					if (current.name == findNode(key).name) {
						//System.out.println(current.name + " has been deleted from the hash table.");
						previous.nextNode = current.nextNode;		
					}
					else {
						continue;
					}
				}
			}
		}
		/**
		 * Method findNode will find a node in the preferred list within the hash index.
		 * 
		 * @param key      Used as a parameter to locate node in the list.
		 * @return current   Node to be returned.
		 */
		public Node findNode(int key) {
			Node current = first;

			while(current != null && getKey(current.name) <= key) {
				if(getKey(current.name) == key) {
					return current;
				}
				current = current.nextNode;
			}
			return current;
		}
		
		/**
		 * method displayList() will display the list
		 */
		public void displayList() {
			Node current = first;
			if (current == null) {
				System.out.println("Empty");
			}
				while (current != null) {
					current.printNode();
					current = current.nextNode;
				}
		}
		
		/**
		 * method getFirstNode() will return the first node of the chosen list.
		 * @return first     Node to be returned.
		 */
		public Node getFirstNode() {
			return first;
		}
	}
	
	/**
	 * Constructor for the HashTable class.
	 */
	public HashTable() {
		
		hashArray = new SinglyLinkedList[arraySize];
		for (int j = 0; j < arraySize; j++) {
			hashArray[j] = new SinglyLinkedList();
		}
		
	}
	/**
	 * insert() method will take parameters and insert them into a node and will
	 * pass that node to the insertToList() method.
	 * 
	 * @param state          Name of the node.
	 * @param population     Population of the node.
	 * @param deaths         Deaths of the node.
	 */
	public void insert(String state, long population, long deaths) {
		
		Node node = new Node(state, population, deaths);
		int key = getKey(state);
		int hashVal = hashFunction(key);
		hashArray[hashVal].insertToList(node);
	}
	/**
	 * find() method is used to search the linked list at the proper 
	 * position in the hash table for the state, and if found will return table index or -1 if not found
	 * 
	 * @param state        The state's name is used as a parameter. 
	 * @return hashVal     The hash value is returned
	 */
	public int find(String state) {
		int key = getKey(state);
		
		int hashVal = hashFunction(key);		
		if(hashArray[hashVal].findNode(key) == null) {
			return -1;
		}
		else {
			return hashVal;
		}
	} 
	
	/**
	 * delete() method is used to find and delete the state of the given 
	 * name from the hash table.
	 * 
	 * @param state   state name passed in through the parameter.
	 */
	public void delete(String state) {
		int key = getKey(state);
		int hashVal = hashFunction(key);
		hashArray[hashVal].deleteFromList(key);
	}
	
	/**
	 * display() method will iterate through each hash table index and print all lists
	 * for every non-empty index.
	 */
	public void display() {
		for (int j = 0; j < arraySize; j++) {			
			System.out.print(j + ". ");
			hashArray[j].displayList();
		}
	}
	
	/**
	 * printEmptyAndCollidedCells() method prints the number of 
	 * empty cells and the number of collided cells in the hash table array.
	 */
	public void printEmptyAndCollidedCells() {
		int x = 0;
		int y = 0;

		for(int i = 0; i < arraySize; i++) {
			if(hashArray[i].getFirstNode() == null) {
				x++;
			}
			else {
				if(hashArray[i].getFirstNode().nextNode != null) {
					y++;
				}
			}
			
		}
	
		System.out.println("There are " + x + " empty and " + y + " collided cells in the hash table.");
		System.out.println("");
	}
	/**
	 * getKey() method will return the key (sum of all unicode values for characters in the state name).
	 * 
	 * @param name        name of the state.
	 * @return key        sum of all unicode values for characters in the state name.
	 */
	public int getKey(String name) {
		int key;
		int sum = 0;
		
		for (int i = 0; i < name.length(); i++) {
			sum += (name.charAt(i));
		}
		
		key = sum % 101;
		return key;
	}
	
	/**
	 * hashFunction() method will return the hash value index in the hash table
	 * 
	 * @return key % arraySize       This is the hash value index.
	 */
	public int hashFunction(int key) {
		return key % arraySize;
	}
	
	/**
	 * getDR() method to return death rate of given state.
	 * 
	 * @param hashVal       hash value index of the hashArray
	 * @param key           key used to get the hash value
	 * @return DR           returns death rate of given state name
	 */
	public double findDR(int hashVal, int key) {
		
		double DR = hashArray[hashVal].findNode(key).deaths / hashArray[hashVal].findNode(key).population * 100000;
		return DR;
	}
}
