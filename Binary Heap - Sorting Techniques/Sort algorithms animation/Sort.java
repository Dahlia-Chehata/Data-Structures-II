import java.util.concurrent.atomic.AtomicReference;

public class Sort {

	int []list;
	int size;
	/**
	 * constructor
	 * @param list
	 * @param size
	 */
	public Sort (int []list,int size) {
		this.size=size;
		this.list= new int[size];
		this.list=list;
	}
	/**
	 * BubbleSort
	 * @param list
	 * @param size
	 * @return
	 */
	int[] BubbleSort(int[]list,int size) {
        if (size == 1) {
            return list; 
        }
        for (int i = 0; i < size-1; i++) {
            if (list[i+1] < list[i]) {
            	int temp=list[i];
            	list[i]=list[i+1];
            	list[i+1]=temp;
            }
        }
        return BubbleSort(list, size-1);
    }
	/**
	 * selectionSort
	 * @param list
	 * @param start
	 */
	void selectionSort(int[] list, int start) {
	    if ( start >= size - 1 )
	        return;
	    int minIndex = start;
	    for ( int i = start + 1; i < size; i++ ) {
	        if (list[i] < list[minIndex] )
	            minIndex = i;
	    }
	    int temp=list[start];
	    list[start]=list[minIndex];
	    list[minIndex]=temp;
	    selectionSort(list, start + 1);
	}
	/**
	 * InsertionSort
	 * @param size
	 * @return
	 */
	int InsertionSort(int size) {
        if (size <= 1) {
            return size;
        }
        size = InsertionSort(size - 1); 
        int key = list[size];  
        int i = size - 1;
        while ((i >= 0) && (list[i] > key)) {
            list[i+1] = list[i];
            i--;
        }
        list[i+1] = key;
        return size + 1;
        
	}
	/**
	 * merge sort
	 * @param low
	 * @param high
	 */
	 void MergeSort(int low, int high) {
	   
	       if (low < high) { 
	              int mid = (low + high)/2;
	              MergeSort(low, mid);
	              MergeSort(mid + 1, high);
	              Merge(low, mid, high);
	       }
	   }

	   private void Merge(int low, int mid, int high) {
	       int h = low, i = low, j = mid+1, k;
	       
	       int[]aux =new int [size];
	       
	       while ((h <= mid) && (j <= high)) {
	          if (list[h] <= list[j]) {
	        	  aux[i] = list[h]; 
	        	  h++; 
	        	  } else {
	        		  aux[i] = list[j]; 
	        		  j++; 
	        		  } 
	          i++;
	       }
	         
	          if (h > mid) {
	    	   for (k=j; k<=high; k++) {
	                  aux[i] = list[k]; 
	                       i++;
	    	   } } else {
	    	   for (k=h; k<=mid; k++) {
	               aux[i] = list[k]; 
	               i++;
	            }
	    	   }
	       for (k=low; k<=high; k++) 
	    	   list[k] = aux[k];
	   }
	   /**
	    * computing pivot for quick sort
	    * @param arr
	    * @param left
	    * @param right
	    * @return
	    */
	   private int partition(int arr[], int left, int right)
	   {
	         int pivot = arr[(left + right) / 2];
	         while (left <= right) {
	               while (arr[left] < pivot)
	            	   left++;
	               while (arr[right] > pivot)
	            	   right--;
	               if (left <= right) {
	                     int temp=arr[left];
	                     arr[left]=arr[right];
	                     arr[right]=temp;
	                     left++;
	                     right--;
	               }
	         }
	         return left;
	   }
	    /**
	     * Quick sort
	     * @param arr
	     * @param left
	     * @param right
	     */
	   void quickSort(int arr[], int left, int right) {
	         int pivot = partition(arr, left, right);
	         if (left < pivot - 1)
	               quickSort(arr, left, pivot - 1);
	         if (pivot < right)
	               quickSort(arr, pivot, right);
	   }
	   
}
