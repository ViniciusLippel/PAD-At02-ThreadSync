package array_search;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Main {
	
	public static void main(String[] args) throws InterruptedException {
		
		int arraySize = 5000000;
		final int threadNum = 4;
		int sizeForEach = arraySize/threadNum;
		
		Random rand = new Random();
		
		int[] array = new int[arraySize];
		int value = rand.nextInt(arraySize);
		
		for(int i=0; i<arraySize; i++) {
			array[i] = rand.nextInt(arraySize);
		}
		
		System.out.println("Finding " + value);
		
		
		//Multithread execution
		long start = System.nanoTime();    
		
		for(int i=1; i<=threadNum; i++) {
			if(i == 1)
				new Thread(new SearchThread(array, value, 0, i*sizeForEach-1)).start();
			else
				new Thread(new SearchThread((i-1)*sizeForEach, i*sizeForEach-1)).start();
		}
		
		long multiTElapsedTime = System.nanoTime() - start;
		
		
		
		//Singlethread execution
		int singleTValueIndex = -1;
		boolean done = false;
		int i = 0;
		start = System.nanoTime();
		while(!done && i < arraySize) {
			if(array[i] == value) {
				singleTValueIndex = i;
				done = true;
			}
			i++;
		}
		
		long singleTElapsedTime = System.nanoTime() - start;
		
		
		//
		TimeUnit.MILLISECONDS.sleep(100);
		
		System.out.println("\nMultithread:");
		new SearchThread();
		System.out.println("Index found: " + SearchThread.getValueIndex());
		System.out.println("Elapsed time: " + (float)multiTElapsedTime/1000000 + " ms");
		
		System.out.println("\nSinglethread: ");
		System.out.println("Index found: " + singleTValueIndex);
		System.out.println("Elapsed time: " + (float)singleTElapsedTime/1000000 + " ms");
		
	}
}
