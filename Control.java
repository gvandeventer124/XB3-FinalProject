package sortingForFinalProject;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
public class Control {

	static WeatherEvent[] year06, year07, year08, year09, year10, year11, year12, 
	year13, year14, year15;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] days = {31,28,30,31,30,31,30,31,30,31,30,31};
		//Extraction
		System.out.print("");
		UserInputState();
		UserInputCity();
		SortByDate();
		for(int i = 0; i < days.length; i++){
			for(int j = 1; j <= days[i]; j++){
				System.out.print("Date: " + (i+1) + "/" + j + " ");
				Simulate();
			}
		}
	}
	public static String UserInputState(){
		Scanner stateread = new Scanner(System.in);
		boolean invalid = true;
		int year = 2006;
		String state = stateread.nextLine();
		while(invalid && year < 2016){
			try{
				File f = new File("Data/StormEvents-"+year+".csv"); // Read from the input file
				Scanner s = new Scanner(f);
				while(s.hasNextLine()){
					String line = s.nextLine();
					String[] brokenline = line.split(",");
					if(brokenline[8].compareToIgnoreCase('"'+state+'"') == 0){
						return state;
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
		Scanner cityread = new Scanner(System.in);
		boolean invalid = true;
		int year = 2006;
		String city = cityread.nextLine();
		while(invalid && year < 2016){
			try{
				File f = new File("Data/StormEvents-"+year+".csv"); // Read from the input file
				Scanner s = new Scanner(f);
				while(s.hasNextLine()){
					String line = s.nextLine();
					String[] brokenline = line.split(",");
					if(brokenline[15].compareToIgnoreCase('"'+city+'"') == 0){
						return city;
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
