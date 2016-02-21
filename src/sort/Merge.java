package sort;

public class Merge {
	/**
	 * merge sort using Comparable
	 * @param x - the input array containing times of jobs that need to be sorted.
	 * @param n - the size of the input array
	 */
	public static void sortMerge ( Comparable[] x, int n ) {
		System.out.println(x.length);
		if (x.length > 1) {
			Comparable[] leftArr = new Comparable[x.length / 2];
			System.arraycopy(x, 0, leftArr, 0, x.length / 2);
			
			Comparable[] rightArr = new Comparable[x.length / 2];
			System.arraycopy(x, x.length/2, rightArr, 0, x.length / 2);
			
			sortMerge(leftArr, leftArr.length);
			sortMerge(rightArr, rightArr.length);
			
			int i = 0;
			int j = 0;
			int k = 0;
			
			while (i < leftArr.length && j < rightArr.length) {
				if (leftArr[i].compareTo(rightArr[j]) > 0) {
					x[k] = rightArr[j];
					j++;
				} else {
					x[k] = leftArr[i];
					i++;
				}
				k++;
			}
			
			while (i < leftArr.length) {
				x[k] = leftArr[i];
				i++;
				k++;
			}
			
			while (j < rightArr.length) {
				x[k] = rightArr[j];
				j++;
				k++;
			}
			
		}
	}
	
	
		
	
}
