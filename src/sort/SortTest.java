package sort;

import static org.junit.Assert.fail;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class SortTest {
	Comparable[][] jobArray = new Comparable[5][];
	

	@Before
	public void setUp() throws Exception {
		final String baseDir = this.getClass().getResource("").getPath();
		Path filePath = Paths.get(baseDir, "../data/a2_in.txt");
		List<String> fileData = Files.readAllLines(filePath, Charset.defaultCharset());
        
        for (int line = 0; line < fileData.size(); line++) {
        	String[] lineArray = fileData.get(line).split("},");
        	for (int i = 0; i < lineArray.length; i++) {
        		lineArray[i] = lineArray[i].substring(1);
        	}
        	jobArray[line] = lineArray;
        }
	}

	@Test
	public void testInsertSort() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testInsertComparable() {
		fail("Not yet implemented");

	}
	
	@Test
	public void testInsertBinary() {
		fail("Not yet implemented");

	}

}
