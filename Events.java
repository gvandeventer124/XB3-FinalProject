import java.util.Vector;

public class Events {

	public static WeatherEvent[] get(WeatherEvent[] array, String countyname, String statename) {
		Vector<WeatherEvent> matches = new Vector<WeatherEvent>();
		int instance = binarySearch(array, countyname);

		boolean copyback = true;
		boolean copyforward = true;
		int back = instance;
		int forward = instance + 1;

		//loops iterate in both directions separately collecting events which take place in the given county in the specific state 
		//(counties may be intermixed with such of the same name in other states)
		while (copyback) {
			WeatherEvent current = array[back];
			if (!current.getCounty().equals(countyname)) {
				copyback = false;
			} else {
				if (current.getState().equals(statename))
					matches.add(current);
			}
			back++;
		}
		while (copyforward) {//forward after back, arbitrary but preserves slightly more order
			WeatherEvent current = array[forward];
			if (!current.getCounty().equals(countyname)) {
				copyforward = false;
			} else {
				if (current.getState().equals(statename))
					matches.add(current);
			}
			forward++;
		}

		return (WeatherEvent[]) (matches.toArray());
	}

	private static int binarySearch(WeatherEvent[] array, String county) {
		int index = -1;
		boolean end = false;
		int check = array.length / 2;
		int divisions = 2;
		int looks = 0;

		while (!end) {//basic binary-search algorithm
			WeatherEvent current = array[check];
			if (current.getCounty().equals(county)) {
				index = check;
				end = true;
			} else if (greater(current, county)) {
				divisions *= 2;
				check += array.length / divisions;
			} else {//for less than or 'contains'
				divisions *= 2;
				check -= array.length / divisions;
			}
			looks++;
			if (looks > Math.ceil(Math.log(1 << array.length) / Math.log(2)) + 5)
				end = true;
			//5 is random buffer #. if the algorithm goes over its worst case it implies that the item isn't there and 'check' is bouncing back and forth
		}

		if (index == -1)
			System.err.println("city/county was not found in the data");
		return index;
	}

	private static boolean greater(WeatherEvent event1, String c2) {//greater rather than less because "town" comes before "townsville"
		String c1 = event1.getCounty();

		int shortest = c1.length();//finds which string is shorter to prevent OOB
		if (c2.length() < c1.length())
			shortest = c2.length();

		int index = 0;
		while (index < shortest) {//compares alphabetically
			if (c1.charAt(index) < c2.charAt(index))
				return false;//returns false if less
			index++;
		}

		return true;//may mean one county name contains the other therefore 'greater'
		//if this method is initiated it implies that the index being checked is not the correct county 
		//this means that if it contains it, it must be later in the array (see first method comment)
	}

}
