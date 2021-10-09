package array_search;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Main {
	
	public static void main(String[] args) throws InterruptedException {
		
		int arraySize = 20;
		final int threadNum = 4;
		int sizeForEach = arraySize/threadNum;
		
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
		
		for(int i=1; i<=threadNum; i++) {
			if(i == 1)
				new Thread(new SearchThread(array, value, 0, i*sizeForEach-1)).start();
			else
				new Thread(new SearchThread((i-1)*sizeForEach, i*sizeForEach-1)).start();
		}
		
		
		TimeUnit.SECONDS.sleep(2);
		
		System.out.println(new SearchThread().getValueIndex());
		
	}
}
