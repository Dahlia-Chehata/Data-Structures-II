import java.util.Random;

public class main {
	/**
	 * randomFill
	 * 
	 * @return
	 */
	public static int randomFill() {

		Random rand = new Random();
		int randomNum = rand.nextInt();
		return randomNum;
	}

	/**
	 * list
	 * 
	 * @param n
	 * @return
	 */
	public static int[] list(int n) {
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = randomFill();
		}
		return arr;
	}

	@SuppressWarnings("static-access")
	public static void main(final String[] args) {

		int[] arr1 = list(1);// 1
		int[] arr2 = list(4);// 4
		int[] arr3 = list(8);// 8
		int[] arr4 = list(12);// 12
		int[] arr5 = list(20);// 20
		int[] arr6 = list(100);
		int[] arr7 = list(10000);
		int[] arr8 = list(10010);

		Sort x = new Sort(arr1, 1);
		Sort y = new Sort(arr2, 4);
		Sort z = new Sort(arr3, 8);
		Sort m = new Sort(arr4, 12);
		Sort n = new Sort(arr5, 20);
		Sort a = new Sort(arr6, 100);
		Sort b = new Sort(arr7, 10000);
		Sort c = new Sort(arr8, 10000);
		heapsort u = new heapsort();

		/** bubble **/
		long t1 = System.nanoTime();
		x.BubbleSort(arr1, arr1.length);
		long t2 = System.nanoTime();
		long b1 = t2 - t1;
		t1 = System.nanoTime();
		y.BubbleSort(arr2, arr2.length);
		t2 = System.nanoTime();
		long b2 = t2 - t1;
		t1 = System.nanoTime();
		z.BubbleSort(arr3, arr3.length);
		t2 = System.nanoTime();
		long b3 = t2 - t1;
		t1 = System.nanoTime();
		m.BubbleSort(arr4, arr4.length);
		t2 = System.nanoTime();
		long b4 = t2 - t1;
		t1 = System.nanoTime();
		n.BubbleSort(arr5, arr5.length);
		t2 = System.nanoTime();
		long b5 = t2 - t1;
		t1 = System.nanoTime();
		a.BubbleSort(arr6, arr6.length);
		t2 = System.nanoTime();
		long b6 = t2 - t1;
		t1 = System.nanoTime();
		b.BubbleSort(arr7, arr7.length);
		t2 = System.nanoTime();
		long b7 = t2 - t1;
		t1 = System.nanoTime();
		c.BubbleSort(arr8, arr8.length);
		t2 = System.nanoTime();
		long b8 = t2 - t1;
		System.out.println(b1 + "," + b2 + "," + b3 + "," + b4 + "," + b5 + "," + b6 + "," + b7 + "," + b8);
		// for (int i=0;i<x.size;i++)
		// System.out.print(x.list[i]+",");

		/** selection**/
		t1 = System.nanoTime();
		x.selectionSort(arr1, 0);
		t2 = System.nanoTime();
		b1 = t2 - t1;
		t1 = System.nanoTime();
		y.selectionSort(arr2, 0);
		t2 = System.nanoTime();
		b2 = t2 - t1;
		t1 = System.nanoTime();
		z.selectionSort(arr3, 0);
		t2 = System.nanoTime();
		b3 = t2 - t1;
		t1 = System.nanoTime();
		m.selectionSort(arr4, 0);
		t2 = System.nanoTime();
		b4 = t2 - t1;
		t1 = System.nanoTime();
		n.selectionSort(arr5, 0);
		t2 = System.nanoTime();
		b5 = t2 - t1;
		t1 = System.nanoTime();
		a.selectionSort(arr6, 0);
		t2 = System.nanoTime();
		b6 = t2 - t1;
		t1 = System.nanoTime();
		b.selectionSort(arr7, 0);
		t2 = System.nanoTime();
		b7 = t2 - t1;
		t1 = System.nanoTime();
		c.selectionSort(arr8, 0);
		t2 = System.nanoTime();
		b8 = t2 - t1;
		System.out.println(b1 + "," + b2 + "," + b3 + "," + b4 + ","
		+ b5 + "," + b6 + "," + b7 + "," + b8);
		// for (int i=0;i<x.size;i++)
		// System.out.print(x.list[i]+",");
		// System.out.println();
		

		/** insertion**/
		t1 = System.nanoTime();
		x.InsertionSort(x.size);
		t2 = System.nanoTime();
		b1 = t2 - t1;
		t1 = System.nanoTime();
		y.InsertionSort(y.size);
		t2 = System.nanoTime();
		b2 = t2 - t1;
		t1 = System.nanoTime();
		z.InsertionSort(z.size);
		t2 = System.nanoTime();
		b3 = t2 - t1;
		t1 = System.nanoTime();
		m.InsertionSort(m.size);
		t2 = System.nanoTime();
		b4 = t2 - t1;
		t1 = System.nanoTime();
		n.InsertionSort(n.size);
		t2 = System.nanoTime();
		b5 = t2 - t1;
		t1 = System.nanoTime();
		a.InsertionSort(a.size);
		t2 = System.nanoTime();
		b6 = t2 - t1;
		t1 = System.nanoTime();
		b.InsertionSort(b.size);
		t2 = System.nanoTime();
		b7 = t2 - t1;
		t1 = System.nanoTime();
		c.InsertionSort(c.size);
		t2 = System.nanoTime();
		b8 = t2 - t1;
		System.out.println(b1 + "," + b2 + "," + b3 + "," + b4 + "," + 
				b5 + "," + b6 + "," + b7 + "," + b8);

		// for (int i=0;i<x.size;i++)
		// System.out.print(x.list[i]+",");
		// System.out.println();
		
		/** merge**/
		t1 = System.nanoTime();
		x.MergeSort(0, x.size - 1);
		t2 = System.nanoTime();
		b1 = t2 - t1;
		t1 = System.nanoTime();
		y.MergeSort(0, y.size - 1);
		t2 = System.nanoTime();
		b2 = t2 - t1;
		t1 = System.nanoTime();
		z.MergeSort(0, z.size - 1);
		t2 = System.nanoTime();
		b3 = t2 - t1;
		t1 = System.nanoTime();
		m.MergeSort(0, m.size - 1);
		t2 = System.nanoTime();
		b4 = t2 - t1;
		t1 = System.nanoTime();
		n.MergeSort(0, n.size - 1);
		t2 = System.nanoTime();
		b5 = t2 - t1;
		t1 = System.nanoTime();
		a.MergeSort(0, a.size - 1);
		t2 = System.nanoTime();
		b6 = t2 - t1;
		t1 = System.nanoTime();
		b.MergeSort(0, b.size - 1);
		t2 = System.nanoTime();
		b7 = t2 - t1;
		t1 = System.nanoTime();
		c.MergeSort(0, c.size - 1);
		t2 = System.nanoTime();
		b8 = t2 - t1;
		System.out.println(b1 + "," + b2 + "," + b3 + "," + b4 + 
				"," + b5 + "," + b6 + "," + b7 + "," + b8);
		// for (int i=0;i<x.size;i++)
		// System.out.print(x.list[i]+",");
		// System.out.println();
		
		/** quick**/
		t1 = System.nanoTime();
		x.quickSort(arr1, 0, x.size - 1);
		t2 = System.nanoTime();
		b1 = t2 - t1;
		t1 = System.nanoTime();
		y.quickSort(arr2, 0, y.size - 1);
		t2 = System.nanoTime();
		b2 = t2 - t1;
		t1 = System.nanoTime();
		z.quickSort(arr3, 0, z.size - 1);
		t2 = System.nanoTime();
		b3 = t2 - t1;
		t1 = System.nanoTime();
		m.quickSort(arr4, 0, m.size - 1);
		t2 = System.nanoTime();
		b4 = t2 - t1;
		t1 = System.nanoTime();
		n.quickSort(arr5, 0, n.size - 1);
		t2 = System.nanoTime();
		b5 = t2 - t1;
		t1 = System.nanoTime();
		a.quickSort(arr6, 0, n.size - 1);
		t2 = System.nanoTime();
		b6 = t2 - t1;
		t1 = System.nanoTime();
		b.quickSort(arr7, 0, n.size - 1);
		t2 = System.nanoTime();
		b7 = t2 - t1;
		t1 = System.nanoTime();
		c.quickSort(arr8, 0, n.size - 1);
		t2 = System.nanoTime();
		b8 = t2 - t1;
		System.out.println(b1 + "," + b2 + "," + b3 + "," + b4 + "," +
				b5 + "," + b6 + "," + b7 + "," + b8);

		// for (int i=0;i<x.size;i++)
		// System.out.print(x.list[i]+",");
		
		 /**heapsort**/
		t1 = System.nanoTime();
		u.sort(arr1);
		t2 = System.nanoTime();
		b1 = t2 - t1;
		t1 = System.nanoTime();
		u.sort(arr2);
		t2 = System.nanoTime();
		b2 = t2 - t1;
		t1 = System.nanoTime();
		u.sort(arr3);
		t2 = System.nanoTime();
		b3 = t2 - t1;
		t1 = System.nanoTime();
		u.sort(arr4);
		t2 = System.nanoTime();
		b4 = t2 - t1;
		t1 = System.nanoTime();
		u.sort(arr5);
		t2 = System.nanoTime();
		b5 = t2 - t1;
		t1 = System.nanoTime();
		u.sort(arr6);
		t2 = System.nanoTime();
		b6 = t2 - t1;
		t1 = System.nanoTime();
		u.sort(arr7);
		t2 = System.nanoTime();
		b7 = t2 - t1;
		t1 = System.nanoTime();
		u.sort(arr8);
		t2 = System.nanoTime();
		b8 = t2 - t1;
		System.out.println(b1 + "," + b2 + "," + b3 + "," + b4 + "," 
		+ b5 + "," + b6 + "," + b7 + "," + b8);
	}

}
