package sort;

public class Merge {
	/**
	 * merge sort using Comparable
	 * @param x - the input array containing times of jobs that need to be sorted.
	 * @param n - the size of the input array
	 */
	public static void sortMerge ( Comparable[] x, int n ) {
		if (x.length > 1) { //as long as the array has a size greater than one element
			Comparable[] leftArr = new Comparable[x.length / 2]; //make a new array to store the left side
			System.arraycopy(x, 0, leftArr, 0, x.length / 2); //copy over the data
			
			Comparable[] rightArr = new Comparable[x.length / 2]; 
			System.arraycopy(x, x.length/2, rightArr, 0, x.length / 2);
			
			sortMerge(leftArr, leftArr.length);
			sortMerge(rightArr, rightArr.length);
			
			int leftElementIndex = 0;
			int rightElementIndex = 0;
			int destIndex = 0;
			
			while (leftElementIndex < leftArr.length && rightElementIndex < rightArr.length) {
				if (leftArr[leftElementIndex].compareTo(rightArr[rightElementIndex]) > 0) {
					x[destIndex] = rightArr[rightElementIndex];
					rightElementIndex++;
				} else {
					x[destIndex] = leftArr[leftElementIndex];
					leftElementIndex++;
				}
				destIndex++;
			}
			
			while (leftElementIndex < leftArr.length) {
				x[destIndex] = leftArr[leftElementIndex];
				leftElementIndex++;
				destIndex++;
			}
			
			while (rightElementIndex < rightArr.length) {
				x[destIndex] = rightArr[rightElementIndex];
				rightElementIndex++;
				destIndex++;
			}
			
		}
	}
	
	
		
	
}
