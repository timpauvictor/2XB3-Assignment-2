package sort;

public class Merge {
	/**
	 * merge sort using Comparable
	 * @param x - the input array containing times of jobs that need to be sorted.
	 * @param n - the size of the input array
	 */
	public static void sortMerge ( Comparable[] x, int n ) {
		Comparable[] aux = new Comparable[n];
		sort(x, aux, 0, x.length -1);
	}
	
	/**
	 * function to sort using merge sort
	 * @param a - our original array
	 * @param aux - helper array
	 * @param lowestIndex - the lowest index possible
	 * @param highestIndex - the highest index possible
	 */
	private static void sort(Comparable[] a, Comparable[] aux, int lowestIndex, int highestIndex) {
		if (highestIndex <= lowestIndex) {
			return; //exit out if we're not in a valid spot
		}
		int middleIndex = lowestIndex + (highestIndex - lowestIndex) / 2;
		sort(a, aux, lowestIndex, middleIndex);
		sort(a, aux, middleIndex + 1, highestIndex);
		merge(a, aux, lowestIndex, middleIndex, highestIndex);
	}
	
	/**
	 * this is a function to merge the arrays together
	 * @param a - our original array
	 * @param aux - helper array
	 * @param lowestIndex - the lowest possible index
	 * @param middleIndex - the middle index
	 * @param highestIndex - the highest possible index
	 */
	private static void merge(Comparable[] a, Comparable[] aux, int lowestIndex, int middleIndex, int highestIndex) {
		for (int i = lowestIndex; i < highestIndex; i++) {
			aux[i] = a[i];
		}
		
		int i = lowestIndex;
		int j = middleIndex + 1;
		for (int k = lowestIndex; k <= highestIndex; k++) {
			if (i > middleIndex) {
				a[k] = aux[j++];
			} else if (j > highestIndex) {
				a[k] = aux[i++];
			} else if (isLessThan(aux[j], aux[i])) {
				a[k] = aux[j++];
			} else {
				a[k] = a[i++];
			}
		}
	}
	
	/**
	 * check whether arg1 is less than arg2
	 * @param a - comparable 1
	 * @param b - comparable 2
	 * @return true if less than, false otherwise
	 */
	private static boolean isLessThan(Comparable a, Comparable b) {
		return a.compareTo(b) < 0;
	}
		
	
}
