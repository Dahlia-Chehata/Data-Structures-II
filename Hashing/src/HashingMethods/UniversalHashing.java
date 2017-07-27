package HashingMethods;

import java.util.Random;

public class UniversalHashing {
	
	private int tableSize;
	private int cols;
	private int rows;
	private int[][] matrix;

	public void generateFunction(int tableSize, int maxDataLength) {
		this.tableSize = tableSize;
		cols = maxDataLength; // max no of bits of x 
		rows = (int) Math.ceil(Math.log(tableSize) / Math.log(2)); // b = Log2(M)
		if (rows < 1) {
			rows = 1;
		}
		matrix = new int[rows][cols];
		Random randomGenerator = new Random();
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				matrix[i][j] = randomGenerator.nextInt(2); // max value 1
			}
		}
		
	}



	public int h(int number) {
//		convert no to binary array
		int [] binaryArray = toBinaryArray(number);
//		multiply matrix with number
//		System.out.println(multipleFunction(binaryArray));
		return multipleFunction(binaryArray);
	}
	
	private int multipleFunction(int[] binaryArray) {
		int[] multipliedBinaryNumber = new int[rows];
		int convertedNumber =0;
		int sum;
		int mul;
		for (int i = 0; i < rows; i++) {
			sum = 0;
			for (int j = 0; j < cols; j++) {
				mul = matrix[i][j] * binaryArray[j];
				sum = Math.floorMod(sum + mul, 2);
			}
			multipliedBinaryNumber[i] = sum;
		}
		
		String multipliedNumberString = toString(multipliedBinaryNumber);
		convertedNumber = Integer.parseInt(multipliedNumberString, 2);
		try {
		convertedNumber = Math.floorMod(convertedNumber, tableSize-1);}
		catch (Exception e) { // table size = 1 >> mod 0 is un defined
			convertedNumber = 0;
		}
		
		
		
		return convertedNumber;
	}



	private String toString(int[] multipliedBinaryNumber) {
		String string = "";
		for (int i = 0; i < multipliedBinaryNumber.length; i++) {
			if (multipliedBinaryNumber[i] == 0) {
				string += "0";
			} else {
				string += "1";
			}
		}
		return string;
	}



	private int[] toBinaryArray(int number) {
//		to binary string
		int [] array = new int [cols];
		String binaryNumber = Integer.toBinaryString(number);
		binaryNumber = fillNumber(binaryNumber, cols); // fill empty places with zeros
//		from binary string to array
		for (int i = 0; i < cols; i++) {
			if ((binaryNumber.charAt(i)) == '0') {
				array[i] = 0;
			} else {
				array[i] = 1;
			}
		}
		return array;
	}
	

//	public static void main(String[] args) { // for testing only
//		UniversalHashing h = new UniversalHashing();
//		h.generateFunction(50, 5);
//		h.h(14);
//
//		
//	}
	
	private String fillNumber(String number, int size) {
		while (number.length() < size) {
			number = "0" + number;
		}
		return number;
	}
	
	


}
