package HashingMethods;

import java.util.ArrayList;

public class PerfectHashingN extends PerfectHashing {

	private int maxWordLength;
	private ArrayList<Integer>[] hashingArray;
	private PerfectHashingN2 nSquaredArray;
	private PerfectHashingN2[] table;
	
	
	
	@SuppressWarnings("unchecked")
	public PerfectHashingN(ArrayList<Integer> items) {
		super(items);

		RebuildingTimes = 0;
		table = new PerfectHashingN2[items.size()];
		maxWordLength = 0;
		hashingArray = new ArrayList[items.size()];
		computeMaxWordLength();
		
	}
	
	public int getMaxWordLength() {
		return maxWordLength;
	}
	
	private void computeMaxWordLength() {
		for (int n : items) {
//			String tempNumber = String.valueOf(n);
			String tempNumber = Integer.toBinaryString(n);
			int length = tempNumber.length();
			
			if (length > maxWordLength) {
				maxWordLength = length;
			}
		}
	}
	
	@Override
	public void buildTable() throws Exception {
		if (items.size() == 0) {
			throw new Exception("The list is empty!");
		}
		
		ArrayList<Integer> collisions;
	    	
		function = new UniversalHashing();
		
//		table = new Object[items.size()];
		
		function.generateFunction(items.size(), maxWordLength);
		
		for (int n : items) {
			int index = function.h(n);

			if (hashingArray[index] != null) {
				collisions = hashingArray[index];
			} else {
				collisions = new ArrayList<>();
			}
			collisions.add(n);
			hashingArray[index] = collisions;
		}
		
		generateNSquaredArrays();
		
	}

	private void generateNSquaredArrays() {
		ArrayList<Integer> temp;
		
		for (int i = 0; i < items.size(); i++) {
			temp = (ArrayList<Integer>) hashingArray[i];
			if (temp != null) {
				nSquaredArray = new PerfectHashingN2(temp);
				nSquaredArray.setMaxDataLength(maxWordLength);
				try {
					nSquaredArray.buildTable();
					RebuildingTimes += nSquaredArray.getRebuildingTimes();
				} catch (Exception e) {
//					e.printStackTrace();
				}
				table[i] = nSquaredArray;
			}
		}
	}

	@Override
	public boolean search(int index) {
		int numberSearch = function.h(index);
//		if (numberSearch >= items.size()) {
//			System.out.println(">>>>>>>>>>>>>");
//		}
		
		
		PerfectHashingN2 p = (PerfectHashingN2) table[numberSearch];
		if (p.search(index)) {
			return true;
		}
		
		return false;
	}

	@Override
	public int Size() {
		return items.size();
	}
	
	@Override
	public PerfectHashingN2[] getTable() {
		return table;
		
	}

	
}