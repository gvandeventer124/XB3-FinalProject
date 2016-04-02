package sortingForFinalProject;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class Control {

	static WeatherEvent[] year06, year07, year08, year09, year10, year11, year12, 
	year13, year14, year15;
	
	static WeatherEvent[] year = new WeatherEvent[622648];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] days = {31,28,30,31,30,31,30,31,30,31,30,31};
		Extraction();
		//UserInputState();
		//UserInputCity();
		//SortByDate();
		sortLocation();
		for(int i = 0; i< 20; i++){
			System.out.println(year[i].toString());}
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

		
		for (int i=0; i<56400; i++) {
			year[i] = year06[i];
		}
		for (int i=0; i<59010; i++) {
			year[56400+i] = year07[i];
		}
		for (int i=0; i<71189; i++) {
			year[115410+i] = year08[i];
		}
		for (int i=0; i<57398; i++) {
			year[186599+i] = year09[i];
		}
		for (int i=0; i<62804; i++) {
			year[243997+i] = year10[i];
		}
		for (int i=0; i<79091; i++) {
			year[306801+i] = year11[i];
		}
		for (int i=0; i<64503; i++) {
			year[385892+i] = year12[i];
		}
		for (int i=0; i<59983; i++) {
			year[450395+i] = year13[i];
		}
		for (int i=0; i<59315; i++) {
			year[510378+i] = year14[i];
		}
		for (int i=0; i<52955; i++) {
			year[569693+i] = year15[i];
		}
	}
}
