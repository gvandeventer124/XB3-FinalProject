
import java.io.File;
import java.util.Scanner;
import java.util.Vector;
public class Control {

	static WeatherEvent[] year06, year07, year08, year09, year10, year11, year12, 
	year13, year14, year15;
	
	static WeatherEvent[] year = new WeatherEvent[622648];
  	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] days = {31,28,30,31,30,31,30,31,30,31,30,31};
		Extraction();
		String state = UserInputState();
		String city = UserInputCity();
		city = city.toUpperCase();
		state = state.toUpperCase();
		sortLocation();
		WeatherEvent[] relevant = get(year,city,state);
		for(WeatherEvent a: relevant){
			System.out.println(a.toString());
		}
		//Arfa's second sort
		//eventChance(test);
	}
	public static String UserInputState(){
		
		System.out.println("enter state ");
		Scanner stateread = new Scanner(System.in);
		
		boolean invalid = true;
		int year = 2006;
		String state = stateread.nextLine();
		System.out.println("Please wait");
		while(invalid && year < 2016){
			try{
				
				File f = new File("Data/StormEvents-"+year+".csv"); // Read from the input file
				Scanner s = new Scanner(f);
				while(s.hasNextLine()){
					String line = s.nextLine();
					String[] brokenline = line.split(",");
					if(brokenline[8].compareToIgnoreCase('"'+state+'"') == 0){
						return "valid input "+state;
						
					}
				}
				year++;
			}
			catch(Exception e){
				
			}
		}
		System.out.println("Invalid input of state. Please Try again");
		return UserInputState();
	}
	public static String UserInputCity(){
		System.out.println("enter city");
		Scanner cityread = new Scanner(System.in);
		boolean invalid = true;
		int year = 2006;
		String city = cityread.nextLine();
		System.out.println("Please wait");
		while(invalid && year < 2016){
			try{
				File f = new File("Data/StormEvents-"+year+".csv"); // Read from the input file
				Scanner s = new Scanner(f);
				while(s.hasNextLine()){
					String line = s.nextLine();
					String[] brokenline = line.split(",");
					if(brokenline[15].compareToIgnoreCase('"'+city+'"') == 0){
						return "valid input "+city;
						//System.out.println(brokenline[15]);
					}
				}
				year++;
			}
			catch(Exception e){
				
			}
		}
		return"";
		//System.out.println("Invalid input of state. Please Try again");
		//return UserInputCity();
	}

	public static void SortByDate(){
		System.out.println("Sorting remaining WeatherEvents by date");
	}
	public static void Simulate(){
		System.out.println("Simulating");
	}
	
	public static String[] makeCounty(String[] county, WeatherEvent[] year) {
		for(int i=0; i<year.length; i++) {
			county[i] = year[i].getCounty();
		}
		//System.out.println("county done");
		return county;
	}
   
	public static void sortLocation(){
		MSD.sort(year);
    }
	public static void Extraction() {
		year06 = Extraction.readData(2006, 56400);
		year07 = Extraction.readData(2007, 59010);
		year08 = Extraction.readData(2008, 71189);
		year09 = Extraction.readData(2009, 57398);
		year10 = Extraction.readData(2010, 62804);
		year11 = Extraction.readData(2011, 79091);
		year12 = Extraction.readData(2012, 64503);
		year13 = Extraction.readData(2013, 59983);
		year14 = Extraction.readData(2014, 59315);
		year15 = Extraction.readData(2015, 52955);
		for(int i = 0; i<56400;i++){
			year[i] = year06[i];
		}
		for(int i = 0; i < 59010; i++){
			year[56400+i] = year07[i];
		}
		for(int i = 0; i < 71189;i++){
			year[115410+i] = year08[i];
		}
		for(int i = 0; i < 57398;i++){
			year[186599+i] = year09[i];
		}
		for(int i = 0; i < 62804;i++){
			year[243997+i] = year10[i];
		}
		for(int i = 0; i < 79091;i++){
			year[306801+i] = year11[i];
		}
		for(int i = 0; i < 64503;i++){
			year[385892+i] = year12[i];
		}
		for(int i = 0; i < 59983;i++){
			year[450395+i] = year13[i];
		}
		for(int i = 0; i < 59315;i++){
			year[510378+i] = year14[i];
		}
		for(int i = 0; i < 52955;i++){
			year[569693+i] = year15[i];
		}
	}
public static void eventChance(WeatherEvent[] a){
		
		final int TOTAL = 10;
		int N = a.length;			//length of a; presumably 10
		int n = 0;					//number of event types, excluding clear days
		String[] events = new String[N];
		String[] uniqueElements = new String[N];

		for(int i = 0; i<N ;i++){
			events[i] = a[i].getType();
		}

		for(int i = 0; i<N; i++){
			for(int j = 0; j<N; j++){
				if (events[i].equals(uniqueElements[j]))
					break;
				else if (uniqueElements[j] == null){
					uniqueElements[n] = events[i];
					n++;
					break;
				}
			}
		}
		
		for(int i =0; i<n; i++){
			int count = 0;
			for(int j = 0; j<N; j++){
				if(uniqueElements[i].equals(events[j])){
					count ++;
				}
			}
			double likely = (count*100.0/TOTAL);
			likely = Math.round(likely * 1000.)/1000.;
			System.out.println("chance of " +uniqueElements[i] + " = " + likely + "% ");
		}
		
		double likely = (TOTAL - N)*100.0/TOTAL;
		likely = Math.round(likely * 1000.)/1000.;
		System.out.println("chance of a clear day = " + likely + "% ");
		
	}
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
