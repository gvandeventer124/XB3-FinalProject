
public class WeatherEvent {
	private String city;
	private String state;
	private int startMonth;
	private int endMonth;
	private int startDay;
	private int endDay;
	private String eventType;
	private int year;
	
	public WeatherEvent(String c, String s, int sM, int eM, int sD, int eD, String eT, int y){
		city = c;
		state = s;
		startMonth = sM;
		endMonth = eM;
		startDay = sD;
		endDay = eD;
		eventType = eT;
		year = y;
	}
	public String getType(){
		return this.eventType;
	}
	public String getDate(){
		return (this.startMonth + "/" + this.startDay + "/" + this.year + " - " + this.endMonth + "/" + this.endDay + "/" + this.year);
	}
	public String getCounty(){
		return(this.city);
	}
	public String getState(){
		return(this.state);
	}
	public int compareDate(WeatherEvent other){
		if(other.startMonth == this.startMonth){
			if(other.startDay == this.startDay){//same date
				return 0;
			}
			else if(other.startDay > this.startDay){//other comes first
				return 1;
			}
			else{//this comes first
				return -1;
			}
		}
		else if(other.startMonth < this.startMonth){//other comes first
			return 1;
		}
		else{//this comes first
			return -1;
		}
	}
	public int compareLocation(WeatherEvent other){
		int citycheck = this.city.compareToIgnoreCase(other.city); 
		//int statecheck = this.state.compareToIgnoreCase(other.state);
		
		return citycheck;
	}
	public int compareType(WeatherEvent other){
		return this.eventType.compareToIgnoreCase(other.eventType);
	}
	public String toString(){
		return (this.city + ", " + this.state + ". " + this.getDate() + " " + this.getType());
	}
	public static void main(String[] args){
		WeatherEvent test = new WeatherEvent("Hamilton","Ontario",1,1,3,4,"Blizzard",2016);
		System.out.println(test.getDate());
		System.out.println(test.getType());
		System.out.println(test.toString());
		WeatherEvent test2 = new WeatherEvent("Calgary","Alberta",2,2,3,6,"Extreme Cold",2016);
		System.out.println(test.compareDate(test2));
		System.out.println(test.compareLocation(test2) >= 0);
		System.out.println(test.compareType(test2) >= 0);
		
	}
}
