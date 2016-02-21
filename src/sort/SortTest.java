package sort;

import static org.junit.Assert.*;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class SortTest {
	String[][] preJobArray = new String[5][];
	Job[][] JobArray = new Job[5][];
	

	@Before
	public void setUp() throws Exception {
		preJobArray = new String[5][];
		JobArray = new Job[5][];
		final String baseDir = Heap.class.getClassLoader().getResource("").getPath();
		Path filePath = Paths.get(baseDir, "../data/a2_in.txt");
		List<String> fileData = Files.readAllLines(filePath, Charset.defaultCharset());
        
        for (int line = 0; line < fileData.size(); line++) {
        	String[] lineArray = fileData.get(line).split("},");
        	for (int i = 0; i < lineArray.length; i++) {
        		lineArray[i] = lineArray[i].substring(1);
        	}
        	lineArray[lineArray.length - 1] = lineArray[lineArray.length - 1].substring(0, lineArray[lineArray.length - 1].length() - 1); 
        	preJobArray[line] = lineArray;
        }
        
        for (int i = 0; i < preJobArray.length; i++) {
        	JobArray[i] = new Job[preJobArray[i].length];
        	for (int j = 0; j < preJobArray[i].length; j++) {
        		JobArray[i][j] = new Job(preJobArray[i][j].split(",")[0], Integer.parseInt(preJobArray[i][j].split(",")[1]));
        	}
        }
	}

	@Test
	public void testInsertSort() {
		for (int i = 0; i < JobArray.length; i++) {
			Insertion.sortInsert(JobArray[i]);
			assertTrue(Insertion.isSorted(JobArray[i]));
		}
	}
	
	@Test
	public void testInsertComparable() {
		for (int i = 0; i < JobArray.length; i++) {
			Insertion.sortComparable(JobArray[i], JobArray[i].length);
			assertTrue(Insertion.isSorted(JobArray[i]));
		}
	}
	
	@Test
	public void testInsertBinary() {
		for (int i = 0; i < JobArray.length; i++) {
			Insertion.sortBinary(JobArray[i], JobArray[i].length);
			assertTrue(Insertion.isSorted(JobArray[i]));
		}
	}

}
