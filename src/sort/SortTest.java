package sort;

import static org.junit.Assert.assertTrue;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class SortTest {
	String[][] preJobArray = new String[7][];
	Job[][] JobArray = new Job[7][];
	

	@Before
	public void setUp() throws Exception {
		preJobArray = new String[7][];
		JobArray = new Job[7][];
		final String baseDir = Heap.class.getClassLoader().getResource("").getPath();
		Path filePath = Paths.get(baseDir, "../data/a2_in.txt"); //okay so this definietly won't work on a windows machine and maybe not even on an OSX machine
															 	 //but i had to jump through hoops to get the dumb thing to read my file
		List<String> fileData = Files.readAllLines(filePath, Charset.defaultCharset()); //read all the lines and put it in a list
        
        for (int line = 0; line < fileData.size(); line++) { //go through the array we just made
        	String[] lineArray = fileData.get(line).split("},"); //split it into another array
        	for (int i = 0; i < lineArray.length; i++) { //loop through that smaller array
        		lineArray[i] = lineArray[i].substring(1); //and get rid of the first "{"
        	}
        	lineArray[lineArray.length - 1] = lineArray[lineArray.length - 1].substring(0, lineArray[lineArray.length - 1].length() - 1); //get rid of the last '{' 
        	preJobArray[line] = lineArray;
        }
        
        for (int i = 0; i < preJobArray.length; i++) { //now we make our string array into a job array
        	JobArray[i] = new Job[preJobArray[i].length];
        	for (int j = 0; j < preJobArray[i].length; j++) {
        		JobArray[i][j] = new Job(preJobArray[i][j].split(",")[0], Integer.parseInt(preJobArray[i][j].split(",")[1]));
        	}
        }
	}

	@Test
	public void testInsertSort() {
		for (int i = 0; i < JobArray.length; i++) {
			Stopwatch watch = new Stopwatch();
			Insertion.sortInsert(JobArray[i]);
			double time = watch.elapsedTime();
			System.out.println("Insertion sort with " + JobArray[i].length + " items took: " + time + " ns");
			assertTrue(Insertion.isSorted(JobArray[i]));
		}
	}
	
	@Test
	public void testInsertComparable() {
		for (int i = 0; i < JobArray.length; i++) {
			Stopwatch watch = new Stopwatch();
			Insertion.sortComparable(JobArray[i], JobArray[i].length);
			double time = watch.elapsedTime();
			System.out.println("Insertion sort using Comparable with " + JobArray[i].length + " items took: " + time + " ns");
			assertTrue(Insertion.isSorted(JobArray[i]));
		}
	}
	
	@Test
	public void testInsertBinary() {
		for (int i = 0; i < JobArray.length; i++) {
			Stopwatch watch = new Stopwatch();
			Insertion.sortBinary(JobArray[i], JobArray[i].length);
			double time = watch.elapsedTime();
			System.out.println("Insertion sort using Binary search with " + JobArray[i].length + " items took: " + time + " ns");
			assertTrue(Insertion.isSorted(JobArray[i]));
		}
	}
	
	@Test
	public void testMergeSort() {
		for (int i = 0; i < JobArray.length; i++) {
			Stopwatch watch = new Stopwatch();
			Merge.sortMerge(JobArray[i], JobArray[i].length);
			double time = watch.elapsedTime();
			System.out.println("Merge sort with " + JobArray[i].length + " items took: " + time + " ns");
			assertTrue(Insertion.isSorted(JobArray[i]));
		}
	}
	
	@Test
	public void testHeapSort() {
		for (int i = 0; i < JobArray.length; i++) {
			Stopwatch watch = new Stopwatch();
			Heap.sortHeap(JobArray[i], JobArray[i].length);
			double time = watch.elapsedTime();
			System.out.println("Heap sort with " + JobArray[i].length + " items took: " + time + " ns");
			assertTrue(Insertion.isSorted(JobArray[i]));
		}
	}

}
