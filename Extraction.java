import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Extraction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WeatherEvent[] year06 = readData(2006, 56400);
		WeatherEvent[] year07 = readData(2007, 59010);
		WeatherEvent[] year08 = readData(2008, 71189);
		WeatherEvent[] year09 = readData(2009, 57398);
		WeatherEvent[] year10 = readData(2010, 62804);
		WeatherEvent[] year11 = readData(2011, 79091);
		WeatherEvent[] year12 = readData(2012, 64503);
		WeatherEvent[] year13 = readData(2013, 59983);
		WeatherEvent[] year14 = readData(2014, 59315);
		WeatherEvent[] year15 = readData(2015, 52955);
		
		System.out.println(year06[0].toString());
		System.out.println(year07[0].toString());
		System.out.println(year08[0].toString());
		System.out.println(year09[0].toString());
		System.out.println(year10[0].toString());
		System.out.println(year11[0].toString());
		System.out.println(year12[0].toString());
		System.out.println(year13[0].toString());
		System.out.println(year14[0].toString());
		System.out.println(year15[0].toString());
	}
	
	public static WeatherEvent [] readData(int year, int maxLine) {
		
		WeatherEvent [] yearly = new WeatherEvent[maxLine];
		
		try {
			File f = new File("Data/StormEvents-"+year+".csv"); // Read from the input file
			Scanner s = new Scanner(f);
			
			String line = s.nextLine();
			int i=0;
		    while (i<maxLine) {
		    	line = s.nextLine();
		    	String[] l = line.split(",");
		    	yearly[i] = new WeatherEvent (l[15].replaceAll("\"", ""), l[8].replaceAll("\"", ""), 
		    			Integer.parseInt(l[0].substring(4,6)), Integer.parseInt(l[3].substring(4,6)), 
		    			Integer.parseInt(l[1]), Integer.parseInt(l[4]), l[12].replaceAll("\"", ""), 
		    			Integer.parseInt(l[10])) ;
		    	i++;
		    }
		    s.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("Extraction for " + year + " finished ");
		return yearly;
	}

}
