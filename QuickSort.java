package sortingForFinalProject;

import java.security.SecureRandom;

public class QuickSort {

	private int[] a;

	public void sort(int[] a) {
		this.a = a;
		sort(a, 0, a.length - 1);
	}

	public void sort(int[] a, int lo, int hi) {
		if (hi <= lo)
			return;
		int j = partition(a, lo, hi);
		sort(a, lo, j - 1);
		sort(a, j + 1, hi);
	}

	public int partition(int[] a, int lo, int hi) {
		int i = lo, j = hi + 1;
		int k = a[lo];
		while (true) {
			while (a[++i] < k)
				if (i == hi)
					break;
			while (k < a[--j])
				if (j == lo)
					break;
			if (i >= j)
				break;
			int temp = a[i];
			a[i] = a[j];
			a[j] = temp;
		}
		int t = a[lo];
		a[lo] = a[j];
		a[j] = t;
		return j;
	}
}
