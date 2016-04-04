package sortingForFinalProject;

public class QuickSort {

	public void sort(WeatherEvent[] a) {
		sort(a, 0, a.length - 1);
	}

	public void sort(WeatherEvent[] a, int lo, int hi) {
		if (hi <= lo)
			return;
		int j = partition(a, lo, hi);
		sort(a, lo, j - 1);
		sort(a, j + 1, hi);
	}

	public int partition(WeatherEvent[] a, int lo, int hi) {
		int i = lo, j = hi + 1;
		WeatherEvent k = a[lo];
		while (true) {
			while (a[++i].compareDate(k) < 0)
				if (i == hi)
					break;
			while (a[--j].compareDate(k) > 0)
				if (j == lo)
					break;
			if (i >= j)
				break;
			WeatherEvent temp = a[i];
			a[i] = a[j];
			a[j] = temp;
		}
		WeatherEvent t = a[lo];
		a[lo] = a[j];
		a[j] = t;
		return j;
	}
}
