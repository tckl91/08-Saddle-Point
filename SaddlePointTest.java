package saddle;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SaddlePointTest {
	
	int[][] with;
	int[][] without;

	SaddlePoint SP = new SaddlePoint();
	
	@Before
	public void setUp() throws Exception {
		with = new int[][] {{-9, 12, -6}, {7, 14, 5}, {10, -8, 3}, {6, 17, -10}};
		without = new int[][] {{1, -2, 3}, {-6, 5, -4}, {7, -8, 9}};
	}

	@Test
	public void testCreateRandomArray() {
		int numberOfRows = 30;
		int numberOfColumns = 70;
		int minValue = -100;
		int maxValue = 100;
		int[][] test = SP.createRandomArray(numberOfRows, numberOfColumns, minValue, maxValue);
		
		assertEquals(numberOfRows, test.length); // see if the row number is right
		int testNum = test[0][0];
		boolean allSame = true;
		boolean inRange = true;
		
		for(int i = 0; i < test.length; i++){
			for(int j = 0; j < test.length; j++){
				if (test[i][j] <= minValue){
					inRange = false;
				}
				if (test[i][j] >= maxValue){
					inRange = false;
				}
			}
		}
		
		for(int i = 0; i < test.length; i++) {
			assertEquals(numberOfColumns, test[i].length);
		}
		
		for(int i = 0; i < test.length; i++) {
			for(int j = 0; j < test[i].length; j++) {
				if(test[i][j] != testNum) {
					allSame = false;
				}
			}
		}
		assertFalse(allSame);
		assertTrue(inRange);
	}

	@Test
	public void testLargest() {
		assertEquals(10, SP.largest(new int[] {10, 9, 8, 7, 6, 5, 4, 3, 2, 1}));
		assertEquals(15,SP.largest(new int[] {1, 11, 15, -20, 0, -31}));
		assertEquals(15, SP.largest(new int[] {15, 11, 15, -20}));
	}

	@Test
	public void testSmallest() {
		assertEquals(1, SP.smallest(new int[] {10, 9, 8, 7, 6, 5, 4, 3, 2, 1}));
		assertEquals(-31,SP.smallest(new int[] {1, 11, 15, -20, 0, -31}));
		assertEquals(-20, SP.smallest(new int[] {15, 11, 15, -20}));
	}

	@Test
	public void testLargestValues() {
		assertArrayEquals(new int[] {10, 17, 5}, SP.largestValues(with));
		assertArrayEquals(new int[] {7, 5, 9}, SP.largestValues(without));
	}

	@Test
	public void testSmallestValues() {
		assertArrayEquals(new int[] {-9, 5, -8, -10}, SP.smallestValues(with));
		assertArrayEquals(new int[] {-2, -6, -8}, SP.smallestValues(without));
	}

	@Test
	public void testHasSaddlePoint() {
		assertTrue(SP.hasSaddlePoint(with));
		assertFalse(SP.hasSaddlePoint(without));
	}

	@Test
	public void testSaddlePointRow() {
		assertEquals(1, SP.saddlePointRow(with));
	}

	@Test
	public void testSaddlePointColumn() {
		assertEquals(2, sp.saddlePointColumn(with));
	}
}
