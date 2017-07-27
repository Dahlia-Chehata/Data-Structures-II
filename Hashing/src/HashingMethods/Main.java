package HashingMethods;
import java.util.ArrayList;
import java.util.Scanner;

import reader.Reader;

public class Main {
	static private boolean cont = true;
	static private HashingMethods.PerfectHashing table;
	static private ArrayList<Integer> elements;

	public static void main(String[] args) {
		String fileName = "keys1001000";
		elements = readFile(fileName); // read file
		if (elements == null) { // error in file
			p(">> Error in reading the file!");
		} else {
			p(">> Read file [" + fileName + "] sucessfully \n ---------------------------------------");
		}
		
		while(cont) {
			int choice = printChoices();
			performChoice(choice);
		}		
		
		
	}
	
	
	private static void performChoice(int choice) {
		switch (choice) {
		case 1:
			buildPerfectHashTable();
			break;
		case 2:
			buildON2HashTable();
			break;
		case 3:
			printTable();
			break;
		case 4:
			p(">> Number of rebuilding = " + table.getRebuildingTimes() + "\n");
			break;
		case 5:
			p(">> Enter the element you want to search: \n");
			search();
		default:
			break;
		}
		
	}


	private static void search() {
		@SuppressWarnings("resource")
		Scanner s = new Scanner(System.in);
		try {
			int search = s.nextInt();
			boolean found = table.search(search);
			if (found) {
				p(">> [" + search + "] is found\n");
			} else {
				p(">> [" + search + "] is not found\n");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			p(">> Error, The number you entered is not valid! \n");
			p(">> Please enter the number you want to search for: \n");
			search();
		}
		
		
	}


	private static void buildON2HashTable() {
		table = new PerfectHashingN2(elements);
		try {
			table.buildTable();
			p(">> HashTable built successfully\n");
		} catch (Exception e) {
			p(">> Error in building the table\n");
			e.printStackTrace();
		}
		
	}


	private static void buildPerfectHashTable() {
//		create perfect hashing and build table;
		table = new PerfectHashingN(elements);
		try {
			table.buildTable();
			p(">> HashTable built successfully\n");
		} catch (Exception e) {
			p(">> Error in building the table\n");
			e.printStackTrace();
		}
		
	}


	private static int printChoices() {
		p("1) Build perfect HashTable ");
		p("2) Build O(n^2) HashTable");
		p("3) Print table");
		p("4) Print number of rebuilding");
		p("5) Search");
		
		@SuppressWarnings("resource")
		Scanner s = new  Scanner(System. in);
		try {
			int no = s.nextInt();
			if (no < 1 || no > 5) {
				throw new RuntimeException();
			}
			return no;
		}catch (Exception e) {
				p(">> Error in your choice, please select a valid choice!\n");
				return printChoices();
			}
		
		
	}


	private static void printTable() {
		if (table == null) {
			p(">> Error, No table was built, please build a table first!\n");
			return;
		}
		if (table instanceof PerfectHashingN) {
			printPerfectHashTable();
		} else {
			printN2Table();
		}
		

		
		

	}
	
	
	private static void printN2Table() {
		Object[] table1 = table.getTable();
		p("");
		System.out.print("[");
    	for (int i = 0; i < table1.length; i++) {
    		if(table1[i]!=null)
			 System.out.print(table1[i]+",");
    		else
    			System.out.print("");
		}
    	System.out.println("]\n");
		
	}


	private static void printPerfectHashTable() {
		
		p("");
		try {
			PerfectHashingN2[] table1 = (PerfectHashingN2[]) table.getTable();
			for (int j = 0; j < table1.length; j++) { // loop in N
				if (table1[j] == null ) {
					continue;
				}
				Object[] table =  table1[j].getTable(); // table = n2 array
				System.out.print("[");
				if (table == null) {
					continue;
				}
		    	for (int i = 0; i < table.length; i++) {
		    		if(table[i]!=null)
					 System.out.print(table[i]+",");
		    		else
		    			System.out.print("");
				}
		    	System.out.println("]");
			}
			p("\n");
		} catch (Exception e) {
			e.printStackTrace();
			p("Error in printing the table!\n");
		}
		
	}


	private static ArrayList<Integer> readFile(String fileName) {
		ArrayList<Integer> lines;
		Reader reader;
		try {
			reader = new Reader(fileName);
			reader.readFile();
			lines = reader.getKeys();
			return lines;
		} catch (Exception e) {
			return null;
		}
	}
	
	private static void p(Object string) {
		System.out.println(string);
	}
	
}
