package array_search;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class MainSingleThread {

	public static void main(String[] args) throws InterruptedException {
		
		int arraySize = 100;
		
		Random rand = new Random();
		
		int[] array = new int[arraySize];
		int value = rand.nextInt(arraySize);
		
		for(int i=0; i<arraySize; i++) {
			array[i] = rand.nextInt(arraySize);
		}
		
		System.out.println("Finding " + value);
		System.out.print("in ");
		for(int i=0; i<arraySize; i++)
			System.out.print(array[i] + " ");
		System.out.println();
		
		new Thread(new SearchThread(array, value, 0, arraySize-1)).start();
		
		TimeUnit.SECONDS.sleep(2);
		
		new SearchThread();
		System.out.println(SearchThread.getValueIndex());

	}

}
