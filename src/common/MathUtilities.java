package common;

public class MathUtilities {
	public static int mean(int[] array) {
		int sum = 0;
		
		for(int pos = 0; pos < array.length; ++pos) {
			sum += array[pos];
		}
		
		return (sum / array.length);
	}
}
