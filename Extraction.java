import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This class is used for data extraction in the Control.java file.
 * It has no main method, and has only one public method that is used to create WeatherEvent arrays for a
 * given year.
 * 
 * @author Graham Van Deventer
 * @author Liam Duncan
 * @author Adwity Sharma
 * @author Arfa Butt
 * @see Control#Extraction()
 */

public class Extraction {

	/**
	 * This method is used to extract useful information from the data set files.
	 * It reads all the weather events that occurred in a specific year, from the corresponding
	 * data set, and then returns a WeatherEvent [] with all those events.
	 * 
	 * @param year - the year from which all the WeatherEvents are to be taken from
	 * @param maxLine - the maximum WeatherEvents that occurred in the year 'year'
	 * @return yearly - the WeatherEvent [] that is to be returned
	 * @throws FileNotFoundException raised if data set files are not located in the correct location
	 * (i.e. in the Data folder) or are not named right.
	 */	
	public static WeatherEvent [] readData(int year, int maxLine) {
		
		WeatherEvent [] yearly = new WeatherEvent[maxLine];		//Initialize return [] yearly
		
		try {
			File f = new File("Data/StormEvents-"+year+".csv"); //Read from the input file
			Scanner s = new Scanner(f);
			
			String line = s.nextLine();		//Skip the first line
			int i=0;						//Counter for while loop
			
			//Iterate through the data set
		    while (i<maxLine) {
		    	line = s.nextLine();
		    	String[] l = line.split(",");					
		    	
		    	//Split line on each comma so that
		    	// l[15] = Location name
		    	// l[8] = State
		    	// l[0] = YearMonth - beginning (e.g. 200604 which would be 2006/04)
		    	// l[3] = YearMonth - end (e.g. 200604 which would be 2006/04)
		    	// l[1] = Start date
		    	// l[12] = End date 
		    	// l[10] = Year
		    	
		    	yearly[i] = new WeatherEvent (l[15].replaceAll("\"", ""), l[8].replaceAll("\"", ""), 
		    			Integer.parseInt(l[0].substring(4,6)), Integer.parseInt(l[3].substring(4,6)), 
		    			Integer.parseInt(l[1]), Integer.parseInt(l[4]), l[12].replaceAll("\"", ""), 
		    			Integer.parseInt(l[10])) ;
		    	i++;
		    }
		    s.close();						//Close file

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		//Print statement when extraction finishes
		System.out.println("Extraction for " + year + " finished ");	 
		return yearly;
	}
}
