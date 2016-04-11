/**
 * This class contains methods for sorting a WeatherEvent [] alphabetically by their location.
 * The class sorts the WeatherEvent [] using MSD radix sort. The original version of MSD.java has been taken 
 * from the Algorithms textbook, and has been modified to sort a WeatherEvent [] rather than a string [].
 * 
 * @author Graham Van Deventer
 * @author Liam Duncan
 * @author Adwity Sharma
 * @author Arfa Butt
 */

public class MSD {
    private static final int R             = 256;   // extended ASCII alphabet size
    private static final int CUTOFF        =  15;   // cutoff to insertion sort

    // do not instantiate
    private MSD() { } 

   /**
     * Rearranges the array of WeatherEvent strings in ascending order of their location.
     *
     * @param a the WeatherEvent array to be sorted
     */
    public static void sort(WeatherEvent[] a) {
        int N = a.length;
        WeatherEvent[] aux = new WeatherEvent[N];
        sort(a, 0, N-1, 0, aux);
    }

    // return dth character of s, -1 if d = length of string
    private static int charAt(WeatherEvent s, int d) {
        assert d >= 0 && d <= s.getCounty().length();
        if (d == s.getCounty().length()) return -1;
        return s.getCounty().charAt(d);
    }

    // sort from a[lo] to a[hi], starting at the dth WeatherEvent
    private static void sort(WeatherEvent[] a, int lo, int hi, int d, WeatherEvent[] aux) {

        // cutoff to insertion sort for small subarrays
        if (hi <= lo + CUTOFF) {
            insertion(a, lo, hi, d);
            return;
        }

        // compute frequency counts
        int[] count = new int[R+2];
        for (int i = lo; i <= hi; i++) {
            int c = charAt(a[i], d);
            count[c+2]++;
        }

        // transform counts to indicies
        for (int r = 0; r < R+1; r++)
            count[r+1] += count[r];

        // distribute
        for (int i = lo; i <= hi; i++) {
            int c = charAt(a[i], d);
            aux[count[c+1]++] = a[i];
        }

        // copy back
        for (int i = lo; i <= hi; i++) 
            a[i] = aux[i - lo];


        // recursively sort for each character (excludes sentinel -1)
        for (int r = 0; r < R; r++)
            sort(a, lo + count[r], lo + count[r+1] - 1, d+1, aux);
    }


    // insertion sort a[lo..hi], starting at dth WeatherEvent
    private static void insertion(WeatherEvent[] a, int lo, int hi, int d) {
        for (int i = lo; i <= hi; i++)
            for (int j = i; j > lo && less(a[j], a[j-1], d); j--)
                exch(a, j, j-1);
    }

    // exchange a[i] and a[j]
    private static void exch(WeatherEvent[] a, int i, int j) {
        WeatherEvent temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    // is (location of) v less than (location of) w, starting at WeatherEvent d
    private static boolean less(WeatherEvent v, WeatherEvent w, int d) {
        for (int i = d; i < Math.min(v.getCounty().length(), w.getCounty().length()); i++) {
            if (v.getCounty().charAt(i) < w.getCounty().charAt(i)) return true;
            if (v.getCounty().charAt(i) > w.getCounty().charAt(i)) return false;
        }
        return v.getCounty().length() < w.getCounty().length();
    }
}
