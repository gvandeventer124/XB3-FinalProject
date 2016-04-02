package sortingForFinalProject;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
public class Control {

	static WeatherEvent[] year06, year07, year08, year09, year10, year11, year12, 
	year13, year14, year15;
	
	static String[] county06 = new String[56400];
	static String[] county07 = new String[59010];
	static String[] county08 = new String[71189];
	static String[] county09 = new String[57398];
	static String[] county10 = new String[62804];
	static String[] county11 = new String[79091];
	static String[] county12 = new String[64503];
	static String[] county13 = new String[59983];
	static String[] county14 = new String[59315];
	static String[] county15 = new String[52955];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] days = {31,28,30,31,30,31,30,31,30,31,30,31};
		Extraction();
		//UserInputState();
		//UserInputCity();
		//SortByDate();
		sortLocation();
		for(int i = 0; i< 10; i++){
			System.out.println(year06[i].toString());}
		System.out.println(year07[0].toString());
		for(int i = 0; i < days.length; i++){
			for(int j = 1; j <= days[i]; j++){
				//System.out.print("Date: " + (i+1) + "/" + j + " ");
				//Simulate();
			}
		}
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

		MSD.sort(year06);
		MSD.sort(year07);
		MSD.sort(year09);
		MSD.sort(year10);
		MSD.sort(year11);
		MSD.sort(year12);
		MSD.sort(year13);
		MSD.sort(year13);
		MSD.sort(year14);
		MSD.sort(year15);
		
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
