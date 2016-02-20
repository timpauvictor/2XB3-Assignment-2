package sort;

public class Insertion {
	/**
	 * regular insertion sort
	 * @param x - the input array containing processing times of jobs that need to be sorted.
	 */
	public static void sortInsert ( Job[] x ) {
		int N = x.length;
		for (int i = 1; i < N; i++) {
			for (int j = i; j > 0 && (x[j].getTime() < x[j-1].getTime()); j--) {
				exchange(x, j, j-1);
			}
		}
	}
	/**
	 * insertion sort using Comparable
	 * @param x - the input array containing times of jobs that need to be sorted.
	 * @param n - the size of the input array
	 */
	public static void sortComparable (Comparable<Job>[] x, int n) {
		for (int i = 1; i < n; i++) {
			for (int j = i; j > 0 && (isLessThan(x[j], x[j-1])); j--) {
				exchange(x, j, j-1);
			}
		}
	}
	/**
	 * optimized insertion sort
	 * @param x - the input array containing times of jobs that need to be sorted.
	 * @param n - the size of the input array
	 */
	public static void sortBinary (Comparable<Job>[] x, int n) {
		for (int i = 0; i < n; i++) {
			Comparable temp = x[i];
			int left = 0;
			int right = 1;
			while (left < right) {
				int middle = (left + right) / 2;
				if (!isLessThan(temp,x[middle])) {
					left = middle + 1;
				} else {
					right = middle;
				}
			}
			for (int j = i; j > left; j--) {
				exchange(x, j-1, j);
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
	
	/**
	 * exchange two locations in an array
	 * @param a - the array of Comparables
	 * @param currentPoint - the current location of the element
	 * @param destPoint - the destination of the element
	 */
	private static void exchange(Comparable[] a, int currentPoint, int destPoint) {
		Comparable temp = a[currentPoint];
		a[currentPoint] = a[destPoint];
		a[destPoint] = temp;
	}
	
	/**
	 * function to check if our array is sorted
	 * @param a - array of Comparables
	 * @return true if sorted, false otherwise
	 */
	private static boolean isSorted(Comparable[] a) {
		for (int i = 1; i < a.length; i++) {
			if (isLessThan(a[i], a[i-1])) {
				return false;
			}
		}
		return true;
	}
	
}
