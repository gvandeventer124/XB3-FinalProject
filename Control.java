package sortingForFinalProject;
public class Control {

	static WeatherEvent[] year06, year07, year08, year09, year10, year11, year12, 
	year13, year14, year15;
	
	public static void main(String[] args) {

		
		// TODO Auto-generated method stub
		int [] days = {31,28,30,31,30,31,30,31,30,31,30,31};
		UserInputState();
		UserInputCity();
		Extraction.main(null);
		SortByDate();
		for(int i = 0; i < days.length; i++){
			for(int j = 1; j <= days[i]; j++){
				System.out.print("Date: " + (i+1) + "/" + j + " ");
				Simulate();
			}
		}
	}
	public static WeatherEvent[] UserInputState(){
		System.out.println("Extracting all WeatherEvents for selected State");
		return new WeatherEvent[0];
	}
	public static WeatherEvent[] UserInputCity(){
		System.out.println("Extracting all WeatherEvents for selected City");
		return new WeatherEvent[0];
	}
	public static void SortByDate(){
		System.out.println("Sorting remaining WeatherEvents by date");
	}
	public static void Simulate(){
		System.out.println("Simulating");
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
	}
}
