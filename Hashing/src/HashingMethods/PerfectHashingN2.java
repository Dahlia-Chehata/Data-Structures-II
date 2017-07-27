package HashingMethods;

import java.util.ArrayList;

public class PerfectHashingN2 extends PerfectHashing{
     
	private int maxDataLength = 32;
    private Integer[] table;

     public PerfectHashingN2(ArrayList<Integer> items) {
 		super(items);
 	}

	@Override
	public void buildTable() throws Exception {
    if (items==null)		
    	throw new Exception("Empty list Exception");
      boolean collision;
      function=new UniversalHashing();
      int n =items.size();
      int index,cnt=0;
      table =new Integer[n*n];
      do {
    	  cnt++;
    	  table =new Integer[n*n];
    	  collision=false;
    	  function.generateFunction(n * n, maxDataLength);
    	  for (int i=0;i<items.size();i++){
    		  index=function.h(items.get(i));
    		  if (table[index]!=null && (int)table[index]!=items.get(i)){
    		  collision=true;
    		  RebuildingTimes++;
    		  cnt = 0;
    		  break;  
    	  }
    	  table[index]=items.get(i);

    	  } 
      }while (collision && cnt<items.size());
      items=null;

      
	}
	@Override
	public boolean search(int index) {
        if (function.h(index)<table.length&&table[function.h(index)]!=null
        		&&(int)table[function.h(index)]==index)
        	return true;
		return false;
	}


	@Override
	public int Size() {
		return table.length;
//		System.out.println("The Size Of The Table = "+table.length);
		
	}


	
   public int getRebuildingTimes(){
		return RebuildingTimes;
//		   System.out.println("Number of times to re-build the Hashtable ="+RebuildingTimes);
   }
   public void insert(int i){
		if(items == null)
			items = new ArrayList<Integer>();
		 items.add(i);
	}
public void setMaxDataLength(int maxDataLength) {
	this.maxDataLength = maxDataLength;
}
   @Override
public Object[] getTable() {
	return table;
}
   
}
