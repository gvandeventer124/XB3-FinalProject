
public class WeatherEvent {
	private String county;
	private String state;
	private int startMonth;
	private int endMonth;
	private int startDay;
	private int endDay;
	private String eventType;
	private int year;
	
	public WeatherEvent(String c, String s, int sM, int eM, int sD, int eD, String eT, int y){
		county = c;
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
		return (this.startMonth + "/" + this.startDay + "/" + this.year + " - " + 
			this.endMonth + "/" + this.endDay + "/" + this.year);
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
		int citycheck = this.county.compareToIgnoreCase(other.county); 
		int statecheck = this.state.compareToIgnoreCase(other.state);
		if (statecheck != 0){
			return statecheck;
		}
		else{
			return citycheck;
		}
	}
	public int compareType(WeatherEvent other){
		return this.eventType.compareToIgnoreCase(other.eventType);
	}
	public String toString(){
		return (this.eventType + "\n" + this.county + ", " + this.state + "\n" + getDate());
	}
}
