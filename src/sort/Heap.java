package sort;

public class Heap {
	/**
	 * heap sort using Comparable
	 * @param x - the input array containing times of jobs that need to be sorted.
	 * @param n - the size of the input array
	 */
	public static void sortHeap ( Comparable[] x, int n ) {
		for (int k = n/2; k >= 1; k--) { //we split it in half, and sink everything that is smaller than the parent.
										 //this will effectively put the smallest pieces of data at the bottom (heap order)
			sink(x, k, n);
		}
		while (n > 1) { //this second loop takes out the biggest number over and over and restores heap order
			exchangeElements(x, 1, n--); //exchange elements to 1 
			sink(x, 1, n); //sink again on the other side
		}
	}

	/**
	 * this is a simple function to exchange two spots in an array
	 * @param x - our input array
	 * @param i - the element we want to move
	 * @param j - the location we want it to be
	 */
	private static void exchangeElements(Comparable[] x, int i, int j) {
		Comparable swap = x[i-1];
		x[i-1] = x[j-1];
		x[j-1] = swap;
	}

	private static void sink(Comparable[] x, int k, int n) {
		while (2*k <= n) {
			int j = 2*k;
			if (j < n && isGreaterThan(x, j, j+1)) { //no children!
				j++;
			}
			if (!isGreaterThan(x, k, j)) {
				break; //heap ordered!
			}
			exchangeElements(x, k, j);
			k = j;
		}
	}

	private static boolean isGreaterThan(Comparable[] x, int j, int i) { //instead of less, we use greater to organize it from lowest to highest
		return x[i-1].compareTo(x[j-1]) > 0;
	}
}
