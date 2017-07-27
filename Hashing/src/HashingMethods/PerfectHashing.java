package HashingMethods;
import java.util.ArrayList;


public abstract class PerfectHashing {
	
	protected UniversalHashing function;
	protected int RebuildingTimes;
	protected ArrayList<Integer> items;
	
	public PerfectHashing(ArrayList<Integer> items){
		this.items=items;
	}
	public abstract void buildTable() throws Exception;
	/**
	 * dictionary lookup
	 * @param index
	 * @return
	 */
	public abstract boolean search(int index) ;


	/**
	 * @return the table size
	 */
	public abstract int Size();
	
//	public abstract void printTable();

	public abstract Object[] getTable();

	/**
	 * @return the number of rebuilding
	 */
	public int getRebuildingTimes() {
		return RebuildingTimes;
	}

}
