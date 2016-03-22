package [insert package name];

import java.util.Arrays;

public class genericMerge {
	/**
	 * merge sort using Comparable returns a sorted version of the array
	 * referred to
	 * 
	 * @param x
	 *            - the input array containing times of jobs that need to be
	 *            sorted.
	 * @param n
	 *            - the size of the input array
	 * 
	 * @author Liam Duncan - original, no references to outside sources
	 */

	public static WeatherEvent[] sort(WeatherEvent[] x, int n) {//recursive
		if (n == 1 || n == 0) {
			return x;
		} else {
			int splitpoint = n / 2;//designates where the array will break
			int remainder = n - splitpoint;//n for the next call, eliminates risk of losing an item to integer division
			WeatherEvent[] returnArray = new WeatherEvent[n];
			WeatherEvent[] left = Arrays.copyOfRange(x, 0, splitpoint);//splits array approx. in half and sorts recursively (allows for one subarray each of even and of odd length)
			WeatherEvent[] right = Arrays.copyOfRange(x, splitpoint, n);
			WeatherEvent[] leftSorted = sort(left, splitpoint);
			WeatherEvent[] rightSorted = sort(right, remainder);
			int j = 0, k = 0;
			for (int i = 0; i < n; i++) {//merges the two smaller sorted arrays
				if (j != splitpoint && k != remainder) {
					if (leftSorted[j].less(rightSorted[k])) {
						returnArray[i] = leftSorted[j];
						j++;
					} else {//sets in final array if less than or equal to competing value
						returnArray[i] = rightSorted[k];
						k++;
					}
				} else {
					if (j != splitpoint) {//fills return array with series of items in one array that turned out larger than anything in the other array
						returnArray[i] = leftSorted[j];
					} else if (k != remainder) {
						returnArray[i] = rightSorted[k];
					}
				}
			}
			return returnArray;
		}
	}
}
