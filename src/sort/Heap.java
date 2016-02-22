package sort;

public class Heap {
	/**
	 * heap sort using Comparable
	 * @param x - the input array containing times of jobs that need to be sorted.
	 * @param n - the size of the input array
	 */
	public static void sortHeap ( Comparable[] x, int n ) {
		for (int halfSize = n/2; halfSize >= 1; halfSize--) { //we split it in half, and sink everything that is smaller than the parent.
										 //this will effectively put the smallest pieces of data at the bottom (heap order)
			sink(x, halfSize, n);
		}
		while (n > 1) { //this second loop takes out the biggest number over and over and restores heap order
			exchangeElements(x, 1, n--); //exchange elements to 1 
			sink(x, 1, n); //sink again on the other side
		}
	}

	/**
	 * this is a simple function to exchange two spots in an array
	 * @param x - our input array
	 * @param sourceIndex - the element we want to move
	 * @param destIndex - the location we want it to be
	 */
	private static void exchangeElements(Comparable[] x, int sourceIndex, int destIndex) {
		Comparable swap = x[sourceIndex-1];
		x[sourceIndex-1] = x[destIndex-1];
		x[destIndex-1] = swap;
	}
	
	/**
	 * this is a private function to sink
	 * @param x - our input array
	 * @param halfSize - half the array size
	 * @param n - the length of the array (size)
	 */
	private static void sink(Comparable[] x, int halfSize, int n) {
		while (2*halfSize <= n) {
			int fullSize = 2*halfSize;
			if (fullSize < n && isGreaterThan(x, fullSize, fullSize+1)) { //no children!
				fullSize++;
			}
			if (!isGreaterThan(x, halfSize, fullSize)) {
				break; //heap ordered!
			}
			exchangeElements(x, halfSize, fullSize);
			halfSize = fullSize;
		}
	}

	/**
	 * function to check if one comparable is greater than another
	 * @param x - input array
	 * @param j - item one index
	 * @param i - item two index
	 * @return true if greater, false otherwise
	 */
	private static boolean isGreaterThan(Comparable[] x, int j, int i) { //instead of less, we use greater to organize it from lowest to highest
		return x[i-1].compareTo(x[j-1]) > 0;
	}
}
