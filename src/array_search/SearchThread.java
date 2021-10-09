package array_search;

public class SearchThread implements Runnable {
	
	private static int[] array;
	private static int value;
	private int begIndex;
	private int endIndex;
	private static boolean done = false;
	private static int valueIndex = -1;
	
	
	public SearchThread() {
		
	}
	
	public SearchThread(int[] array, int value, int begIndex, int endIndex) {
		SearchThread.array = array;
		SearchThread.value = value;
		this.begIndex = begIndex;
		this.endIndex = endIndex;
	}
	
	public SearchThread(int begIndex, int endIndex) {
		this.begIndex = begIndex;
		this.endIndex = endIndex;
	}
	
	public static int getValueIndex() {
		return valueIndex;
	}

	public void run() {
		search();
	}
	
	public void search() {
		int i = this.begIndex;
		
		while(i <= this.endIndex && !done){
			if(array[i] == value) {
				valueIndex = i;
				done = true;
			}
			System.out.println("search [" + i + ", " + array[i] + "]");
			i++;
		}
	}
}
