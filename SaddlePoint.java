//Author: Kai Cheng

package saddle;
import java.util.Random;

public class SaddlePoint {
	static int[][] createRandomArray(int numberOfRows, int numberOfColumns, int minValue, int maxValue){
		int[][] randomArray = new int[numberOfRows][numberOfColumns];
		Random rand = new Random();
		
		for (int i = 0; i < numberOfRows; i++){
			for (int j = 0; j < numberOfColumns; j++){
				int randNum = rand.nextInt(maxValue - minValue + 1);
				randomArray[i][j] = randNum + minValue;
			}
		}
		return randomArray;
	}
	
	static int largest(int[] array){
		int largest = array[0];
		
		for (int i = 0; i < array.length; i++){
			if (array[i] > largest){
				largest = array[i];
			}
		}
		return largest;
	}
	
	static int smallest(int[] array){
		int smallest = array[0];
		
		for (int i = 0; i < array.length; i++){
			if (array[i] < smallest){
				smallest = array[i];
			}
		}
		return smallest;
	}
	
	static int[] largestValues(int[][] array){
		int[] largest = new int[array[0].length];
		int[][] TransArray = new int[array[0].length][array.length];
		
		for (int p = 0; p < array[0].length; p++){
			for (int q = 0; q < array.length; q++){
				TransArray[p][q] = array[q][p];
			}
		}

		for (int i = 0; i < array[0].length; i++){
			largest[i] = largest(TransArray[i]);
		}
		return largest;
	}
	
	static int[] smallestValues(int[][] array){
		int[] smallest = new int[array.length];

		for (int i = 0; i < array.length; i++){
			smallest[i] = smallest(array[i]);
		}
		return smallest;
	}
	
	static boolean hasSaddlePoint(int[][] array){
		return (largest(smallestValues(array)) == smallest(largestValues(array)));
	}

	static int saddlePointRow(int[][] array){
		int saddlePoint = largest(smallestValues(array));
		int row = 0;
		
		for (int i = 0; i < array.length; i++){
			for (int j = 0; j < array[0].length; j++){
				if (array[i][j] == saddlePoint){
					row = i;
				}
			}
		}
		return (row + 1);
	}
	
	static int saddlePointColumn(int[][] array){
		int saddlePoint = largest(smallestValues(array));
		int column = 0;
		
		for (int i = 0; i < array.length; i++){
			for (int j = 0; j < array[0].length; j++){
				if (array[i][j] == saddlePoint){
					column = j;
				}
			}
		}
		return (column + 1);
	}
	
	public static void main(String[] args){
		boolean yesSaddle = false;
		boolean noSaddle = false;
		Random random = new Random();
		
		do{
			int numberOfRows = random.nextInt(9) + 2 ; //random number between 2 and 10
			int numberOfColumns = random.nextInt(9) + 2;
			int minValue = 0 - random.nextInt(100);
			int maxValue = random.nextInt(100);
			int[][] newArray = createRandomArray(numberOfRows, numberOfColumns, minValue, maxValue);
			
			printArray(newArray);
			printArrayInfo(newArray);

			System.out.println("-----------------------------------------------------------------------");
			
			if (hasSaddlePoint(newArray)){
				yesSaddle = true;
			}
			
			else{
				noSaddle = true;
			}
		}while(!(yesSaddle && noSaddle));
	}
	
	public static void printArray(int[][] array){
		for (int i = 0; i < array.length; i++){
			for (int j = 0; j < array[0].length; j++){
				System.out.print(array[i][j] + "\t");
			}
			System.out.println();
		}
	}
	
	public static void printArrayInfo(int[][] array){
		if (hasSaddlePoint(array)){
			System.out.println("Saddlepoint is at Row " + saddlePointRow(array) + ", Column " + saddlePointColumn(array));	
		}
		else{
			System.out.println("There isn't a saddlepoint!");
		}
	}
}
