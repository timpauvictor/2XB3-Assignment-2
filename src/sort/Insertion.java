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
		int whereToInsert = 0;
		for (int i = 0; i < n; i++) {
			Job currElement = (Job) x[i];
			whereToInsert = modBinSearch(x, 0, i, currElement);
			if (whereToInsert < i) {
				Comparable<Job> tempLoc = x[i];
				for (int j = i - 1; j >= whereToInsert; j--) {
					x[j+1] = x[j];
				}
				x[whereToInsert] = tempLoc;
			}
		}
	}
	
	/**
	 * modified binary search algorithm
	 * @param x - our inpur array
	 * @param lowestIndex - the lowest index we look at 
	 * @param highestIndex - the higest index we can look at
	 * @param currElement - the element we are comparing
	 * @return - the index we we find the element at
	 */
	private static int modBinSearch(Comparable<Job>[] x, int lowestIndex, int highestIndex, Comparable<Job> currElement) { //this was pretty annoying fam
		Job[] jobX = (Job[])x;
		Job jobCurrElement = (Job) currElement;
		while (lowestIndex < highestIndex) {
			int middleIndex = lowestIndex + (highestIndex - lowestIndex) / 2;
			if (jobCurrElement.getTime() < jobX[middleIndex].getTime()) {
				highestIndex = middleIndex;
			} else if (jobCurrElement.getTime() >= jobX[middleIndex].getTime()) {
				lowestIndex = middleIndex + 1;
			}
		}
		return lowestIndex;
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
