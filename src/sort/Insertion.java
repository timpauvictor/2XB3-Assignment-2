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
		int index = 0;
		Job currElement;
		Comparable[] newArray = new Comparable[x.length];
		
		for (int i = 1; i < x.length - 1; i++) {
			currElement = (Job) x[i];
			index = modBinSearch(x, currElement);
			newArray[i] = currElement;
			
			while (index >= 0 && ((Job)x[index]).getTime() > currElement.getTime()) {
				x[index + 1] = x[index];
				index--;
			}
			newArray[index + 1] = currElement;
		}
	}
	
	private static int modBinSearch(Comparable<Job>[] x, Comparable<Job> currElement) {
		int leftMostIndex = 0;
		int rightMostIndex = x.length - 1;
		int middleIndex = 0;
		
		while (leftMostIndex <= rightMostIndex) {
			middleIndex = (leftMostIndex + rightMostIndex) / 2;
			if (x[middleIndex].compareTo((Job) currElement) == 0) {
				return middleIndex;
			} else if (x[middleIndex].compareTo((Job) currElement) == -1) {
				rightMostIndex = middleIndex - 1;
			} else {
				leftMostIndex = middleIndex + 1;
			}
		}
		return middleIndex - 1;
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
	public static boolean isSorted(Comparable[] a) {
		for (int i = 1; i < a.length; i++) {
			if (isLessThan(a[i], a[i-1])) {
				return false;
			}
		}
		return true;
	}
	
}
